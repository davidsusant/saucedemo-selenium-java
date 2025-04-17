Feature: Login
  As a user
  I want to login to the application
  So that I can access the product page

  Background:
    Given I am on the login page

  @positive
  Scenario: Successful login with valid credentials
    When I login with username "standard_user" and password "secret_sauce"
    Then I should be redirected to the products page
    And I should see at least 1 products