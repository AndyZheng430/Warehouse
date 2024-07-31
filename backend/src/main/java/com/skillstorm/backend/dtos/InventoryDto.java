package com.skillstorm.backend.dtos;

public class InventoryDto {
    
    private int warehouseId;
    private int itemId;
    private int amount;

    public InventoryDto() {
    }

    public InventoryDto(int warehouseId, int itemId, int amount) {
        this.warehouseId = warehouseId;
        this.itemId = itemId;
        this.amount = amount;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    
}
