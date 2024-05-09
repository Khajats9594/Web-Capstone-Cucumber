package zonespages;

import enums.WaitStrategy;
import org.openqa.selenium.By;


public class ServicePage extends BasePage{

    public static ServicePage getInstance(){
        return new ServicePage();
    }

    private final By iFrame = By.id("AppLandingPage");
    private final By zonesSalesAndService = By.xpath("//div[@title='Zones Sales & Service']");

    public LandingPage clickOnZonesSalesAndService(){
        switchToIframe(iFrame,WaitStrategy.NONE);
        click(zonesSalesAndService, WaitStrategy.CLICKABLE);
        return new LandingPage();
    }
}
