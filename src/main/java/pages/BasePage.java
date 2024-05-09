package pages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {
    protected BasePage() {

    }
    private static final Logger logger = LogManager.getLogger(BasePage.class);
    protected void sendKey(By by, String value, WaitStrategy waitingStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitingStrategy, by);
        element.sendKeys(value, Keys.ENTER);
        logger.info("{} value enter into the element : {}",value,element);
    }

    protected void click(By by, WaitStrategy waitingStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitingStrategy, by);
        element.click();
        logger.info("{} is clicked ",element);
    }

    protected String getText(By by,WaitStrategy waitStrategy) {
        String textOfElement = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by).getText();
        logger.info("{} is fetched",textOfElement);
        return textOfElement;
    }

    protected String getValueAttribute(By by, WaitStrategy waitStrategy){
        String value = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by).getAttribute("value");
        logger.info("value fetch from value attribute is {}",value);
        return value;
    }

    protected boolean isPresent(By by, WaitStrategy waitStrategy){
        return ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy,by).isDisplayed();
    }
    protected void moveOverElement(By by, WaitStrategy waitStrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element);
    }
    protected void selectByVisibleText(By by,String text,WaitStrategy waitStrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Select select = new Select(element);
        select.selectByVisibleText(text);
    }
    protected  void selectByValue(By by,String value, WaitStrategy waitStrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Select select = new Select(element);
        select.selectByValue(value);
    }
    protected void selectByIndex(By by,int index, WaitStrategy waitStrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Select select = new Select(element);
        select.selectByIndex(index);
    }
    protected void selectByOption(By by,String value, WaitStrategy waitStrategy){
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Select select = new Select(element);
        List<WebElement> webElements = select.getAllSelectedOptions();
        for(WebElement ele : webElements){
            if(ele.getText().equalsIgnoreCase(value)){
                ele.click();
                break;
            }
        }
    }
    protected void selectByText(By by,String value){
        List<WebElement> elements = DriverManager.getDriver().findElements(by);
        for (WebElement element : elements){
            if(element.getText().equalsIgnoreCase(value)){
                element.click();
                break;
            }
        }
    }
    protected String getTitle(){
        return DriverManager.getDriver().getTitle();
    }
    protected boolean isEnable(By by, WaitStrategy waitStrategy){
        return ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy,by).isEnabled();
    }

    protected int getSize(By by){
        return DriverManager.getDriver().findElements(by).size();
    }

    protected List<WebElement> getElements(By by){
        return DriverManager.getDriver().findElements(by);
    }
}
