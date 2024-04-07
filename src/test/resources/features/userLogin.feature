Feature: User Login
  As a registered user
  I want to be able to log in to the system
  So that I can access my account

  Background:
    Given I am on the login page

  @run @login
  Scenario Outline: Validate the login function with valid credentials
    When I enter "<userName>" in the username text field and "<password>" in the password text field
    And I click on login
    Then I should be logged in and redirected to the landing page
    Examples:
      | userName   | password |
      | johneki    | Pass@134 |

  Scenario: Validate the login function with incorrect password
    When I enter "validUser1" in the username text field and "wrongPass1" in the password text field and click on login
    Then I should see an error message

  Scenario: Validate the login function with missing credentials
    When I click on login without filling in any credentials
    Then I should see the fields highlighted in red indicating missing information