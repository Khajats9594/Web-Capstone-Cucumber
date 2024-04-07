package factories;

import enums.ConfigProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import utiles.PropertyReader;

import java.net.MalformedURLException;
import java.net.URL;

public final class DriverFactory {

    private DriverFactory() {
    }


    public static WebDriver getDriver(String browser) throws MalformedURLException {

        WebDriver driver = null;

        String runMode = PropertyReader.get(ConfigProperties.RUNMODE);
        if (browser.equalsIgnoreCase("chrome")) {
            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName("chrome");
                driver = new RemoteWebDriver(new URL(PropertyReader.get(ConfigProperties.SELENIUMGRIDURL)), cap);
            } else {
                driver = new ChromeDriver();
            }
        } else if (browser.equalsIgnoreCase("firefox")) {

            if (runMode.equalsIgnoreCase("remote")) {
                DesiredCapabilities cap = new DesiredCapabilities();
                cap.setBrowserName("firefox");
                driver = new RemoteWebDriver(new URL(PropertyReader.get(ConfigProperties.SELENIUMGRIDURL)), cap);
            } else {
                driver = new FirefoxDriver();
            }
        }
        return driver;
    }
}
