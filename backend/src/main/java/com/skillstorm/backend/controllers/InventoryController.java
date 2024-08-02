package com.skillstorm.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.backend.dtos.InventoryDto;
import com.skillstorm.backend.models.Inventory;
import com.skillstorm.backend.services.InventoryService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

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
@RequestMapping("/inventory")
@CrossOrigin
public class InventoryController {
    
    private InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping()
    public List<Inventory> getAll() {
        return inventoryService.findAll();
    }
    
    @GetMapping("/{warehouseId}/{itemId}")
    public Optional<Inventory> getInventoryById(@PathVariable int warehouseId, @PathVariable int itemId) {
        return inventoryService.findById(warehouseId, itemId);
    }
    
    @PostMapping("/create")
    public ResponseEntity<Inventory> createInventory(@Valid @RequestBody InventoryDto inventoryDto) {
        Inventory inventory = inventoryService.save(inventoryDto);
        return ResponseEntity.ok(inventory);
    }
    
    @PutMapping("edit/{warehouseId}/{itemId}")
    public void putMethodName(@PathVariable int warehouseId, @PathVariable int itemId, @RequestBody Inventory inventory) {
        inventoryService.update(warehouseId, itemId, inventory);
    }

    @DeleteMapping("/delete/{warehouseId}/{itemId}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable int warehouseId, @PathVariable int itemId) {
        inventoryService.deleteById(warehouseId, itemId);
    }
}
