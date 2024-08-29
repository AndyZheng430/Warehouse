package com.skillstorm.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.backend.dtos.SimpleInventoryDto;
import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.models.InventoryKey;
import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.models.Warehouse;
import com.skillstorm.backend.repositories.InventoryRepository;
import com.skillstorm.backend.repositories.ItemRepository;
import com.skillstorm.backend.repositories.WarehouseRepository;

import jakarta.transaction.Transactional;

@Service
public class InventoryService {
    
    private InventoryRepository inventoryRepository;
    private WarehouseRepository warehouseRepository;
    private ItemRepository itemRepository;

    public InventoryService(InventoryRepository inventoryRepository, WarehouseRepository warehouseRepository, ItemRepository itemRepository) {
        this.inventoryRepository = inventoryRepository;
        this.warehouseRepository = warehouseRepository;
        this.itemRepository = itemRepository;
    }

    // Queries for warehouse and item information and creates new inventory object
    @Transactional
    public Inventory save(SimpleInventoryDto dto) {
        Optional<Warehouse> warehouse = warehouseRepository.findById(dto.getWarehouseId());
        Optional<Item> item = itemRepository.findById(dto.getItemId());
        System.out.println(warehouse.toString());
        System.out.println(item.toString());
        if (!warehouse.isPresent()) {
            throw new RuntimeException("Warehouse not found");
        }
        if (!item.isPresent()) {
            throw new RuntimeException("Item not found");
        }
        return inventoryRepository.save(new Inventory(dto.getWarehouseId(), dto.getItemId(), dto.getAmount(), warehouse.get(), item.get()));

    }

    public Optional<Inventory> findById(int warehouseId, int itemId) {
        return inventoryRepository.findById(new InventoryKey(warehouseId, itemId));
    }

    public List<Inventory> findAll() {
        return inventoryRepository.findAll();
    }

    @Transactional
    public Inventory update(int warehouseId, int itemId, Inventory inventory) {
        if (!inventoryRepository.existsById(new InventoryKey(warehouseId, itemId))) {
            throw new RuntimeException("Inventory does not exists");
        }
        inventory.setWarehouseId(warehouseId);
        inventory.setItemId(itemId);
        return inventoryRepository.save(inventory);
    }

    @Transactional
    public void deleteById(int warehouseId, int itemId) {
        inventoryRepository.deleteById(new InventoryKey(warehouseId, itemId));
    }
}
