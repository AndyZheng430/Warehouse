
Feature: Update Item

  As a user,
  I want to be able to edit the product
  So I can make modifications to the product.

  Background:
    Given I am at the "Items" page

  Scenario: Verify successful update of all fields of an Item
    Given I have an existing item with ID "3" 
    When I click the edit button for the item with ID "3"
    And I update the name to "Birch Wood"
    And I update the description to "pliable"
    Then I should see the updated item details:
      | Name        | Birch Wood |
      | Description | pliable    |


  Scenario: Verify update of only name
    Given I have existing item with the following details:
      | Name        | barbell           |
      | Description | Olympic 45 pound |
    When I click to edit the item
    And I update the name to "potato"
    Then the item name should say "potato"


  # Scenario: Verify partial update of an Item
  #   Given I have an existing item with ID "123" and the following details:
  #     | Name        | Description           |
  #     | Old Product | Old Product Description |
  #   When I click the "Edit" button for the item with ID "123"
  #   And I update the Name to "Updated Product"
  #   And I leave the Description unchanged
  #   And I click the "Save" button
  #   Then I should see the updated item details in the table:
  #     | Name           | Description           |
  #     | Updated Product | Old Product Description |

