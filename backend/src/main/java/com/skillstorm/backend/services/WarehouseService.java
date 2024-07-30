package com.skillstorm.backend.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.backend.models.Warehouse;
import com.skillstorm.backend.respositories.WarehouseRespository;

import jakarta.transaction.Transactional;

@Service
public class WarehouseService {
    
    private WarehouseRespository warehouseRespository;

    public WarehouseService(WarehouseRespository repo) {
        this.warehouseRespository = repo;
    }

    @Transactional
    public Warehouse save(Warehouse warehouse) {
        return warehouseRespository.save(warehouse);
    }

    public Optional<Warehouse> findById(int id) {
        // need to throw exception if id is not found
        return warehouseRespository.findById(id);
    }

    public List<Warehouse> findAll() {
        return warehouseRespository.findAll();
    }

    @Transactional
    public void update(int id, Warehouse warehouse) {
        if (!warehouseRespository.existsById(id)) {
            // throw exception and use advice to handle it
        }
        warehouse.setId(id);
        warehouseRespository.save(warehouse);
    }

    @Transactional
    public void deleteById(int id) {
        warehouseRespository.deleteById(id);
    }

}
