package zonespages;

import enums.WaitStrategy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class AccountInformationPage extends BasePage{

    public AccountInformationPage getInstance(){
        return new AccountInformationPage();
    }
    private final By opportunityEllipse = By.xpath("//button[@title='More commands for Opportunity']");
    private final By newOpportunityBtn = By.xpath("//button[@aria-label='New Opportunity. Add New Opportunity']");
    private final By ownerOfAccount = By.xpath("//div[text()='AM']//preceding-sibling::div/a");

    public AccountInformationPage clickOnOpportunityEllipse(){
        click(opportunityEllipse, WaitStrategy.CLICKABLE);
        return this;
    }
    public String getOwnerOfAccount(){
        return getText(ownerOfAccount,WaitStrategy.VISIBLE);
    }
    public OpportunitiesPage clickOnNewOpportunity(){
        click(newOpportunityBtn,WaitStrategy.CLICKABLE);
        return new OpportunitiesPage();
    }

    public void sample(){
        List<WebElement> elements = getElements(ownerOfAccount);
        List<String> valueFromElements = getValueFromElements(elements, WebElement::getTagName);
    }
}
