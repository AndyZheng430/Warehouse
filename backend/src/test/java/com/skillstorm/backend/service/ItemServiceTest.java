package com.skillstorm.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.skillstorm.backend.models.Item;
import com.skillstorm.backend.repositories.ItemRepository;
import com.skillstorm.backend.services.ItemService;

public class ItemServiceTest {
    @Mock
    private ItemRepository itemRepository;

    @InjectMocks
    private ItemService itemService;
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
    public void saveItem() {
        Item item = new Item();

        when(itemRepository.save(item)).thenReturn(item);

        Item response = itemService.save(item);

        assertEquals(item, response);
    }

    @Test
    public void findAllItems() {
        List<Item> items = Arrays.asList(new Item(), new Item());

        when(itemRepository.findAll()).thenReturn(items);

        List<Item> response = itemService.findAll();

        assertEquals(items, response);
    }

    @Test
    public void findItemById() {
        int id = 1;
        Optional<Item> item = Optional.ofNullable(new Item());

        when(itemRepository.findById(id)).thenReturn(item);

        Optional<Item> response = itemService.findById(id);

        assertEquals(item, response);
    }

    @Test
    public void findItemsByName() {
        String name = "name";
        List<Item> items = Arrays.asList(new Item(), new Item());

        when(itemRepository.findByName(name)).thenReturn(items);

        List<Item> response = itemService.findByName(name);

        assertEquals(items, response);
    }

    @Test
    public void updateItem() {
        int id = 1;
        Item item = new Item();

        when(itemRepository.save(item)).thenReturn(item);
        when(itemRepository.existsById(id)).thenReturn(true);

        Item response = itemService.update(id, item);

        assertEquals(item, response);
    }

    @Test
    public void updateItemNoItemExists() {
        int id = 1;
        Item item = new Item();

        when(itemRepository.save(item)).thenThrow(RuntimeException.class);
        when(itemRepository.existsById(id)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> itemService.update(id, item));
    }

    @Test
    public void deleteItemById() {
        int id = 1;

        itemService.deleteById(id);

        verify(itemRepository).deleteById(id);
    }
}
