package zonespages.pagecomponents;

import enums.LeftMenuSalesComponentsType;
import enums.WaitStrategy;
import org.openqa.selenium.By;
import zonespages.*;

public class LeftMenuSalesComponent extends BasePage {

    private final String leftSalesComponent = "//ul[@aria-label='Sales']/li[@title='%s']";

    public <T> T clickLeftMenuSalesComponent(LeftMenuSalesComponentsType leftMenuSalesComponentsType) {
        String format = String.format(leftSalesComponent, leftMenuSalesComponentsType.getMenuName());
        click(By.xpath(format), WaitStrategy.CLICKABLE);

        switch (leftMenuSalesComponentsType) {
            case DASHBOARDS:
                return (T) new DashBoardPage();
            case ACCOUNTS:
                return (T) new AccountsPage();
            case CONTACTS:
                return (T) new ContactsPage();
            case CASES:
                return (T) new CasesPage();
            case LEADS:
                return (T) new LeadsPage();
            default:
                throw new IllegalArgumentException("Unhandled LeftMenuSalesComponentsType: " + leftMenuSalesComponentsType);
        }
    }

}
