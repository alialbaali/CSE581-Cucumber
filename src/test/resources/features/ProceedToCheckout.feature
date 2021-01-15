@ProceedToCheckout
Feature: Checkout functionality

  Scenario: User clicks on the checkout button in the shopping cart page
    Given I am on the shopping cart page with 1 item in the cart
    When I click on the checkout button
    Then I should be directed to the Checkout page