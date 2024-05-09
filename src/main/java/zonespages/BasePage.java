package zonespages;

import driver.DriverManager;
import enums.WaitStrategy;
import factories.ExplicitWaitFactory;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utiles.JavaScriptUtils;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class BasePage {
    protected BasePage() {

    }
    private static final Logger logger = LogManager.getLogger(pages.BasePage.class);
    protected void sendKey(By by, String value, WaitStrategy waitingStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitingStrategy, by);
        if (element != null && !element.isDisplayed()) {
            JavaScriptUtils.scrollIntoView(element);
        }
        if (element != null) {
            element.sendKeys(value);
            logger.info("{} value entered into the element: {}", value, element);
        } else {
            logger.error("Element not found after waiting.");
        }
    }

    protected void click(By by, WaitStrategy waitingStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitingStrategy, by);
        if (element != null && !element.isDisplayed()) {
            JavaScriptUtils.scrollIntoView(element);
        }
        if (element != null) {
            element.click();
            logger.info("{} is clicked ", element);
        } else {
            logger.error("Element not found after waiting.");
        }
    }

    public List<String> getValueFromElements(List<WebElement> webElements, Function<WebElement,String> function){
        return webElements.stream()
                .map(function)
                .collect(Collectors.toList());
    }

    protected String getText(By by, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        String textOfElement = element.getText();
        logger.info("Text '{}' fetched from the element: {}", textOfElement, element);
        return textOfElement;
    }

    protected void switchToIframe(By by, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        DriverManager.getDriver().switchTo().frame(element);
        logger.info("Switched to iframe: {}", element);
    }

    protected String getValueAttribute(By by, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        String value = element.getAttribute("value");
        logger.info("Value '{}' fetched from value attribute of element: {}", value, element);
        return value;
    }

    protected boolean isPresent(By by, WaitStrategy waitStrategy) {
        boolean isDisplayed = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by).isDisplayed();
        logger.info("Element is present and displayed: {}", isDisplayed);
        return isDisplayed;
    }

    protected void moveOverElement(By by, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Actions actions = new Actions(DriverManager.getDriver());
        actions.moveToElement(element).perform();
        logger.info("Moved mouse over element: {}", element);
    }

    protected void selectByVisibleText(By by, String text, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Select select = new Select(element);
        select.selectByVisibleText(text);
        logger.info("Selected '{}' by visible text from dropdown: {}", text, element);
    }

    protected void selectByValue(By by, String value, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Select select = new Select(element);
        select.selectByValue(value);
        logger.info("Selected '{}' by value from dropdown: {}", value, element);
    }

    protected void selectByIndex(By by, int index, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Select select = new Select(element);
        select.selectByIndex(index);
        logger.info("Selected option at index '{}' from dropdown: {}", index, element);
    }

    protected void selectByOption(By by, String value, WaitStrategy waitStrategy) {
        WebElement element = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by);
        Select select = new Select(element);
        List<WebElement> options = select.getAllSelectedOptions();
        for (WebElement option : options) {
            if (option.getText().equalsIgnoreCase(value)) {
                option.click();
                logger.info("Selected option '{}' from dropdown: {}", value, element);
                break;
            }
        }
    }

    protected void selectByText(By by, String value) {
        List<WebElement> elements = DriverManager.getDriver().findElements(by);
        for (WebElement element : elements) {
            if (element.getText().equalsIgnoreCase(value)) {
                element.click();
                logger.info("Selected '{}' from the list of elements: {}", value, element);
                break;
            }
        }
    }

    protected String getTitle() {
        String title = DriverManager.getDriver().getTitle();
        logger.info("Current page title: {}", title);
        return title;
    }

    protected boolean isEnable(By by, WaitStrategy waitStrategy) {
        boolean isEnabled = ExplicitWaitFactory.performExplicitWaitForElement(waitStrategy, by).isEnabled();
        logger.info("Element is enabled: {}", isEnabled);
        return isEnabled;
    }

    protected int getSize(By by) {
        int size = DriverManager.getDriver().findElements(by).size();
        logger.info("Number of elements found: {}", size);
        return size;
    }

    protected List<WebElement> getElements(By by) {
        List<WebElement> elements = DriverManager.getDriver().findElements(by);
        logger.info("Found {} elements with locator: {}", elements.size(), by);
        return elements;
    }
}
