package com.skillstorm.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.models.Warehouse;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class InventoryModelTests {
    
    private Inventory inventory;
    private Warehouse warehouse;
    private Item item;
    private Validator validator;

    @BeforeEach
    public void setUp() {
        warehouse = new Warehouse(1, "warehouse", "place", "owner", 100);
        item = new Item(1, "item", "description");
        inventory = new Inventory(1, 1, 100, warehouse, item);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testInventoryAttributes() {
        assertEquals(1, inventory.getWarehouseId());
        assertEquals(1, inventory.getItemId());
        assertEquals(100, inventory.getAmount());

        Set<ConstraintViolation<Inventory>> violations = validator.validate(inventory);
        assertTrue(violations.isEmpty());
    }

    @Test 
    public void testInventoryWarehouseIdIsRequired() {
        inventory = new Inventory();
        inventory.setAmount(100);
        inventory.setWarehouse(warehouse);
        inventory.setItemId(1);
        inventory.setItem(item);
        Set<ConstraintViolation<Inventory>> violations = validator.validate(inventory);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInventoryWarehouseIdMatch() {
        assertEquals(warehouse.getId(), inventory.getWarehouseId());
        
        inventory.setWarehouseId(0);
        assertNotEquals(warehouse.getId(), inventory.getWarehouseId());
    }

    @Test 
    public void testInventoryItemIdIsRequired() {
        inventory = new Inventory();
        inventory.setAmount(100);
        inventory.setWarehouseId(1);
        inventory.setWarehouse(warehouse);
        inventory.setItem(item);
        Set<ConstraintViolation<Inventory>> violations = validator.validate(inventory);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testInventoryItemIdMatch() {
        assertEquals(item.getId(), inventory.getItemId());

        inventory.setItemId(0);
        assertNotEquals(item.getId(), inventory.getItemId());
    }

    @Test 
    public void testInventoryAmountIsRequired() {
        inventory.setAmount(-1);
        Set<ConstraintViolation<Inventory>> violations = validator.validate(inventory);
        assertFalse(violations.isEmpty());

        inventory.setAmount(0);
        violations = validator.validate(inventory);
        assertTrue(violations.isEmpty());
    }

    @AfterEach
    public void cleanUp() {
        inventory = null;
        warehouse = null;
        item = null;
        validator = null;
    }
}
