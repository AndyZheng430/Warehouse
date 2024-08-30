Feature: Add Item


Scenario: Succesfull addition of an item
Given I am on the items page
When I click create
And I enter a item name and a item description
And I click submit
Then an item should be created and added to the database


Scenario: Unsuccesfull addition of an item
Given I am on the items page
When I click create
And I enter a item description
And I click submit
Then an item should not be created and added to the database