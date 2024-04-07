package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class LandingPage extends BasePage{

    public static LandingPage getInstance(){
        return new LandingPage();
    }

    private final By loginBtn = By.xpath("//button[@mattooltip='Login']");
    private final By loginUserName = By.xpath("//a[@aria-haspopup='menu']/span[@class='mdc-button__label']/span");

    public LoginPage navigateToLoginPage(){
        click(loginBtn, WaitStrategy.NONE);
        return new LoginPage();
    }

    public String getLoginUserName(){
        return getText(loginUserName,WaitStrategy.NONE);
    }
}
