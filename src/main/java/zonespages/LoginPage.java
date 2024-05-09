package zonespages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class LoginPage extends BasePage{

    private LoginPage(){
    }
    public static LoginPage getInstance(){
        return new LoginPage();
    }

    private final By userName = By.xpath("//input[@name='loginfmt']");
    private final By nextBtn = By.xpath("//input[@value='Next']");
    private final By password = By.xpath("//input[@placeholder='Password']");
    private final By signBtn = By.xpath("//input[@value='Sign in']");
    private final By yesBtn = By.xpath("//input[@value='Yes']");

    public ServicePage login(String username, String pwd){
        sendKey(userName, username,WaitStrategy.VISIBLE);
        click(nextBtn,WaitStrategy.CLICKABLE);
        sendKey(password,pwd,WaitStrategy.VISIBLE);
        click(signBtn,WaitStrategy.CLICKABLE);
        click(yesBtn,WaitStrategy.CLICKABLE);
        return new ServicePage();
    }

}
