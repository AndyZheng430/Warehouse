Feature: Delete Inventory

  As a user,
  I want to delete an item's inventory
  So that there will no longer be inventory for an item in a particular warehouse.

  Background:
    Given I am on the "Warehouse" page
    And I have expanded the warehouse named "Central Warehouse" to view its inventory

  Scenario: Verify that Inventory was deleted with a valid ID
    Given I have an existing inventory item with Item ID "123" in Warehouse ID "456"
    When I enter the Item ID "123"
    And I enter the Warehouse ID "456"
    And I click the "Delete" button
    Then the inventory for Item ID "123" in Warehouse ID "456" should be removed from the list
    And I should see a confirmation message "Inventory deleted successfully"

  Scenario: Verify handling of Inventory deletion with a non-existent ID
    Given I have an existing warehouse with Warehouse ID "456"
    And no inventory exists for Item ID "999" in Warehouse ID "456"
    When I enter the Item ID "999"
    And I enter the Warehouse ID "456"
    And I click the "Delete" button
    Then I should see an error message "Inventory not found for the given Item ID and Warehouse ID"
    And the inventory list should remain unchanged

  Scenario: Verify handling of Inventory deletion if no ID is entered
    Given I have an existing inventory item with Item ID "123" in Warehouse ID "456"
    When I leave the Item ID field empty
    And I leave the Warehouse ID field empty
    And I click the "Delete" button
    Then I should see an error message "Item ID and Warehouse ID are required"
    And the inventory list should remain unchanged