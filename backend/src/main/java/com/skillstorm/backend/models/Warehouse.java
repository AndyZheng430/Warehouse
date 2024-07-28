package com.skillstorm.backend.models;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Min;

public class Warehouse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @Column
    private String location;

    @Column
    private String owner;

    @Min(0)
    private int maxCapacity;

    @OneToMany(mappedBy = "warehouse", targetEntity = Storage.class)
    @JsonBackReference
    private List<Storage> storages;
    
    public Warehouse() {
    }

    public Warehouse(long id, String name, String location, String owner, @Min(0) int maxCapacity) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.owner = owner;
        this.maxCapacity = maxCapacity;
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

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public List<Storage> getStorage() {
        return storages;
    }

    public void setStorage(List<Storage> storages) {
        this.storages = storages;
    }

    @Override
    public String toString() {
        return "Warehouse [id=" + id + ", name=" + name + ", location=" + location + ", owner=" + owner
                + ", maxCapacity=" + maxCapacity + "]";
    }

}
