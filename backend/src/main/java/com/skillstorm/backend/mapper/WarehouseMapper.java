package com.skillstorm.backend.mapper;

import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.skillstorm.backend.dtos.InventoryDto;
import com.skillstorm.backend.dtos.ItemDto;
import com.skillstorm.backend.dtos.WarehouseDto;
import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.models.Warehouse;

/*
 * WarehouseMapper
 * Converts Warehouse Object into a non-circular referencing DTO, which can access inventory and item information.
 */
@Component
public class WarehouseMapper {
    public static WarehouseDto toDTO(Warehouse warehouse) {
        WarehouseDto dto = new WarehouseDto();
        dto.setId(warehouse.getId());
        dto.setName(warehouse.getName());
        dto.setOwner(warehouse.getOwner());
        dto.setLocation(warehouse.getLocation());
        dto.setMaxCapacity(warehouse.getMaxCapacity());
        dto.setInventory(warehouse.getInventories().stream()
                .map((Inventory inventory) -> WarehouseMapper.toInventoryDTO(inventory))
                .collect(Collectors.toList()));
        return dto;
    }

    private static InventoryDto toInventoryDTO(Inventory inventory) {
        InventoryDto dto = new InventoryDto();
        dto.setWarehouseId(inventory.getWarehouseId());
        dto.setItem(toItemDTO(inventory.getItem()));
        dto.setAmount(inventory.getAmount());
        return dto;
    }

    private static ItemDto toItemDTO(Item item) {
        ItemDto dto = new ItemDto();
        dto.setItemId(item.getId());
        dto.setName(item.getName());
        dto.setDescription(item.getDescription());
        return dto;
    }
}
