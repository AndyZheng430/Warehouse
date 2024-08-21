package com.skillstorm.backend;

import org.testng.annotations.Test;

public class CreateWarehouseTests {
    
    @Test
    public void verifyWarehouseAllFields() {
        String name = "X Guild";
        String owner = "Merc";
        String location = "Town";
        int capacity = 1000;

    }

    @Test
    public void verifyWarehouseNameIsRequired() {
        String owner = "Merc";
        String location = "Town";
        int capacity = 1000;
        
    }

    @Test
    public void verifyWarehouseCapacityIsRequired() {

    }

}
