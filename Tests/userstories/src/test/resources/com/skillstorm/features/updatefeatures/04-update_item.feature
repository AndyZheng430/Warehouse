
Feature: Update Item

  As a user,
  I want to be able to edit the product
  So I can make modifications to the product.

  Background:
    Given I am at the "Item" page

  Scenario: Verify successful update of all fields of an Item
    Given I have an existing item with ID "123" and the following details:
      | Name        | Description           |
      | Old Product | Old Product Description |
    When I click the "Edit" button for the item with ID "123"
    And I update the Name to "New Product"
    And I update the Description to "New Product Description"
    And I click the "Save" button
    Then I should see the updated item details in the table:
      | Name         | Description            |
      | New Product  | New Product Description |

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

  Scenario: Verify handling of Item Name with an invalid value
    Given I have existing item with ID "123" and the following details:
      | Name        | Description           |
      | Old Product | Old Product Description |
    When I click the "Edit" symbol for the item with ID "123"
    And I update the Name to " "  # Invalid value, like an empty string or whitespace
    And I click the "Save" symbol
    Then I should see an error message "Item Name cannot be empty"
    And the item details should remain unchanged in the table:
      | Name        | Description           |
      | Old Product | Old Product Description |
