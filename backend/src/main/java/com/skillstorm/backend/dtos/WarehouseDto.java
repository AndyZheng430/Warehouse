package com.skillstorm.backend.dtos;

import java.util.List;

public class WarehouseDto {
    private long id;
    private String name;
    private String location;
    private String owner;
    private long maxCapacity;
    private List<InventoryDto> inventory;

    public WarehouseDto() {}
    
    public WarehouseDto(long id, String name, String location, String owner, long maxCapacity,
            List<InventoryDto> inventory) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.owner = owner;
        this.maxCapacity = maxCapacity;
        this.inventory = inventory;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public long getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(long maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<InventoryDto> getInventory() {
        return inventory;
    }

    public void setInventory(List<InventoryDto> inventory) {
        this.inventory = inventory;
    }

    
}
