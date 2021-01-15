@AddItemToCart
Feature: Add item to cart

  Scenario: User clicks the "add to cart" button
    Given I am on the item page
    When I click on the add to cart button
    Then the item should be added to the cart