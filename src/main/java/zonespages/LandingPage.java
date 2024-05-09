package zonespages;

import enums.LeftMenuSalesComponentsType;
import enums.WaitStrategy;
import lombok.Getter;
import org.openqa.selenium.By;
import zonespages.pagecomponents.LeftMenuSalesComponent;

public class LandingPage extends BasePage {

    @Getter
    private final LeftMenuSalesComponent leftMenuSalesComponent;

    public LandingPage() {
        this.leftMenuSalesComponent = new LeftMenuSalesComponent();
    }

    public static LandingPage getInstance(){
        return new LandingPage();
    }

    private final By dashBoardActionTxt = By.xpath("//span[text()='Action Dashboard']");

    public String getDashBoardActionTxt(){
        return getText(dashBoardActionTxt, WaitStrategy.VISIBLE);
    }

    public <T> T navigateAccountPage(){
        return this.leftMenuSalesComponent.clickLeftMenuSalesComponent(LeftMenuSalesComponentsType.ACCOUNTS);
    }
}
