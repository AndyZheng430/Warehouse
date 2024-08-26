Feature: Delete an inventory

    As a user,
    I want to remove inventory
    so there will no longer be inventory for an item in a warehouse

    Scenario: Successfully remove inventory
        Given the user is on the Warehouse page
        And clicks teh details button for a warehouse
        When the user clicks the delete button
        Then the inventory should be removed