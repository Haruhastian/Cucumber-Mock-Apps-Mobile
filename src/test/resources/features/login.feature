@TEST
Feature: Login
  Scenario: Login valid and checkout product
    Given The user opens the app
    And Gives valid credentials
    Then The user will be logged in
    And Sorts the Price by Descending order
    And Chooses the most expensive item and add to cart
    Then Opens the cart and assert the price value and then checkout
    And Fills in all fields on the checkout page and then to payment
    And Fills in all fields on the card page and then to review order
    Then validates the jacket price and total item price
    And Logout from the app
    Then validates the log out
