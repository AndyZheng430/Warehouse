package com.skillstorm.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.skillstorm.backend.controllers.ItemController;
import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.services.ItemService;

public class ItemControllerTests {
    
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
    public void getAllItems() {
        List<Item> items = Arrays.asList(new Item(), new Item());
        
        when(itemService.findAll()).thenReturn(items);

        ResponseEntity<List<Item>> response = itemController.getAll();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), items);
    }

    @Test
    public void getItemById() {
        int id = 1;
        Optional<Item> item = Optional.ofNullable(new Item());
        
        when(itemService.findById(id)).thenReturn(item);

        ResponseEntity<Item> response = itemController.getItem(id);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), item);
    }

    @Test
    public void createItem() {
        Item item = new Item();
        
        when(itemService.save(item)).thenReturn(item);

        ResponseEntity<Item> response = itemController.createItem(item);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), item);
    }

    @Test
    public void editItem() {
        int id = 1;
        Item item = new Item();
        
        when(itemService.save(item)).thenReturn(item);

        ResponseEntity<Item> response = itemController.createItem(item);

        verify(itemService).update(id, item);
        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), item);
    }

    @Test 
    public void deleteItem() {
        int id = 1;

        ResponseEntity<Void> response = itemController.deleteItem(id);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}
