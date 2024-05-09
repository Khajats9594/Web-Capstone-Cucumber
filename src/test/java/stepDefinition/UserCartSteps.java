package stepDefinition;

import driver.Driver;
import driver.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;
import org.testng.Assert;
import pages.CartPage;
import pages.LandingPage;

import java.util.List;

public class UserCartSteps {
    private CartPage cartPage;
    private List<Book> books;
    private  boolean validateSumOfPriceOfProductsWithCartTotalPrice;

    @Given("I search and add the following Harry Potter books to the cart:")
    public void searchAndAddBooksToCart(List<Book> books) {
        String username = "jkikk";
        String password = "Pass@9876";
        this.books = books;
        cartPage = LandingPage.getInstance()
                    .navigateToLoginPage()
                    .enterLoginDetails(username,password)
                    .clickOnLoginFormBtn()
                    .addProductsToCart(books)
                    .clickOnCartBtn();
        System.out.println("Step: I search and add the following Harry Potter books to the cart:");
    }

    @Given("each book has a quantity of {int} in the cart")
    public void setQuantity(int quantity) {
        cartPage.incrementGivenProductsQuantityByOne(books);
        System.out.println("Step: Each book has a quantity of " + quantity + " in the cart");
    }

    @When("I fetch the total cart price")
    public void fetchTotalCartPrice() {
        validateSumOfPriceOfProductsWithCartTotalPrice = cartPage
                .validateSumOfPriceOfProductsWithCartTotalPrice(books);
        System.out.println("Step: I fetch the total cart price");
    }

    @When("I modify the quantity of respective books")
    public void modifyQuantityOfBooks() {
        System.out.println("Step: I modify the quantity of respective books");
    }

    @Then("the total cart price should be accurately calculated considering the added books and quantities")
    public void verifyTotalCartPrice() {
        Assert.assertTrue(validateSumOfPriceOfProductsWithCartTotalPrice,"The total cart price should be accurately calculated");
        System.out.println("Step: The total cart price should be accurately calculated considering the added books and quantities");
    }

    @Then("the total cart price should be updated accordingly")
    public void verifyUpdatedTotalCartPrice() {
        System.out.println("Step: The total cart price should be updated accordingly");
    }
}
