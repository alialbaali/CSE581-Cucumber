@ProceedToShoppingCart
Feature: Proceeding to shopping cart

  Scenario: User clicks on the shopping cart icon
    Given I am on the inventory item page
    When I click on the shopping cart icon in the navbar
    Then I should be directed to the shopping cart page