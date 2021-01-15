@CompleteAndLogout
Feature: Finish and logout

  Scenario: User clicks on the finish button
    Given I am on the checkout page
    And I fill my checkout info
    When I click the finish button
    Then I should have my order complete
    And I logout