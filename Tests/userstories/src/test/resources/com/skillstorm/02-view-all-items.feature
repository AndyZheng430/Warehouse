Feature: View All Items
As a user, 
I should be able to view all items
so I can see what the items are

  Scenario: Displaying a list of all items
    Given I am at the landing page
    When I navigate to the items page
    Then I should see a list of all items created
    And each item should display their id, name, and description


  Scenario: Displaying an empty list of all items
    Given I am at the landing page
    When I navigate to the items page
    And there is no current items existing
    Then I should see an empty list of items created