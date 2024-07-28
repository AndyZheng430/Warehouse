package com.skillstorm.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.backend.models.Warehouse;
import com.skillstorm.backend.respositories.WarehouseRespository;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/warehouses")
public class WarehouseController {
    
    public WarehouseRespository warehouseRespository;

    public WarehouseController(WarehouseRespository repo) {
        this.warehouseRespository = repo;
    }

    @GetMapping()
    public List<Warehouse> getAll() {
        return warehouseRespository.findAll();
    }
    
}
