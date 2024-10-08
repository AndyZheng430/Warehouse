@deleting
Feature: Delete a Warehouse

    As a user,
    I want to remove a warehouse that I do not need anymore
    so it no longer exists

    Scenario: Successfully delete a warehouse
        Given the user is on the warehouse page
        And there is a warehouse
        When the user clicks the delete warehouse button to delete a warehouse
        Then the warehouse should be removed
        And the inventory with the warehouse id should be removed
    