
Feature: Update Inventory
  As a user,  
  I want to be able to edit the Inventory 
  So I can make changes to the amount and item 

  Background:
    Given I am on "Warehouses" page
    And I have existing warehouse with the following details:
      | Name       | Location  | Owner      | Capacity |
      | Woodshop   | New York  | John Doe   | 1000     | 
  
  Scenario: Display inventory update
    When I click to edit item:
      | Name       | quantity |
      | Oak Wood   | 100 |
    Then a window should display the item Id "1" and amount "100"


#Should this be broken down into 2 separate scenarios?
  Scenario: Successfully update the inventory item ID and amount
    # Given I have wr warehouse "Woodshop"
    Given I click to edit item named "Oak Wood"
    When I change the inventory item Id to "5"
    And I change the quantity to "25"
    Then the item name should be updated to:
      | Name       | quantity |
      | Iron Ore   | 25 |

  # Scenario: Handling an invalid quantity
  #   Given I am on the Warehouses page
  #   And I expand the details for warehouse "Wood Shop"
  #   And I click to edit item named "Wood"
  #   When I try to edit the item quantity to have an invalid amount "-10"
  #   And I click the submit button
  #   Then I should receive an error message 
  #   And the inventory item should not be updated

  # Scenario: Handling an invalid item ID
  #   Given I am on the Warehouses page
  #   And I expand the details for warehouse "Wood Shop"
  #   And I click to edit item named "Wood"
  #   When I try to edit the item name to have an invalid id "5000"
  #   And I click the submit button
  #   Then I should receive an error message 
  #   And the inventory item should not be updated