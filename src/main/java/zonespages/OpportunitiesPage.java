package zonespages;

import enums.WaitStrategy;
import org.openqa.selenium.By;

public class OpportunitiesPage extends BasePage{

    public OpportunitiesPage getInstance(){
        return new OpportunitiesPage();
    }

    private final By topicTxt = By.xpath("//input[@aria-label='Topic']");
    private final By customerObjectiveTxtArea = By.xpath("//textarea[@aria-label='Customer Objective']");
    private final By estimateCloseDate = By.xpath("aria-label='Date of Est. Close Date'");
    private final By day = By.xpath("//button[@aria-label='30, May, 2024']");
    private final By estimateRevenue = By.xpath("//input[@aria-label='Est. Revenue']");
    private final By sellingObjective = By.xpath("aria-label='Selling Objective'");

    public void fillingMandatoryDetailsOfOpportunitiesForm(){
        sendKey(topicTxt,"test098", WaitStrategy.VISIBLE);
        sendKey(customerObjectiveTxtArea,"test098",WaitStrategy.VISIBLE);
        click(estimateCloseDate,WaitStrategy.CLICKABLE);
        click(day,WaitStrategy.CLICKABLE);
        sendKey(estimateRevenue,"12",WaitStrategy.VISIBLE);
        selectByText(sellingObjective,"Software Licensing");
    }
}
