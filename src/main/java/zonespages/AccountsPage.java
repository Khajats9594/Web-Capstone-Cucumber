package zonespages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import utiles.DynamicXpath;

public class AccountsPage extends BasePage{

    public static AccountsPage getInstance(){
        return new AccountsPage();
    }
    private final String account = "//a[@aria-label='%replaceable%']";

    public AccountInformationPage clickOnAccountName(String accountName){
        click(By.xpath(DynamicXpath.getXpath(account,accountName)), WaitStrategy.CLICKABLE);
        return new AccountInformationPage();
    }

}
