package com.skillstorm.backend.models;

import java.io.Serializable;

/*
 * InventoryKey
 * Serves as a composite primary key for the join table, inventory
 */
public class InventoryKey implements Serializable {
    
    private long warehouseId;
    private long itemId;

    public InventoryKey() {
    }

    public InventoryKey(long warehouseId, long itemId) {
        this.warehouseId = warehouseId;
        this.itemId = itemId;
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (warehouseId ^ (warehouseId >>> 32));
        result = prime * result + (int) (itemId ^ (itemId >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InventoryKey other = (InventoryKey) obj;
        if (warehouseId != other.warehouseId)
            return false;
        if (itemId != other.itemId)
            return false;
        return true;
    }

}
