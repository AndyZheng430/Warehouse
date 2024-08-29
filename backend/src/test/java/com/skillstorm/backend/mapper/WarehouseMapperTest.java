package com.skillstorm.backend.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.skillstorm.backend.dtos.InventoryDto;
import com.skillstorm.backend.dtos.ItemDto;
import com.skillstorm.backend.dtos.WarehouseDto;
import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.models.Warehouse;

public class WarehouseMapperTest {
    
    @Test
    public void testToDto() {
        Warehouse warehouse = new Warehouse(1, "name", "location", "owner", 1000);
        Item item = new Item(1, "name", "description");
        Inventory inventory = new Inventory(warehouse.getId(), item.getId(), 100, warehouse, item);
        warehouse.setInventories(Arrays.asList(inventory));
        
        WarehouseDto WarehouseDto = WarehouseMapper.toDTO(warehouse);

        assertNotNull(WarehouseDto);
        assertEquals(1, WarehouseDto.getId());
        assertEquals("name", WarehouseDto.getName());
        assertEquals("location", WarehouseDto.getLocation());
        assertEquals("owner", WarehouseDto.getOwner());
        assertEquals(1000, WarehouseDto.getMaxCapacity());

        List<InventoryDto> inventoryDtos = WarehouseDto.getInventory();
        assertNotNull(WarehouseDto.getInventory());
        assertEquals(1, inventoryDtos.size());

        InventoryDto inventoryDto = inventoryDtos.get(0);
        assertEquals(1, inventoryDto.getWarehouseId());
        assertEquals(100, inventoryDto.getAmount());
        
        ItemDto itemDto = inventoryDto.getItem();
        assertNotNull(itemDto);
        assertEquals(1, itemDto.getItemId());
        assertEquals("name", itemDto.getName());
        assertEquals("description", itemDto.getDescription());
    }
}
