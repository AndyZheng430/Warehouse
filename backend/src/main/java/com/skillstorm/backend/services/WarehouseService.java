package com.skillstorm.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.backend.dtos.WarehouseDto;
import com.skillstorm.backend.mapper.WarehouseMapper;
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
    
    public WarehouseDto findById(int id) {
        Warehouse warehouse = repo.findById(id).orElseThrow(() -> new RuntimeException("Warehouse not found with id " + id));
        WarehouseDto dto = WarehouseMapper.toDTO(warehouse);
        return dto;
    }

    public List<WarehouseDto> findAll() {
        return repo.findAll().stream().map((Warehouse warehouse)->WarehouseMapper.toDTO(warehouse)).toList();
    }

    @Transactional
    public Warehouse update(int id, Warehouse warehouse) {
        if (!repo.existsById(id)) {
            // throw exception and use advice to handle it
        }
        warehouse.setId(id);
        return repo.save(warehouse);
    }

    @Transactional
    public void deleteById(int id) {
        repo.deleteById(id);
    }

}
