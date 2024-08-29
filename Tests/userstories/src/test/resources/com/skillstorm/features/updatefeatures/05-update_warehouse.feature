
Feature: Update Warehouse

  As a user,
  I want to update a warehouse
  So that changes can persist in the database.

  Background:
    Given I am on the "Warehouses" page

  Scenario: Verify successful update of all fields of a Warehouse
    Given I have an existing warehouse with the following details:
      | Name       | Location  | Owner      | Capacity |
      | Woodshop   | New York  | John Doe   | 1000     |
    When I edit the warehouse named "Woodshop"
    And I update the details :
      | Name              | Location    | Owner  | Capacity |
      | Barone Sanitation | New Jersey  | Tony   | 2000     |
    Then I should see the updated warehouse details in the table

  Scenario: Verify handling of warehouse capacity with an invalid value
    Given I have an existing warehouse with the following details:
      | Name           | Location     | Owner        | Capacity |
      | Clothing depot | Los Angeles  | Jane Smith   | 1500     |
    When I click the edit symbol for the warehouse named "Clothing depot"
    And I update the value to a negative value of "-27"
    Then I should see an error message "Warehouse Name cannot be empty"
    And the warehouse details should remain unchanged in the table


 # Simplify scenarios! Not using cucumber for edge cases

  # Scenario: Verify handling for Invalid Warehouse Capacity
  #   Given I have an existing warehouse with the following details:
  #     | Name         | Location  | Owner       | Capacity |
  #     | Old Warehouse | Old City  | Old Owner   | 1000     |
  #   When I click the "Edit" button for the warehouse named "Old Warehouse"
  #   And I update the Warehouse Capacity to "-500"  # Invalid capacity, negative number
  #   And I click the "Save" button
  #   Then I should see an error message "Warehouse Capacity must be a positive number"
  #   And the warehouse details should remain unchanged in the table:
  #     | Name         | Location  | Owner       | Capacity |
  #     | Old Warehouse | Old City  | Old Owner   | 1000     |

  # Scenario: Verify Update of Warehouse Location
  #   Given I have an existing warehouse with the following details:
  #     | Name         | Location  | Owner       | Capacity |
  #     | Old Warehouse | Old City  | Old Owner   | 1000     |
  #   When I click the "Edit" button for the warehouse named "Old Warehouse"
  #   And I update the Warehouse Location to "New City"
  #   And I click the "Save" button
  #   Then I should see the updated warehouse details in the table:
  #     | Name         | Location  | Owner       | Capacity |
  #     | Old Warehouse | New City  | Old Owner   | 1000     |

  # Scenario: Verify Update of Warehouse Owner
  #   Given I have an existing warehouse with the following details:
  #     | Name         | Location  | Owner       | Capacity |
  #     | Old Warehouse | Old City  | Old Owner   | 1000     |
  #   When I click the "Edit" button for the warehouse named "Old Warehouse"
  #   And I update the Warehouse Owner to "New Owner"
  #   And I click the "Save" button
  #   Then I should see the updated warehouse details in the table:
  #     | Name         | Location  | Owner       | Capacity |
  #     | Old Warehouse | Old City  | New Owner   | 1000     |