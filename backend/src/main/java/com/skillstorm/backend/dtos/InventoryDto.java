package com.skillstorm.backend.dtos;

public class InventoryDto {
    
    private long warehouseId;
    private long amount;
    private ItemDto item;

    public InventoryDto() {
    }

    public InventoryDto(long warehouseId, ItemDto item, long amount) {
        this.warehouseId = warehouseId;
        this.item = item;
        this.amount = amount;
    }

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

}
