package com.skillstorm.backend.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.backend.models.Warehouse;
import com.skillstorm.backend.respositories.WarehouseRespository;

@Service
public class WarehouseService {
    
    private WarehouseRespository warehouseRespository;

    public WarehouseService(WarehouseRespository repo) {
        this.warehouseRespository = repo;
    }

    public Optional<Warehouse> findById(int id) {
        return warehouseRespository.findById(id);
    }

    public void deleteById(int id) {
        warehouseRespository.deleteById(id);
    }
}
