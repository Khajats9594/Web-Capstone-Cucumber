package driver;

import constant.Constants;
import enums.ConfigProperties;
import factories.DriverFactory;
import utiles.PropertyReader;

import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Objects;

public final class Driver {

    private Driver() {}


    public static void initDriver(String browser)  {


        if(Objects.isNull(DriverManager.getDriver())) {
            try {
                DriverManager.setDriver(DriverFactory.getDriver(browser));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Please check the capabilities of browser");
            }
            DriverManager.getDriver().get(PropertyReader.get(ConfigProperties.URL));
            DriverManager.getDriver().manage().window().maximize();
            DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.getExplicitWait()));
        }
    }
    public static void quitDriver() {
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
