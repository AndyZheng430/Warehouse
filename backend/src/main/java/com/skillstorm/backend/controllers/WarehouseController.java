package com.skillstorm.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.backend.models.Warehouse;
import com.skillstorm.backend.respositories.WarehouseRespository;
import com.skillstorm.backend.services.WarehouseService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.apache.catalina.connector.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;





@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    
    private WarehouseService warehouseService;

    public WarehouseController(WarehouseService repo) {
        this.warehouseService = repo;
    }

    @GetMapping()
    public List<Warehouse> getAll() {
        return warehouseService.findAll();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Warehouse> getWarehouse(@PathVariable int id) {
        Optional<Warehouse> warehouse = warehouseService.findById(id);
        if (warehouse.isPresent()) {
            return ResponseEntity.ok(warehouse.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @PostMapping("/create")
    @ResponseStatus(code = HttpStatus.CREATED)
    public Warehouse createWarehouse(@Valid @RequestBody Warehouse warehouse) {
        return warehouseService.save(warehouse);
    }

    @PutMapping("edit/{id}")
    public void putMethodName(@PathVariable int id, @RequestBody Warehouse warehouse) {
        warehouseService.update(id, warehouse);
    }
    
    @DeleteMapping("/delete/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteWarehouse(@PathVariable int id) {
        warehouseService.deleteById(id);
    }
}
