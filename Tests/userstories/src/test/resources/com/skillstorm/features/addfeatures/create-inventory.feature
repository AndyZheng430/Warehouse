Feature: create new Inventory

    As a user,
    I want to create inventory for warehouses,
    so that I can add items and amounts to warehouses

    Scenario: Successfully create new inventory
        Given I am on the warehouse page
        When the user clicks on the Add button 
        And enters an item id
        And enters an amount
        And clicks the submit button
        Then create new inventory with the warehouse, item, and amount

    Scenario: Failed to create inventory with an amount greater than Warehouse capacity
        Given I am on the warehouse page
        When the user clicks the Add button
        And enters an item id
        And enters an amount greater than the warehouse capacity
        And clicks the submit button
        Then a new inventory should not be created
        And an error saying the amount is greater than the capacity

    Scenario: Failed to create inventory without an item 
        Given I am on the warehouse page
        When the user clicks on the Add button 
        And enters an amount
        Then the new inventory should not be created
        And an error saying that an item id is required

    Scenario: View new inventory
        Given a new inventory is successfully created
        When the user clicks the detail arrow button 
        Then the new inventory details should be displayed