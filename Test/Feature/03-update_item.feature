Feature: Update Item
  As a user, 
  I want to be able to edit the product
  So I can make modifications to the product

  Scenario: Display inventory update
    Given I am on the Warehouses page
    And I expand a warehouse's details
    When I click to edit an item
    Then a window should display the item name and quantity


#Should this be broken down into 2 separate scenarios?
  Scenario: Successfully update the inventory item ID and amount
    Given I am on the Warehouse page
    And I expand the details for warehouse "Woodshop"
    And I click to edit item named "Oak Wood"
    When I change the inventory item Id to "3"
    And I change the quantity to "25"
    And I click the submit button
    Then the update should be successful
    And the item name should be updated to "Iron Ore"
    And the amount should be updated to "25"

  Scenario: Handling an invalid quantity
    Given I am on the Warehouses page
    And I expand the details for warehouse "Wood Shop"
    And I click to edit item named "Wood"
    When I try to edit the item quantity to have an invalid amount "-10"
    And I click the submit button
    Then I should receive an error message 
    And the inventory item should not be updated

  Scenario: Handling an invalid item ID
    Given I am on the Warehouses page
    And I expand the details for warehouse "Wood Shop"
    And I click to edit item named "Wood"
    When I try to edit the item name to have an invalid id "5000"
    And I click the submit button
    Then I should receive an error message 
    And the inventory item should not be updated