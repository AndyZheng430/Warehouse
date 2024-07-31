package com.skillstorm.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.backend.models.Warehouse;
import com.skillstorm.backend.repositories.WarehouseRepository;

import jakarta.transaction.Transactional;

@Service
public class WarehouseService {
    
    private WarehouseRepository repo;

    public WarehouseService(WarehouseRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Warehouse save(Warehouse warehouse) {
        return repo.save(warehouse);
    }

    public Optional<Warehouse> findById(int id) {
        // need to throw exception if id is not found
        return repo.findById(id);
    }

    public List<Warehouse> findAll() {
        return repo.findAll();
    }

    @Transactional
    public void update(int id, Warehouse warehouse) {
        if (!repo.existsById(id)) {
            // throw exception and use advice to handle it
        }
        warehouse.setId(id);
        repo.save(warehouse);
    }

    @Transactional
    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
