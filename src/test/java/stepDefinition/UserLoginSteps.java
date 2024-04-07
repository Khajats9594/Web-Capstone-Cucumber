package stepDefinition;


import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.LandingPage;
import pages.LoginPage;

public class UserLoginSteps {
    private LoginPage loginPage;
    private LandingPage landingPage;

    @Given("I am on the login page")
    public void iAmOnLoginPage() {
        loginPage = LandingPage.getInstance()
                .navigateToLoginPage();
        System.out.println("Step: I am on the login page");
    }

    @When("I enter {string} in the username text field and {string} in the password text field")
    public void iEnterUsernameAndPassword(String username, String password) {

        loginPage.enterLoginDetails(username,password);
        System.out.println("Step: I enter username: " + username + " and password: " + password);
    }

    @When("I click on login")
    public void iClickOnLogin() {

        landingPage = loginPage.clickOnLoginFormBtn();
        System.out.println("Step: I click on login");
    }

    @Then("I should be logged in and redirected to the landing page and username {string} should appear in landing page")
    public void iShouldBeLoggedInAndRedirected(String username) {

        String loginUserName = landingPage.getLoginUserName();
        Assert.assertTrue(loginUserName.equalsIgnoreCase(username),
                "user is not successfully login into application");
        System.out.println("Step: I should be logged in and redirected to the landing page");
    }

    @Then("I should see an error message")
    public void iShouldSeeErrorMessage() {
        System.out.println("Step: I should see an error message");
        // Code to verify that an error message is displayed
    }

    @Then("I should see the fields highlighted in red indicating missing information")
    public void iShouldSeeFieldsHighlightedInRed() {
        System.out.println("Step: I should see the fields highlighted in red indicating missing information");
        // Code to verify that the fields are highlighted in red
    }
    @When("I enter {string} in the username text field and {string} in the password text field and click on login")
    public void iEnterUsernameAndPasswordAndClickLogin(String username, String password) {
        System.out.println("Step: I enter username: " + username + " and password: " + password + " and click on login");
    }

    @When("I click on login without filling in any credentials")
    public void iClickOnLoginWithoutFillingCredentials() {
        System.out.println("Step: I click on login without filling in any credentials");

    }
}
