@createWarehouse
Feature: Create a Warehouse

    As a user,
    I want to create a Warehouse
    so that I can add Inventory to it.

    Scenario: Successfully creating a new warehouse 
        Given I am currently on the warehouse page
        When I click the create button
        And enter a valid warehouse name
        And enter a valid location
        And enter a valid owner
        And enter a valid capacity
        And I click the submit button 
        Then create a new warehouse with the name, owner, location, and capacity 
    
    Scenario: Successfully creating a new warehouse without a required owner
        Given I am on the warehouse page
        When I click the create button
        And enter a valid warehouse name
        And enter a valid location
        And enter a valid capacity
        And clicks the submit button 
        Then a new warehouse should be created with the name, owner, location, and capacity
    
    Scenario: Successfully creating a new warehouse without a required location
        Given I am on the warehouse page
        When I click the create button
        And enter a valid warehouse name
        And enter a valid owner
        And enter a valid capacity
        And clicks the submit button 
        Then a new warehouse should be created with the name, owner, location, and capacity

    Scenario: Failed to create a warehouse without name
        Given I am on the warehouse page
        When I click the create button
        And enter a valid location
        And enter a valid owner
        And enter a valid capacity
        And clicks the submit button
        Then a new warehouse should not be created
        And an error should appear

    Scenario: Failed to create a warehouse with invalid capacity
        Given I am on the warehouse page
        When I click the create button
        And enter a valid warehouse name
        And enter a valid location
        And enter a valid owner
        And enter a capacity less than 0
        And clicks the submit button
        Then a new warehouse should not be created
        And an error should appear

    Scenario: View new warehouse
        Given a new warehouse is successfully created
        When the user navigates to the Warehouse page
        Then there is a new warehouse with a valid name, location, owner, and capacity