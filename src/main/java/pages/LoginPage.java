package pages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    public static LoginPage getInstance(){
        return new LoginPage();
    }

    private final By registrationBtn = By.xpath("//button[@ng-reflect-router-link='/register']");
    private final By loginFormTitle = By.xpath("//mat-card-title[contains(text(),'Login')]");
    private final By userNameTxt = By.xpath("//input[@formcontrolname='username']");
    private final By passwordTxt = By.xpath("//input[@formcontrolname='password']");
    private final By loginFormBtn = By.xpath("//button[@ng-reflect-color='primary']//span[text()='Login']");

    public RegistrationPage navigateToRegistrationPage(){
        click(registrationBtn, WaitStrategy.NONE);
        return new RegistrationPage();
    }

    public String getLoginFormTitle(){
        return getText(loginFormTitle,WaitStrategy.NONE);
    }

    public LoginPage enterLoginDetails(String userName, String password){
        sendKey(userNameTxt,userName,WaitStrategy.NONE);
        sendKey(passwordTxt,password,WaitStrategy.NONE);
        return this;
    }
    public LandingPage clickOnLoginFormBtn(){
        click(loginFormBtn,WaitStrategy.NONE);
        return new LandingPage();
    }

}
