Feature: Delete an item

    As a user,
    I want to delete an item,
    so it no longer exists

    Scenario:
        Given the user is on the Item page
        And there is an item
        When the user clicks the delete button 
        Then the item should be removed
        And all inventory with the item id should be removed
    