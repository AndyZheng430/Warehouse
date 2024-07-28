package com.skillstorm.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "ItemFormula")
public class ItemFormula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    @Min(0)
    public int amount;

    @Column
    public long material;

    public long item_id; // remove 1-M


}
