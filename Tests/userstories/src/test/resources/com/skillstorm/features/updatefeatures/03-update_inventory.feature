@testing
Feature: Update Inventory
  As a user,  
  I want to be able to edit the Inventory 
  So I can make changes to the amount and item 

  Background:
    Given I am on "Warehouses" page
    And I have existing warehouse with the following details:
      | Name       | Woodshop |
      | Location   | New York |                       
      | Owner      | John Doe |
      | Capacity   | 1000     | 


  Scenario: Display inventory update
    Given I click the inventory item
    When I enter new inventory info:
      | Name       | Oak Wood |
      | Quantity   | 100      |
    Then the main screen should display the item Id "1" and amount "100"


#Should this be broken down into 2 separate scenarios?
  Scenario: Successfully update the inventory item ID 
    # Given I have wr warehouse "Woodshop"
    Given I click to edit item named "Oak Wood"
    When I change the inventory item Id to "5"
    Then the item name should be updated to:
      | Name       | 45lb bumper plate |

  Scenario: Successfully update the inventory amount 
    # Given I have wr warehouse "Woodshop"
    Given I click to edit the item named "Oak Wood"
    When I change the amount to "125"
    Then the amount should be updated to:
      | Amount       |  125 |

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