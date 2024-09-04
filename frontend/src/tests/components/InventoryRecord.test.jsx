import { render, screen } from '@testing-library/react';
import '@testing-library/jest-dom'; 
import { InventoryRecord } from '../../components/records/InventoryRecord';





describe(InventoryRecord,() =>{

    it('should render inventory record with correct item and warehouse IDs', () => {
        const { container } = render(
            <InventoryRecord 
                itemId="123" 
                warehouseId="456" 
                name="Item A" 
                amount="10" 
                handleDelete={() => {}} 
                handleEdit={() => {}} 
            />
        );
        const inventoryDiv = container.querySelector('.inventory-123-456');
        expect(inventoryDiv).toBeInTheDocument();
    });





})