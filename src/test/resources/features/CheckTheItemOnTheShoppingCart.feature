@CheckShoppingCartItem
Feature: Check the item is on the shopping cart list

  Scenario: There should be 1 item in the shopping cart
    Given I am on the shopping cart page
    When I count the items on the shopping cart page
    Then the sum should be exactly 1