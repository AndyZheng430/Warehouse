Feature: View All Warehouses
  As a user,
  I want to see all Warehouses
  So I can view the warehouse information and inventory information

  Scenario: Displaying a list of all warehouses
    Given I am on the landing page
    When I navigate to the warehouses page
    And there is one or more warehouses existing
    Then I should see a list of all warehouses created
    And each warehouse should display the warehouse name, owner, location, and maximum capacity


  Scenario: Displaying an empty list of all warehouses
    Given I am on the landing page
    When I navigate to the warehouses page
    And there is no current warehouses existing
    Then I should see an empty list of warehouses created