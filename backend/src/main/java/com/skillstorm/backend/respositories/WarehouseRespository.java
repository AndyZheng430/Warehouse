package com.skillstorm.backend.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.backend.models.Warehouse;

public interface WarehouseRespository extends JpaRepository<Warehouse, Integer> {
    
}
