package test;


import driver.Driver;
import driver.DriverManager;
import enums.ConfigProperties;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utiles.PropertyReader;

public class BaseTest {

    protected BaseTest(){}


    @BeforeMethod
    public void setup() {
        Driver.initDriver("chrome");
       // Driver.initDriver();
    }

    @AfterMethod
    public void tearDown() {
       // Driver.quitDriver();
    }
}
