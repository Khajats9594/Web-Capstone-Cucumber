Feature: User Registration

  Background:
    Given I am on the registration page

  @run @registration
  Scenario: User registration with valid information
    When I fill in the registration form with the following details
      | First Name | Last Name | Username  | Password | Confirm Password | Gender |
      | John       | Doe       | jkikk     | Pass@9876| Pass@9876        | Male   |
    And I submit the form
    Then I should be redirected to the login page

  Scenario: User registration with required fields left blank
    When I submit the form without filling in any details
    Then I should see error messages for each required field

  Scenario: User registration with password not meeting acceptance criteria
    When I fill in the registration form with the following details
      | First Name | Last Name | Username  | Password | Confirm Password | Gender |
      | John       | Doe       | johndoe   | pass    | pass              | Male   |
    And I submit the form
    Then I should see an error message indicating that the password does not meet the acceptance criteria

  Scenario: User registration with passwords not matching
    When I fill in the registration form with the following details
      | First Name | Last Name | Username  | Password | Confirm Password | Gender |
      | John       | Doe       | johndoe   | pass123  | pass456          | Male   |
    And I submit the form
    Then I should see an error message indicating that the passwords do not match

  Scenario: User registration with already registered username
    And a user with username "johndoe" is already registered
    When I fill in the registration form with the following details
      | First Name | Last Name | Username  | Password | Confirm Password | Gender |
      | Jane       | Smith     | johndoe   | pass123  | pass123          | Female |
    And I submit the form
    Then I should see an error message indicating that the username is not available