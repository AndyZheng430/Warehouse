Feature: create new Inventory

    As a user,
    I want to create inventory for warehouses,
    so that I can add items and amounts to warehouses

    Scenario: Successfully create new inventory
        Given a warehouse
        And an item
        When the user clicks on the Add button 
        And enters all the field values
        And clicks the submit button
        Then a new inventory should be created with the warehouse, item, and amount for the item

    Scenario: Failed to create inventory with an amount greater than Warehouse capacity
        Given a warehouse with the capacity of 100
        And an item
        When the user clicks the Add button
        And enters an amount greater than the 100
        And clicks the submit button
        Then a new inventory should not be created
        And an error saying the amount is greater than the capacity

    Scenario: Failed to create inventory without an item 
        Given a warehouse
        When the user clicks on the Add button 
        And enters the amount 
        And does not enter an item id
        Then the new inventory should not be created
        And an error saying that an item id is required