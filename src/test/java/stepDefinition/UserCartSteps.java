package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Book;

import java.util.List;

public class UserCartSteps {

    @Given("I search and add the following Harry Potter books to the cart:")
    public void searchAndAddBooksToCart(List<Book> books) {
        System.out.println("Step: I search and add the following Harry Potter books to the cart:");
        for (Book book : books) {
            System.out.println("Title: " + book.getTitle() + "," + book.getPrice());
        }
        // Code to search for the books and add them to the cart
    }

    @Given("each book has a quantity of {int} in the cart")
    public void setQuantity(int quantity) {
        System.out.println("Step: Each book has a quantity of " + quantity + " in the cart");
        // Code to set the quantity for each book in the cart
    }

    @When("I fetch the total cart price")
    public void fetchTotalCartPrice() {
        System.out.println("Step: I fetch the total cart price");
        // Code to fetch the total cart price
    }

    @When("I modify the quantity of respective books")
    public void modifyQuantityOfBooks() {
        System.out.println("Step: I modify the quantity of respective books");
        // Code to modify the quantity of respective books
    }

    @Then("the total cart price should be accurately calculated considering the added books and quantities")
    public void verifyTotalCartPrice() {
        System.out.println("Step: The total cart price should be accurately calculated considering the added books and quantities");
        // Code to verify the total cart price calculation
    }

    @Then("the total cart price should be updated accordingly")
    public void verifyUpdatedTotalCartPrice() {
        System.out.println("Step: The total cart price should be updated accordingly");
        // Code to verify the updated total cart price after modifying quantities
    }
}
