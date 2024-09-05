import React from 'react';
import { render, fireEvent} from '@testing-library/react';
import '@testing-library/jest-dom'; 
import { ItemRecord } from '../../components/records/ItemRecord';





describe(ItemRecord,() =>{
    it('should render item record with correct item details', () => {
        const item = { id: 1, name: 'Dumbell', description: '50lbs' };
        const { getByText, getByClassName } = render(<ItemRecord item={item} handleDelete={() => {}} handleEdit={() => {}} />);
    
        expect(getByText(item.id)).toBeInTheDocument();
        expect(getByText(item.name)).toBeInTheDocument();
        expect(getByText(item.description)).toBeInTheDocument();
      });
    
})