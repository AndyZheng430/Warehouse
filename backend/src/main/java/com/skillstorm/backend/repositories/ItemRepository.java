package com.skillstorm.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.skillstorm.backend.models.Item;

public interface ItemRepository extends JpaRepository<Item, Integer>  {
    
}
