package pages;

import enums.WaitStrategy;
import models.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utiles.DynamicXpath;
import utiles.JavaScriptUtils;

import java.util.List;

public class LandingPage extends BasePage{

    public static LandingPage getInstance(){
        return new LandingPage();
    }

    private final By loginBtn = By.xpath("//button[@mattooltip='Login']");
    private final By loginUserName = By.xpath("//a[@aria-haspopup='menu']/span[@class='mdc-button__label']/span");
    private final String productAddToCartBtn = "//strong[text()='%replaceable%']//ancestor::div[@class=\"card-title my-2\"]/following-sibling::app-addtocart";
    //strong[text()='%replaceable%']//ancestor::div[@class="card-title my-2"]/following-sibling::app-addtocart/button
    //strong[text()='%replaceable%']//ancestor::mat-card-content[@class='mat-mdc-card-content']//button
    private final By catBtn = By.xpath("//button[@ng-reflect-router-link='/shopping-cart']");

    public LoginPage navigateToLoginPage(){
        click(loginBtn, WaitStrategy.NONE);
        return new LoginPage();
    }

    public String getLoginUserName(){
        return getText(loginUserName,WaitStrategy.NONE);
    }

    public LandingPage addProductsToCart(List<Book> books){
        for (Book book : books){
            try {
                click(By.xpath(DynamicXpath.getXpath(productAddToCartBtn,book.getTitle())),WaitStrategy.CLICKABLE);
            }catch (Exception e){
                List<WebElement> elements = getElements(By.xpath(DynamicXpath.getXpath(productAddToCartBtn, book.getTitle())));
                JavaScriptUtils.scrollIntoView(elements.get(0));
                click(By.xpath(DynamicXpath.getXpath(productAddToCartBtn,book.getTitle())),WaitStrategy.CLICKABLE);
            }
        }
        return this;
    }
    public CartPage clickOnCartBtn(){
        click(catBtn,WaitStrategy.NONE);
        return new CartPage();
    }



}
