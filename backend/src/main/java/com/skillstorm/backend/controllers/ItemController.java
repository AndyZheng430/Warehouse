package com.skillstorm.backend.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.services.ItemService;

import jakarta.validation.Valid;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
@RequestMapping("/items")
@CrossOrigin
public class ItemController {
    
    private ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping()
    public ResponseEntity<List<Item>> getAll() {
        return ResponseEntity.ok(itemService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Item> getItem(@PathVariable int id) {
        Optional<Item> item = itemService.findById(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    @GetMapping("/name/{name}")
    public List<Item> getItemsByName(@PathVariable String name) {
        return itemService.findByName(name);
    }

    @PostMapping("/create")
    public ResponseEntity<Item> createItem(@Valid @RequestBody Item item) {
        itemService.save(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(item);
    }
    
    @PutMapping("edit/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable int id, @RequestBody Item item) {
        return ResponseEntity.status(HttpStatus.OK).body(itemService.update(id, item));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable int id) {
        itemService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
