package com.skillstorm.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skillstorm.backend.models.Warehouse;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class WarehouseModelTests {

    private Warehouse warehouse;
    private Validator validator; 

    @BeforeEach
    public void setUp() {
        warehouse = new Warehouse();
        warehouse.setName("Warehouse 1");
        warehouse.setOwner("Bill");
        warehouse.setLocation("Ship Port");
        warehouse.setMaxCapacity(1000);

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testWarehouseAttributes() {
        assertEquals("Warehouse 1", warehouse.getName());
        assertEquals("Bill", warehouse.getOwner());
        assertEquals("Ship Port", warehouse.getLocation());
        assertEquals(1000, warehouse.getMaxCapacity());

        Set<ConstraintViolation<Warehouse>> violations = validator.validate(warehouse);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testWarehouseNameIsRequired() {
        warehouse.setName(null);
        Set<ConstraintViolation<Warehouse>> violations = validator.validate(warehouse);
        assertFalse(violations.isEmpty());
        
        warehouse.setName("Warehouse 123");
        violations = validator.validate(warehouse);
        assertTrue(violations.isEmpty());
    }
    
    @Test
    public void testWarehouseOwnerIsNotRequired() {
        warehouse.setOwner(null);
        Set<ConstraintViolation<Warehouse>> violations = validator.validate(warehouse);
        assertTrue(violations.isEmpty());

        warehouse.setOwner("");
        violations = validator.validate(warehouse);
        assertTrue(violations.isEmpty());
    }

    
    @Test
    public void testWarehouseLocationIsNotRequired() {
        warehouse.setLocation(null);
        Set<ConstraintViolation<Warehouse>> violations = validator.validate(warehouse);
        assertTrue(violations.isEmpty());

        warehouse.setLocation("");
        violations = validator.validate(warehouse);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testWarehouseCapacityValidation() {
        warehouse.setMaxCapacity(-1);
        Set<ConstraintViolation<Warehouse>> violations = validator.validate(warehouse);
        assertFalse(violations.isEmpty());

        warehouse.setMaxCapacity(0);
        violations = validator.validate(warehouse);
        assertTrue(violations.isEmpty());
    }

    @AfterEach
    public void cleanUp() {
        warehouse = null;
        validator = null;
    }
}
