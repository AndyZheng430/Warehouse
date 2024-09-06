@createWarehouse
Feature: Create a Warehouse

    As a user,
    I want to create a Warehouse
    so that I can add Inventory to it.

    Background:
        Given I am on the warehouse page

    Scenario: Successfully creating a new warehouse
        When I click the create button
        And enter a valid warehouse name
        And enter a valid location
        And enter a valid owner
        And enter a valid capacity
        And I click the submit button 
        Then create a new warehouse with the name, owner, location, and capacity 
    
    Scenario: Successfully creating a new warehouse without a required owner
        When I click the create button
        And enter a valid warehouse name
        And enter a valid location
        And enter a valid capacity
        And I click the submit button 
        Then create a new warehouse with the name, owner, location, and capacity 
    
    Scenario: Successfully creating a new warehouse without a required location
        When I click the create button
        And enter a valid warehouse name
        And enter a valid owner
        And enter a valid capacity
        And I click the submit button 
        Then create a new warehouse with the name, owner, location, and capacity 

    Scenario: Create a warehouse without a name
        When I click the create button
        And enter a valid location
        And enter a valid owner
        And enter a valid capacity
        And I click the submit button 
        Then create a new warehouse with the name, owner, location, and capacity 
    
    Scenario: Failed to create a warehouse with invalid capacity
        When I click the create button
        And enter a valid warehouse name
        And enter a valid location
        And enter a valid owner
        And enter a capacity less than 0
        And I click the submit button 
        Then a new warehouse should not be created