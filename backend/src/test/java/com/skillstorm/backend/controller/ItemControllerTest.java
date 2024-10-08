package com.skillstorm.backend.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.skillstorm.backend.controllers.ItemController;
import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.services.ItemService;

public class ItemControllerTest {
    
    @Mock
    private ItemService itemService;

    @InjectMocks
    private ItemController itemController;
    private AutoCloseable closeable;

    @BeforeTest
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterTest
    public void teardown() throws Exception {
        closeable.close();
    }

    @Test
    public void testGetAllItems() {
        List<Item> items = Arrays.asList(new Item(), new Item());
        
        when(itemService.findAll()).thenReturn(items);

        ResponseEntity<List<Item>> response = itemController.getAll();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), items);
    }

    @Test
    public void testGetItemById() {
        int id = 1;
        Item item = new Item();
        
        when(itemService.findById(id)).thenReturn(Optional.ofNullable(item));

        ResponseEntity<Item> response = itemController.getItem(id);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), item);
    }

    @Test
    public void testGetItemByIdNotFound() {
        int id = 1;
        
        when(itemService.findById(id)).thenReturn(Optional.empty());

        ResponseEntity<Item> response = itemController.getItem(id);

        assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
    }

    @Test void testGetItemsByName() {
        String name = "name";
        List<Item> items = Arrays.asList(new Item(), new Item());

        when(itemService.findByName(name)).thenReturn(items);

        List<Item> response = itemController.getItemsByName(name);

        assertEquals(items, response);
    }
    
    @Test
    public void testCreateItem() {
        Item item = new Item();
        
        when(itemService.save(item)).thenReturn(item);

        ResponseEntity<Item> response = itemController.createItem(item);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), item);
    }

    @Test
    public void testUpdateItem() {
        int id = 1;
        Item item = new Item();
        
        when(itemService.update(id, item)).thenReturn(item);

        ResponseEntity<Item> response = itemController.updateItem(id, item);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), item);
    }

    @Test 
    public void testDeleteItem() {
        int id = 1;

        ResponseEntity<Void> response = itemController.deleteItem(id);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}
