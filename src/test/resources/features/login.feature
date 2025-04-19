Feature: Login feature

  Scenario: Successful login with valid credentials
    Given I am on the SauceDemo login page
    When I login with username "standard_user" and password "secret_sauce"
    Then I should see the products page