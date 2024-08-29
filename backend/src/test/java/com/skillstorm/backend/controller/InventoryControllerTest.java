package com.skillstorm.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.skillstorm.backend.controllers.InventoryController;
import com.skillstorm.backend.dtos.SimpleInventoryDto;
import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.services.InventoryService;

public class InventoryControllerTest {
    @Mock
    private InventoryService inventoryService;

    @InjectMocks
    private InventoryController inventoryController;
    private AutoCloseable closeable;

    @BeforeTest
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterTest
    public void teardown() throws Exception {
        closeable.close();
    }

    @Test
    public void testGetAllInventory() {
        List<Inventory> inventories = Arrays.asList(new Inventory(), new Inventory());

        when(inventoryService.findAll()).thenReturn(inventories);

        ResponseEntity<List<Inventory>> response = inventoryController.getAll();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), inventories);
    }

    @Test
    public void testGetInventoryById() {
        int warehouseId = 1;
        int itemId = 1;
        Optional<Inventory> inventory = Optional.ofNullable(new Inventory());

        when(inventoryService.findById(warehouseId, itemId)).thenReturn(inventory);

        ResponseEntity<Optional<Inventory>> response = inventoryController.getInventoryById(warehouseId, itemId);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), inventory);
    }

    @Test
    public void testCreateInventory() {
        Inventory inventory = new Inventory();
        SimpleInventoryDto inventoryDto = new SimpleInventoryDto();

        when(inventoryService.save(inventoryDto)).thenReturn(inventory);

        ResponseEntity<Inventory> response = inventoryController.createInventory(inventoryDto);
        
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), inventory);
    }

    @Test
    public void testEditInventory() {
        int warehouseId = 1;
        int itemId = 1;
        Inventory inventory = new Inventory();

        when(inventoryService.update(warehouseId, itemId, inventory)).thenReturn(inventory);

        ResponseEntity<Inventory> response = inventoryController.updateInventory(warehouseId, itemId, inventory);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), inventory);
    }

    @Test
    public void testDeleteInventory() {
        int warehouseId = 1;
        int itemId = 1;

        ResponseEntity<Void> response = inventoryController.deleteById(warehouseId, itemId);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}
