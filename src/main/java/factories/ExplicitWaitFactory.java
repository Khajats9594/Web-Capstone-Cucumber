package factories;

import constant.Constants;
import driver.DriverManager;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public final class ExplicitWaitFactory {

    private ExplicitWaitFactory() {
    }

    public static WebElement performExplicitWaitForElement(WaitStrategy waitStrategy, By by) {
        WebElement element = null;
        int attempts = 0;
        while (attempts < Constants.getMAxRetryAttempts()) {
            try {
                element = getWebElementWithWaitStrategy(waitStrategy, by);
                break;
            } catch (StaleElementReferenceException | TimeoutException e) {
                attempts++;
                refreshElement(by,waitStrategy);
                System.out.println("Element retrieval attempt " + attempts);
            }
        }
        return element;
    }
    public static List<WebElement> performExplicitWaitForElements(WaitStrategy waitStrategy, By by) {
        List<WebElement> elements = new ArrayList<>();
        int attempts = 0;
        while (attempts < Constants.getMAxRetryAttempts()) {
            try {
                elements = getWebElementsWithWaitStrategy(waitStrategy, by);
                break;
            } catch (StaleElementReferenceException | TimeoutException e) {
                attempts++;
                refreshElements(by, waitStrategy);
                System.out.println("Element retrieval attempt " + attempts);
            }
        }
        return elements;
    }
    private static WebElement getWebElementWithWaitStrategy(WaitStrategy waitStrategy, By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitWait()));
        switch (waitStrategy) {
            case CLICKABLE:
                return wait.until(ExpectedConditions.elementToBeClickable(by));
            case PRESENCE:
                return wait.until(ExpectedConditions.presenceOfElementLocated(by));
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            case HANDLESTALEELEMENT:
                return refreshAndGetElement(by, wait);
            case NONE:
                return DriverManager.getDriver().findElement(by);
            default:
                throw new IllegalArgumentException("Invalid wait strategy: " + waitStrategy);
        }
    }
    private static WebElement refreshAndGetElement(By by, WebDriverWait wait) {
        return wait.until(d -> {
            d.navigate().refresh();
            return d.findElement(by);
        });
    }
    private static void refreshElement(By by,WaitStrategy waitStrategy) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitWait()));
        if(waitStrategy == WaitStrategy.CLICKABLE) {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.elementToBeClickable(by)));
        } else if (waitStrategy == WaitStrategy.PRESENCE) {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfElementLocated(by)));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfElementLocated(by)));
        }
    }
    private static List<WebElement> getWebElementsWithWaitStrategy(WaitStrategy waitStrategy, By by) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitWait()));
        switch (waitStrategy) {
            case PRESENCE:
                return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
            case VISIBLE:
                return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(by));
            case NONE:
                return DriverManager.getDriver().findElements(by);
            default:
                throw new IllegalArgumentException("Invalid wait strategy: " + waitStrategy);
        }
    }
    private static void refreshElements(By by, WaitStrategy waitStrategy) {
        WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(), Duration.ofSeconds(Constants.getExplicitWait()));
        if (waitStrategy == WaitStrategy.PRESENCE) {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.presenceOfAllElementsLocatedBy(by)));
        } else if (waitStrategy == WaitStrategy.VISIBLE) {
            wait.until(ExpectedConditions.refreshed(ExpectedConditions.visibilityOfAllElementsLocatedBy(by)));
        }
    }
}