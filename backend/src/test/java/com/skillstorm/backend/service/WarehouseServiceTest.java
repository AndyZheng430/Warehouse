package com.skillstorm.backend.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mockStatic;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;
import java.util.Optional;
import java.util.Arrays;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.skillstorm.backend.dtos.WarehouseDto;
import com.skillstorm.backend.mapper.WarehouseMapper;
import com.skillstorm.backend.models.Warehouse;
import com.skillstorm.backend.repositories.WarehouseRepository;
import com.skillstorm.backend.services.WarehouseService;

public class WarehouseServiceTest {
    @Mock
    private WarehouseRepository warehouseRepository;

    @InjectMocks
    private WarehouseService warehouseService;
    private AutoCloseable closeable;
    private MockedStatic<WarehouseMapper> warehouseMapper;

    @BeforeTest
    public void setup() {
        closeable = MockitoAnnotations.openMocks(this);
        warehouseMapper = mockStatic(WarehouseMapper.class);
    }

    @AfterTest
    public void teardown() throws Exception {
        closeable.close();
        warehouseMapper.close();
    }

    @Test 
    public void saveWarehouseTest() {
        Warehouse warehouse = new Warehouse();
        
        when(warehouseRepository.save(warehouse)).thenReturn(warehouse);

        Warehouse response = warehouseService.save(warehouse);

        assertEquals(response, warehouse);
    }

    @Test
    public void findWarehouseById() {
        int id = 1;
        Warehouse warehouse = new Warehouse();
        WarehouseDto warehouseDto = new WarehouseDto();

        when(warehouseRepository.findById(id)).thenReturn(Optional.ofNullable(warehouse));
        when(WarehouseMapper.toDTO(warehouse)).thenReturn(warehouseDto);
        
        WarehouseDto response = warehouseService.findById(id);

        assertEquals(response, warehouseDto);
    }

    @Test
    public void findAllWarehouses() {
        Warehouse warehouse1 = new Warehouse();
        Warehouse warehouse2 = new Warehouse();
        WarehouseDto warehouseDto1 = new WarehouseDto();
        WarehouseDto warehouseDto2 = new WarehouseDto();

        List<Warehouse> warehouses = Arrays.asList(warehouse1, warehouse2);
        
        when(warehouseRepository.findAll()).thenReturn(warehouses);

        when(WarehouseMapper.toDTO(warehouse1)).thenReturn(warehouseDto1);
        when(WarehouseMapper.toDTO(warehouse2)).thenReturn(warehouseDto2);

        List<WarehouseDto> response = warehouseService.findAll();

        assertEquals(response.size(), 2);
        assertEquals(response.get(0), warehouseDto1);
        assertEquals(response.get(1), warehouseDto2);
    }

    @Test
    public void updateWarehouse() {
        int id = 1;
        Warehouse warehouse = new Warehouse();

        when(warehouseRepository.existsById(id)).thenReturn(true);
        when(warehouseRepository.save(warehouse)).thenReturn(warehouse);

        Warehouse response = warehouseService.update(id, warehouse);

        assertEquals(warehouse, response);
    }

    @Test
    public void deleteWarehouse() {
        int id = 1;

        warehouseService.deleteById(id);

        verify(warehouseRepository).deleteById(id);
    }
}
