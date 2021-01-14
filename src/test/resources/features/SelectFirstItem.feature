Feature: Select First Item

  Background: User is already Logged in
    Given I'm on the login page
    When I enter a valid username and password
    Then I should be directed to the inventory page

  Scenario: Navigate to a product page
    Given I'm on the inventory page
    When I click on the first item
    Then it should navigate to the item page