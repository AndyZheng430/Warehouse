package com.skillstorm.backend.models;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "inventory")
@IdClass(InventoryKey.class)
public class Inventory { 
    
    @Id
    private long warehouseId;

    @Id
    private long itemId;

    @Column
    private long amount;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Item.class)
    @JoinColumn(name = "item_id", nullable = false)
    private Item item;

    @ManyToOne(fetch = FetchType.LAZY, targetEntity = Warehouse.class)
    @JoinColumn(name = "warehouse_id", nullable = false)
    private Warehouse warehouse; 

    public Inventory() {
    }

    public Inventory(long warehouseId, long itemId, long amount) {
        this.warehouseId = warehouseId;
        this.itemId = itemId;
        this.amount = amount;
    }

    public long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Warehouse getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }

    @Override
    public String toString() {
        return "Inventory [warehouseId=" + warehouseId + ", itemId=" + itemId + ", amount=" + amount + ", item=" + item
                + ", warehouse=" + warehouse + "]";
    }

}