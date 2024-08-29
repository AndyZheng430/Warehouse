package com.skillstorm.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.backend.dtos.WarehouseDto;
import com.skillstorm.backend.models.Warehouse;
import com.skillstorm.backend.services.WarehouseService;

import jakarta.validation.Valid;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/warehouses")
@CrossOrigin
public class WarehouseController {
    
    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService repo) {
        this.warehouseService = repo;
    }

    @GetMapping()
    public ResponseEntity<List<WarehouseDto>> getAll() {
        return ResponseEntity.ok(warehouseService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WarehouseDto> getWarehouse(@PathVariable int id) {
        WarehouseDto warehouse = warehouseService.findById(id);
        return ResponseEntity.ok(warehouse);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Warehouse> createWarehouse(@Valid @RequestBody Warehouse warehouse) {
        warehouseService.save(warehouse);
        return ResponseEntity.status(HttpStatus.CREATED).body(warehouse);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<Warehouse> updateWarehouse(@PathVariable int id, @RequestBody Warehouse warehouse) {
        return ResponseEntity.status(HttpStatus.OK).body(warehouseService.update(id, warehouse));
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteWarehouse(@PathVariable int id) {
        warehouseService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
