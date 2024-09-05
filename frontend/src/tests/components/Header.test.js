import React from 'react';
import { render, screen} from '@testing-library/react';
import '@testing-library/jest-dom'; 
import { Header } from '../../components/header/Header';


describe(Header,()=>{
  
  it('should render the header component with the provided title', () => {
     render(<Header title="Test Title" setShowModal={() => {}} />);
     const text = screen.getByText('Test Title');
    expect(text).toBeInTheDocument();
  });


})