Feature: Product Checkout

  Scenario: Verify user is able to checkout the product
    Given user do login
    When User click Add to Cart button on one the product or more
    And User click Cart icon on the top right side
    And User check the shopping list details & click the Checkout button
    And User input the buyer's information form & click Finish button
    And User double check the shopping list & click the Finish button
    Then User successfully purchased the product & direct to Checkout: Complete page
    And user can back to homepage with click the Back Home button

