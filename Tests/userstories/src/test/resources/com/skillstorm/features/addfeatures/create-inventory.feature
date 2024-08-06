@remaining2
Feature: create new Inventory

    As a user,
    I want to create inventory for warehouses,
    so that I can add items and amounts to warehouses

    Background:
        Given I am currently on the warehouse page

    Scenario: Successfully create new inventory
        When I click on the Add button 
        And enters an inventory id
        And enters an inventory amount
        And clicks the inventory submit button
        Then create new inventory with the warehouse, item, and amount

    Scenario: Failed to create inventory without an item 
        When I click on the Add button 
        And enters an inventory id
        And enters an inventory amount
        And clicks the inventory submit button
        Then the new inventory should not be created