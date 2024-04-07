package pages;

import enums.WaitStrategy;
import models.UserDetail;
import org.openqa.selenium.By;

public class RegistrationPage extends BasePage {

    public static RegistrationPage getInstance(){
        return new RegistrationPage();
    }

    private final By firstNameTxt = By.xpath("//input[@formcontrolname='firstname']");
    private final By lastNameTxt = By.xpath("//input[@formcontrolname='lastname']");
    private final By userNameTxt = By.xpath("//input[@formcontrolname='username']");
    private final By passwordTxt = By.xpath("//input[@formcontrolname='password']");
    private final By confirmPasswordTxt = By.xpath("//input[@formcontrolname='confirmPassword']");
    private final By maleRadioBtn = By.xpath("//input[@type='radio' and @value='Male']");
    private final By femaleRadioBtn = By.xpath("//input[@type='radio' and @value='Female']");
    private final By registeredBtn = By.xpath("//button[@ng-reflect-color='primary']//span[text()='Register']");

    public RegistrationPage fillRegistrationForm(UserDetail userDetail){
        sendKey(firstNameTxt,userDetail.getFirstName(), WaitStrategy.NONE);
        sendKey(lastNameTxt,userDetail.getLastName(),WaitStrategy.NONE);
        sendKey(userNameTxt,userDetail.getUsername(),WaitStrategy.NONE);
        sendKey(passwordTxt,userDetail.getPassword(),WaitStrategy.NONE);
        sendKey(confirmPasswordTxt,userDetail.getConfirmPassword(),WaitStrategy.NONE);
        if(userDetail.getGender().equalsIgnoreCase("Female")){
            click(femaleRadioBtn,WaitStrategy.NONE);
        }
        click(maleRadioBtn,WaitStrategy.NONE);
        return this;
    }

    public LoginPage clickOnRegistration(){
        click(registeredBtn,WaitStrategy.NONE);
        return new LoginPage();
    }

}
