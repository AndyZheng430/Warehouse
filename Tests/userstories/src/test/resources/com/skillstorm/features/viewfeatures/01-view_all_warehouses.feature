@testing
Feature: View All Warehouses
  As a user,
  I want to see all Warehouses
  So I can view the warehouse information and inventory information

  Background: 
    Given I am on the "Warehouses" page

  Scenario: Displaying a list of all warehouses
    When there is one or more warehouses existing
    Then I should see a list of all warehouses created
    And each warehouse should display the warehouse name, owner, location, and maximum capacity

