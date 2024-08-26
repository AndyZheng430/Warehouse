package com.skillstorm.backend;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.skillstorm.backend.services.WarehouseService;
import com.skillstorm.backend.controllers.WarehouseController;
import com.skillstorm.backend.dtos.WarehouseDto;
import com.skillstorm.backend.models.Warehouse;

public class WarehouseControllerTests {
    
    @Mock
    private WarehouseService warehouseService;

    @InjectMocks
    private WarehouseController warehouseController;
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
    public void getAllWarehouses() {
        List<WarehouseDto> warehouses = Arrays.asList(new WarehouseDto(), new WarehouseDto());

        when(warehouseService.findAll()).thenReturn(warehouses);

        ResponseEntity<List<WarehouseDto>> response = warehouseController.getAll();

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), warehouses);
    }

    @Test
    public void getWarehouseById() {
        int id = 1; 
        WarehouseDto warehouse = new WarehouseDto();

        when(warehouseService.findById(id)).thenReturn(warehouse);

        ResponseEntity<WarehouseDto> response = warehouseController.getWarehouse(id);

        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), warehouse);
    }

    @Test
    public void createWarehouse() {
        Warehouse warehouse = new Warehouse();

        when(warehouseService.save(warehouse)).thenReturn(warehouse);

        ResponseEntity<Warehouse> response = warehouseController.createWarehouse(warehouse);

        assertEquals(response.getStatusCode(), HttpStatus.CREATED);
        assertEquals(response.getBody(), warehouse);
    }

    @Test
    public void editWarehouse() {
        int id = 1;
        Warehouse warehouse = new Warehouse();

        when(warehouseService.update(id, warehouse)).thenReturn(warehouse);

        ResponseEntity<Warehouse> response = warehouseController.updateWarehouse(id, warehouse);

        verify(warehouseService).update(id, warehouse);
        assertEquals(response.getStatusCode(), HttpStatus.OK);
        assertEquals(response.getBody(), warehouse);
    }

    @Test
    public void deleteWarehouse() {
        int id = 1;

        ResponseEntity<Void> response = warehouseController.deleteWarehouse(id);

        assertEquals(response.getStatusCode(), HttpStatus.NO_CONTENT);
    }
}
