package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import zonespages.AccountInformationPage;
import zonespages.AccountsPage;
import zonespages.BasePage;
import zonespages.LoginPage;

public class Sample extends BaseTest{
    LoginPage loginPage;
    AccountsPage accountsPage;
    AccountInformationPage accountInformationPage;

    @Test
    public void loginFunction(){
        // Arrange
        String userName = "";
        String password = "";

        // Act
        String dashBoardActionTxt = LoginPage.getInstance()
                .login(userName, password)
                .clickOnZonesSalesAndService()
                .getDashBoardActionTxt();

        // Assert
        Assert.assertEquals(dashBoardActionTxt,"Action Dashboard","user is not able login in to application");
    }

    @Test(description = "Create new opportunity from Account screen")
    public void verifyOpportunityCreationFromAccountPage(){
        // Arrange
        String userName = "";
        String password = "";
        String accountName = "AMBIUS INC.";

        // Act
        loginPage = LoginPage.getInstance();
        loginPage.login(userName,password).clickOnZonesSalesAndService().navigateAccountPage();
        accountsPage = AccountsPage.getInstance();
        accountInformationPage = accountsPage.clickOnAccountName(accountName);
        String ownerOfAccount = accountInformationPage.getOwnerOfAccount();
        accountInformationPage.clickOnOpportunityEllipse().clickOnNewOpportunity().fillingMandatoryDetailsOfOpportunitiesForm();

        Assert.assertEquals(ownerOfAccount,"User 18756487351","owner of account and Sales user not matched");

    }

    public static void main(String[] args) {

    }
}
