package com.skillstorm.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.models.InventoryKey;
import com.skillstorm.backend.repositories.InventoryRepository;

import jakarta.transaction.Transactional;

@Service
public class InventoryService {
    
    private InventoryRepository repo;

    public InventoryService(InventoryRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Inventory save(Inventory item) {
        return repo.save(item);
    }

    public Optional<Inventory> findById(int warehouseId, int itemId) {
        return repo.findById(new InventoryKey(warehouseId, itemId));
    }

    public List<Inventory> findAll() {
        return repo.findAll();
    }

    @Transactional
    public void update(int warehouseId, int itemId, Inventory inventory) {
        if (!repo.existsById(new InventoryKey(warehouseId, itemId))) {
            // throw exception
        }
        inventory.setWarehouseId(warehouseId);
        inventory.setItemId(itemId);
        repo.save(inventory);
    }

    @Transactional
    public void deleteById(int warehouseId, int itemId) {
        repo.deleteById(new InventoryKey(warehouseId, itemId));
    }
}
