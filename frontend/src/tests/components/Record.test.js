import React from 'react';
import { render, fireEvent} from '@testing-library/react';
import '@testing-library/jest-dom'; 
import { Record } from '../../components/records/Record';



describe(Record,()=>{


  it('should render record details with a valid warehouse object', () => {
    const warehouse = { id: 1, name: 'Warehouse 1', owner: 'Owner 1', location: 'Location 1', maxCapacity: 100, inventory: [] };
    const setShowInventoryModal = jest.fn();
    const setInventoryWarehouseId = jest.fn();
    const setInventoryItem = jest.fn();
    const handleDelete = jest.fn();
    const handleEdit = jest.fn();
    const handleDeleteInventory = jest.fn();

    const { getByText } = render(
      <Record 
        warehouse={warehouse} 
        handleDelete={handleDelete} 
        handleEdit={handleEdit} 
        handleDeleteInventory={handleDeleteInventory} 
        setShowInventoryModal={setShowInventoryModal} 
        setInventoryWarehouseId={setInventoryWarehouseId} 
        setInventoryItem={setInventoryItem} 
      />
    );

    expect(getByText('Warehouse 1')).toBeInTheDocument();
    expect(getByText('Owner 1')).toBeInTheDocument();
    expect(getByText('Location 1')).toBeInTheDocument();
  });

    it('should toggle inventory display when the display button is clicked', () => {
        const warehouse = { id: 1, name: 'Warehouse 1', owner: 'Owner 1', location: 'Location 1', maxCapacity: 100, inventory: [] };
        const setShowInventoryModal = jest.fn();
        const setInventoryWarehouseId = jest.fn();
        const setInventoryItem = jest.fn();
        const handleDelete = jest.fn();
        const handleEdit = jest.fn();
        const handleDeleteInventory = jest.fn();
  
        const { getByRole } = render(
          <Record 
            warehouse={warehouse} 
            handleDelete={handleDelete} 
            handleEdit={handleEdit} 
            handleDeleteInventory={handleDeleteInventory} 
            setShowInventoryModal={setShowInventoryModal} 
            setInventoryWarehouseId={setInventoryWarehouseId} 
            setInventoryItem={setInventoryItem} 
          />
        );
  
        const displayButton = getByRole('separator', { name: "" });
        fireEvent.click(displayButton);
  
        expect(displayButton).toBeInTheDocument();
      });


})