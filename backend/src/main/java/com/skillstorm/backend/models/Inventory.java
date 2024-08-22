package com.skillstorm.backend.models;


import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;


@Entity
@Table(name = "inventory")
@IdClass(InventoryKey.class)
public class Inventory { 
    
    @Id
    @Column(name = "warehouse_id")
    private long warehouseId;

    @Id
    @Column(name = "item_id")
    private long itemId;

    @Column(name = "amount")
    @Min(0)
    private long amount;

    @ManyToOne(targetEntity = Item.class)
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "item_id", nullable = false, insertable = false, updatable = false)
    @JsonManagedReference
    @JsonIgnore
    private Item item;

    @ManyToOne(targetEntity = Warehouse.class)
    @Cascade({CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "warehouse_id", nullable = false, insertable = false, updatable = false)
    @JsonManagedReference
    @JsonIgnore
    private Warehouse warehouse; 

    public Inventory() {
    }

    // public Inventory(long warehouseId, long itemId, long amount) {
    //     this.warehouseId = warehouseId;
    //     this.itemId = itemId;
    //     this.amount = amount;
    // }

    public Inventory(long warehouseId, long itemId, long amount, Warehouse warehouse, Item item) {
        this.warehouseId = warehouseId;
        this.itemId = itemId;
        this.amount = amount;
        this.warehouse = warehouse;
        this.item = item;
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
        return "Inventory [warehouseId=" + warehouseId + ", itemId=" + itemId + ", amount=" + amount + "]";
    }

}