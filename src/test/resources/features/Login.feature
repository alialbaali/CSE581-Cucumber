Feature: Login functionality
  As a standard user of Saucedemo
  I want to login

  Scenario Outline: Login
    Given I am on the Login Page of Saucedemo
    When I enter a "<username>" and "<password>"
    Then the login status should be "<status>"

    Examples:
      | username        | password     | status  |
      | standard_user   | secret_sauce | success |
      | locked_out_user | secret_sauce | failure |