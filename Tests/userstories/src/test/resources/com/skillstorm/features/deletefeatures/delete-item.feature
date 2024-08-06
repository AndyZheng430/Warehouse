@deleting
Feature: Delete an item

    As a user,
    I want to delete an item,
    so it no longer exists

    Scenario: Deleting an item
        Given the user is on the Item page
        And there is an item
        When the user clicks the delete item button to delete an item
        Then the item should be removed
        And all inventory with the item id should be removed
    