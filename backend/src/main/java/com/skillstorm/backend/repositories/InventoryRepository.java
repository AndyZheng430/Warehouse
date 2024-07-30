package com.skillstorm.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.models.InventoryKey;

public interface InventoryRepository extends JpaRepository<Inventory, InventoryKey>{
    
}
