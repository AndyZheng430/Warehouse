@another
Feature: Delete Inventory

  As a user,
  I want to delete an item's inventory
  So that there will no longer be inventory for an item in a particular warehouse.

  Background:
    Given I am on the "Warehouses" page
    And I have expanded the warehouse named "Woodshop" to view its inventory

  Scenario: Verify that Inventory was deleted with a valid ID
    Given I have an existing inventory "Couch"
    When I click the delete button
    Then the inventory item should dissapear

    Scenario: Verify that Inventory was deleted with a invalid ID
    Given I have an nonexisting inventory "Screw"
    When I try to click the associated delete button
    Then nothing should happen