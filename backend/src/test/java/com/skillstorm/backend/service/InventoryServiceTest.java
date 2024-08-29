package com.skillstorm.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.skillstorm.backend.dtos.SimpleInventoryDto;
import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.models.InventoryKey;
import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.models.Warehouse;
import com.skillstorm.backend.repositories.InventoryRepository;
import com.skillstorm.backend.repositories.ItemRepository;
import com.skillstorm.backend.repositories.WarehouseRepository;
import com.skillstorm.backend.services.InventoryService;

public class InventoryServiceTest {
    @Mock
    private InventoryRepository inventoryRepository;
    @Mock
    private WarehouseRepository warehouseRepository;
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private InventoryService inventoryService;
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
    public void saveInventory() {
        int warehouseId = 1;
        int itemId = 1;
        int amount = 100;
        SimpleInventoryDto simpleInventoryDto = new SimpleInventoryDto(warehouseId, itemId, amount);
        Warehouse warehouse = new Warehouse();
        Item item = new Item();
        Inventory inventory = new Inventory();
        inventory.setWarehouseId(warehouseId);
        inventory.setItemId(itemId);
        inventory.setAmount(amount);
        inventory.setWarehouse(warehouse);
        inventory.setItem(item);

        when(itemRepository.findById(warehouseId)).thenReturn(Optional.ofNullable(item));
        when(warehouseRepository.findById(itemId)).thenReturn(Optional.ofNullable(warehouse));
        when(inventoryRepository.save(any(Inventory.class))).thenReturn(inventory);

        Inventory response = inventoryService.save(simpleInventoryDto);

        assertEquals(inventory, response);
    }

    @Test(expectedExceptions = RuntimeException.class, priority = 1)
    public void saveInventoryNoWarehouseExists() {
        int warehouseId = 1;
        int itemId = 1;
        int amount = 100;
        SimpleInventoryDto simpleInventoryDto = new SimpleInventoryDto(warehouseId, itemId, amount);
        Warehouse warehouse = new Warehouse();
        Item item = new Item();
        Inventory inventory = new Inventory();
        inventory.setWarehouseId(warehouseId);
        inventory.setItemId(itemId);
        inventory.setAmount(amount);
        inventory.setWarehouse(warehouse);
        inventory.setItem(item);

        when(itemRepository.findById(warehouseId)).thenReturn(Optional.ofNullable(item));
        when(warehouseRepository.findById(itemId)).thenReturn(Optional.empty());
        when(inventoryRepository.save(any(Inventory.class))).thenThrow(RuntimeException.class);

        inventoryService.save(simpleInventoryDto);

        assertThrows(RuntimeException.class, () -> inventoryService.save(simpleInventoryDto));
    }

    @Test(expectedExceptions = RuntimeException.class, priority = 1)
    public void saveInventoryNoItemExists() {
        int warehouseId = 1;
        int itemId = 1;
        int amount = 100;
        SimpleInventoryDto simpleInventoryDto = new SimpleInventoryDto(warehouseId, itemId, amount);
        Warehouse warehouse = new Warehouse();
        Item item = new Item();
        Inventory inventory = new Inventory();
        inventory.setWarehouseId(warehouseId);
        inventory.setItemId(itemId);
        inventory.setAmount(amount);
        inventory.setWarehouse(warehouse);
        inventory.setItem(item);

        when(itemRepository.findById(warehouseId)).thenReturn(Optional.empty());
        when(warehouseRepository.findById(itemId)).thenReturn(Optional.ofNullable(warehouse));
        when(inventoryRepository.save(any(Inventory.class))).thenThrow(RuntimeException.class);

        inventoryService.save(simpleInventoryDto);

        assertThrows(RuntimeException.class, () -> inventoryService.save(simpleInventoryDto));
    }

    @Test
    public void findInventoryById() {
        int warehouseId = 1;
        int itemId = 1;
        Optional<Inventory> inventory = Optional.ofNullable(new Inventory());

        when(inventoryRepository.findById(new InventoryKey(warehouseId, itemId))).thenReturn(inventory);

        Optional<Inventory> response = inventoryService.findById(warehouseId, itemId);

        assertEquals(inventory, response);
    }

    @Test
    public void findAllInventory() {
        List<Inventory> inventories = Arrays.asList(new Inventory(), new Inventory());

        when(inventoryRepository.findAll()).thenReturn(inventories);

        List<Inventory> response = inventoryService.findAll();

        assertEquals(inventories, response);
    }

    @Test
    public void updateInventory() {
        int warehouseId = 1;
        int itemId = 1;
        Inventory inventory = new Inventory();
        inventory.setWarehouseId(warehouseId);
        inventory.setItemId(itemId);

        when(inventoryRepository.existsById(new InventoryKey(warehouseId, itemId))).thenReturn(true);
        when(inventoryRepository.save(inventory)).thenReturn(inventory);

        Inventory response = inventoryService.update(warehouseId, itemId, inventory);

        assertEquals(inventory, response);
    }

    @Test(expectedExceptions = RuntimeException.class, priority = 1)
    public void updateInventoryNoInventoryExists() {
        int warehouseId = 1;
        int itemId = 1;
        Inventory inventory = new Inventory();

        when(inventoryRepository.existsById(new InventoryKey(warehouseId, itemId))).thenReturn(false);
        when(inventoryRepository.save(inventory)).thenThrow(RuntimeException.class);

        inventoryService.update(warehouseId, itemId, inventory);
        
        assertThrows(RuntimeException.class, () -> inventoryService.update(warehouseId, itemId, inventory));
    }

    @Test
    public void deleteInventoryById() {
        int warehouseId = 1;
        int itemId = 1;

        inventoryService.deleteById(warehouseId, itemId);

        verify(inventoryRepository).deleteById(new InventoryKey(warehouseId, itemId));
    }
}
