import React from 'react';
import { render, fireEvent, screen} from '@testing-library/react';
import '@testing-library/jest-dom'; 
import { ItemRecord } from '../../components/records/ItemRecord';





describe(ItemRecord,() =>{
    it('should render item record with correct item details', () => {
        const item = { id: 1, name: 'Dumbell', description: '50lbs' };
        const { getByText } = render(<ItemRecord item={item} handleDelete={() => {}} handleEdit={() => {}} />);
    
        expect(getByText(item.id)).toBeInTheDocument();
        expect(getByText(item.name)).toBeInTheDocument();
        expect(getByText(item.description)).toBeInTheDocument();
      });
    
      it('should call handleDelete function when delete button is clicked', () => {
        const handleDelete = jest.fn();
        const item = { id: 1, name: 'Dumbell', description: '50lbs' };
        
        render(<ItemRecord item={item} handleDelete={handleDelete} handleEdit={() => {}} />)
        const deleteButton = screen.getByLabelText('delete');
        fireEvent.click(deleteButton);
        expect(handleDelete).toHaveBeenCalled();
    });
})