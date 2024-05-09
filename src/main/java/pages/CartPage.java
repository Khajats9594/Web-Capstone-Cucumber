package pages;

import enums.WaitStrategy;
import models.Book;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utiles.DynamicXpath;
import utiles.JavaScriptUtils;

import java.util.List;

import static java.awt.SystemColor.text;

public class CartPage extends BasePage{

    public static CartPage getInstance(){
        return new CartPage();
    }

    private final By rows = By.xpath("//table//tbody[@role='rowgroup']/tr/td/a");
    private final String productName = "//table//tbody[@role='rowgroup']/tr[%replaceable%]/td/a";
    private final String addBtn = "(//a[text()='%replaceable%']/parent::td/following-sibling::td[2]//button)[2]";
    private final String productPrice = "//a[text()='%replaceable%']/parent::td/following-sibling::td[3]";
    private final By cartTotalPrice = By.xpath("//strong[text()='Cart Total:']/parent::td/following-sibling::td/strong");


    public CartPage incrementGivenProductsQuantityByOne(List<Book>books){
        List<WebElement> elements = getElements(rows);
        for (int i = 1; i <= elements.size(); i++) {
            String text = getText(By.xpath(DynamicXpath.getXpath(productName, String.valueOf(i))), WaitStrategy.NONE);;
            for (Book book : books) {
                if (text.equalsIgnoreCase(book.getTitle())) {
                    incrementing(book, text);
                    break;
                }
            }
        }
        return this;
    }

    private void incrementing(Book book, String text) {
        try {
            click(By.xpath(DynamicXpath.getXpath(addBtn, text)), WaitStrategy.CLICKABLE);
            try {
                Thread.sleep(5000);
            } catch (InterruptedException ex) {
                throw new RuntimeException(ex);
            }

        }catch (Exception e){
            List<WebElement> elements = getElements(By.xpath(DynamicXpath.getXpath(addBtn, book.getTitle())));
            JavaScriptUtils.scrollIntoView(elements.get(0));
            click(By.xpath(DynamicXpath.getXpath(addBtn, text)), WaitStrategy.CLICKABLE);
        }
    }

    public boolean validateSumOfPriceOfProductsWithCartTotalPrice(List<Book>books){
        long sumOfProductPrice = 0;
        List<WebElement> elements = getElements(rows);
        for (int i = 1; i <= elements.size(); i++) {
            String text = getText(By.xpath(DynamicXpath.getXpath(productName, String.valueOf(i))), WaitStrategy.NONE);;
            for (Book book : books){
                if(text.equalsIgnoreCase(book.getTitle())){
                    String price = getText(By.xpath(DynamicXpath.getXpath(productPrice, book.getTitle())), WaitStrategy.NONE);
                    sumOfProductPrice+=Long.parseLong(price.substring(price.indexOf(1)));
                }
            }
        }
        String totalPrice = getText(cartTotalPrice, WaitStrategy.NONE);
        long total = Long.parseLong(totalPrice.substring(totalPrice.indexOf(1)));
        return sumOfProductPrice == total;
    }
}
