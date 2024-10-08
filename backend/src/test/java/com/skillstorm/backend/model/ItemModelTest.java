package com.skillstorm.backend.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.models.Item;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class ItemModelTest {

    private Item item;
    private Validator validator; 

    @BeforeEach
    public void setUp() {
        item = new Item();
        item.setName("item");
        item.setDescription("an item");
        
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void testItemAttributes() {
        Inventory inventory = new Inventory();
        item.setinventory(Arrays.asList(inventory));

        assertEquals("item", item.getName());
        assertEquals("an item", item.getDescription());
        assertEquals(Arrays.asList(inventory), item.getinventory());

        Set<ConstraintViolation<Item>> violations = validator.validate(item);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testItemNameIsRequired() {
        item.setName(null);
        Set<ConstraintViolation<Item>> violations = validator.validate(item);
        assertFalse(violations.isEmpty());
        
        item.setName("");
        violations = validator.validate(item);
        assertTrue(violations.isEmpty());
    }

    @Test
    public void testItemDescripitionIsNotRequired() {
        item.setName(null);
        Set<ConstraintViolation<Item>> violations = validator.validate(item);
        assertFalse(violations.isEmpty());
        
        item.setName("");
        violations = validator.validate(item);
        assertTrue(violations.isEmpty());
    }

    @AfterEach
    public void cleanUp() {
        item = null;
        validator = null;
    }

}
