package stepDefinition;


import driver.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.UserDetail;
import org.testng.Assert;
import pages.LandingPage;
import pages.LoginPage;
import pages.RegistrationPage;

public class UserRegistrationSteps {


    private RegistrationPage registrationPage;
    private static boolean registrationExecuted = false;
    public LoginPage loginPage;

    @Before(order = 0)
    public void setup(){
        Driver.initDriver("chrome");
    }
//    @Before(order = 1, value = "@run")
//    public void runRegistrationIfNotExecuted(Scenario scenario) {
//        if (!registrationExecuted && scenario.getSourceTagNames().contains("@run")) {
//            // Execute registration scenario
//            System.out.println("Running User Registration Scenario");
//            // Your logic to execute registration scenario goes here
//            registrationExecuted = true;
//        }
//    }
//
//    @Before(order = 2, value = "@run")
//    public void runLoginIfRegistrationExecuted(Scenario scenario) {
//        if (registrationExecuted && scenario.getSourceTagNames().contains("@run")) {
//            // Execute login scenario
//            System.out.println("Running User Login Scenario");
//            // Your logic to execute login scenario goes here
//        }
//    }
    @After
    public void tearDown(){
        Driver.quitDriver();
    }

    @Given("I am on the registration page")
    public void iAmOnTheRegistrationPage() {

        registrationPage = LandingPage.getInstance()
                .navigateToLoginPage()
                .navigateToRegistrationPage();

        System.out.println("Step: I am on the registration page");
    }

    @When("I fill in the registration form with the following details")
    public void iFillInTheRegistrationFormWithTheFollowingDetails(UserDetail userDetails) {
        registrationPage.fillRegistrationForm(userDetails);
        System.out.println("Step: I fill in the registration form with the following details");
    }

    @When("I submit the form")
    public void iSubmitTheForm() {
        loginPage = registrationPage.clickOnRegistration();
        System.out.println("Step: I submit the form");
    }

    @Then("I should be redirected to the login page")
    public void iShouldBeRedirectedToTheLoginPage() {
        String loginFormTitle = loginPage.getLoginFormTitle();
        Assert.assertTrue(loginFormTitle.equalsIgnoreCase("Login"),"Registration is not Successful");
        System.out.println("Step: I should be redirected to the login page");
    }

    @Then("I should see error messages for each required field")
    public void iShouldSeeErrorMessagesForEachRequiredField() {
        System.out.println("Step: I should see error messages for each required field");
    }

    @Then("I should see an error message indicating that the password does not meet the acceptance criteria")
    public void iShouldSeeErrorMessagePasswordDoesNotMeetCriteria() {
        System.out.println("Step: I should see an error message indicating that the password does not meet the acceptance criteria");
    }

    @Then("I should see an error message indicating that the passwords do not match")
    public void iShouldSeeErrorMessagePasswordsDoNotMatch() {
        System.out.println("Step: I should see an error message indicating that the passwords do not match");
    }

    @Then("I should see an error message indicating that the username is not available")
    public void iShouldSeeErrorMessageUsernameNotAvailable() {
        System.out.println("Step: I should see an error message indicating that the username is not available");
    }

    @Given("a user with username {string} is already registered")
    public void aUserWithUsernameIsAlreadyRegistered(String username) {
        System.out.println("Step: A user with username \"" + username + "\" is already registered");
    }

    @When("I submit the form without filling in any details")
    public void iSubmitTheFormWithoutFillingInAnyDetails() {
        System.out.println("Step: I submit the form without filling in any details");
    }
}
