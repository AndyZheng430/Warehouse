package com.skillstorm.backend.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.repositories.ItemRepository;

import jakarta.transaction.Transactional;

@Service
public class ItemService {

    private ItemRepository repo;
    
    public ItemService(ItemRepository repo) {
        this.repo = repo;
    }

    @Transactional
    public Item save(Item item) {
        return repo.save(item);
    }

    public Optional<Item> findById(int id) {
        return repo.findById(id);
    }

    public List<Item> findAll() {
        return repo.findAll();
    }

    @Transactional
    public void update(int id, Item item) {
        if (!repo.existsById(id)) {
            // throw exception
        }
        item.setId(id);
        repo.save(item);
    }

    @Transactional
    public void deleteById(int id) {
        repo.deleteById(id);
    }
}
