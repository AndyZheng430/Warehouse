Feature: Create a Warehouse

    As a user,
    I want to create a Warehouse
    so that I can add Inventory to it.

    Scenario: Successfully creating a new warehouse 
        Given a valid warehouse name, owner, location, and capacity
        When the user navigates to the Warehouse page
        And clicks the create button
        And enter all the field values
        And clicks the submit button 
        Then a new warehouse should be created with the name, owner, location, and capacity 
    
    Scenario: Successfully creating a new warehouse without a required owner
        Given a valid warehouse name, location, and capacity
        And owner is not provided
        When the user navigates to the Warehouse page
        And clicks the create button
        And enter all the field values
        And clicks the submit button 
        Then a new warehouse should be created with the name, owner, location, and capacity
    
    Scenario: Successfully creating a new warehouse without a required location
        Given a valid warehouse name, owner, and capacity
        And location is not provided
        When the user navigates to the Warehouse page
        And clicks the create button
        And enter all the field values
        And clicks the submit button 
        Then a new warehouse should be created with the name, owner, location, and capacity

    Scenario: Failed to create a warehouse without name
        Given a valid warehouse owner, location, and capacity
        And warehouse name is not given
        When the user navigates to the Warehouse page
        And clicks the create button
        And enter all the field values
        And clicks the submit button
        Then a new warehouse should not be created
        And an error should appear

    Scenario: Failed to create a warehouse with invalid capacity
        Given a valid warehouse name, owner, and location
        And a capacity less than 0
        When the user navigates to the Warehouse page
        And clicks the create button
        And enter all the field values
        And clicks the submit button
        Then a new warehouse should not be created
        And an error should appear

    Scenario: View new warehouse
        Given a new warehouse is successfully created
        When the user navigates to the Warehouse page
        Then there is a new warehouse with a valid name, location, owner, and capacity