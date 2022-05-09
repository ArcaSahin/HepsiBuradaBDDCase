Feature: End to End Basket Test After User Has Logged In

  Background: Buyer is logged in successfully
    Given browser is open
    When buyer is on landing page
    And buyer clicks login and goes to login page
    And buyer enters valid "abcdefgh@gmail.com" and "abcdefgh"
    When buyer is navigated to the home page
    Then check if buyer should have been registered successfully

  Scenario: Add product to basket via passing through all steps
    When buyer searches for a "Dambıl Seti"
    And buyer clicks search and navigated to the search page
    And buyer selects a wanted product
    And buyer adds the selected product to the cart
    And buyer goes to the basket page
    Then check if buyer added correct product to the basket on basket page
