package com.skillstorm.backend.dtos;

public class SimpleInventoryDto {
    
    private int warehouseId;
    private int amount;
    private int item;

    public SimpleInventoryDto() {
    }

    public SimpleInventoryDto(int warehouseId, int item, int amount) {
        this.warehouseId = warehouseId;
        this.item = item;
        this.amount = amount;
    }

    public int getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(int warehouseId) {
        this.warehouseId = warehouseId;
    }

    public int getItemId() {
        return item;
    }

    public void setItemId(int item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

}
