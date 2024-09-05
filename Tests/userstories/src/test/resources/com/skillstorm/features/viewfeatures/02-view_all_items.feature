Feature: View All Items
  As a user, 
  I should be able to view all items
  so I can see what the items are

  Background:
    Given I am at the "Items" page

  Scenario: Displaying a list of all items
    When there is one or more items created
    Then I should see a list of all items created
    And each item should display their id, name, and description

