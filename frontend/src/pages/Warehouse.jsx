import { useState, useEffect } from 'react';
import { Record } from '../components/Record.jsx';
import { TableLabel } from '../components/TableLabel.jsx';
import { WarehouseTitle } from '../components/WarehouseTitle.jsx';

export const Warehouse = () => {

	const [warehouses, setWarehouses] = useState([]);

	console.log(import.meta.env.VITE_GET_WAREHOUSES);
	
	useEffect(()=> {
		fetch(import.meta.env.VITE_GET_WAREHOUSES)
			.then(response => response.json())
			.then(data => {
				setWarehouses(data);
			})
			.catch(error => {console.log(error)});
	}, []);


	return (
		<>
			<WarehouseTitle />
			<hr style={{width: '90%'}}/> 
			<TableLabel name="Name" owner="Owner" location="Location" capacity="Max Capacity" />
			<hr />
			{warehouses && warehouses.map(
				warehouse => (
					<>
						<Record key={warehouse.id} name={warehouse.name} location={warehouse.location} owner={warehouse.owner} capacity={warehouse.maxCapacity} />
						<hr />
					</>
				)
			)}
		</>
	);
}