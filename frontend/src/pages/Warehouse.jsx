import { useState, useEffect } from 'react';
import { Record } from '../components/Record.jsx';
import { WarehouseLabel } from '../components/WarehouseLabel.jsx';
import { WarehouseTitle } from '../components/WarehouseTitle.jsx';
import { WarehouseModal } from '../components/modals/WarehouseModal.jsx';

export const Warehouse = () => {

	const [warehouses, setWarehouses] = useState([]);
	const [showWarehouseModal, setShowWarehouseModal] = useState(false);

	console.log(import.meta.env.VITE_GET_WAREHOUSES);
	
	useEffect(()=> {
		getWarehouses();
	}, []);
	
	const getWarehouses = async () => {
		fetch(import.meta.env.VITE_GET_WAREHOUSES)
			.then(response => response.json())
			.then(data => {
				setWarehouses(data);
			})
			.catch(error => {console.log(error)});
	}

	const handleDelete = async (id) => {
		fetch(import.meta.env.VITE_DELETE_WAREHOUSE+"/"+id, {
			method: "DELETE",
			headers: {
				"Content-Type": "application/json"
			}
		})
		.then(setWarehouses(warehouses.filter(warehouse => warehouse.id !== id)))
		.catch(error => {console.log(error)});
	}

	function handleEdit(id) {
		console.log(id);
	}

	return (
		<>
			<WarehouseTitle setShowModal={setShowWarehouseModal} />
			<hr style={{width: '90%'}}/> 
			<WarehouseLabel name="Name" owner="Owner" location="Location" capacity="Max Capacity" />
			<hr />
			{warehouses && warehouses.map(
				warehouse => (
					<Record key={warehouse.id} warehouse={warehouse} handleDelete={() => handleDelete(warehouse.id)} handleEdit={() => handleEdit(warehouse.id)}/>
				)
			)}
			{ showWarehouseModal && <WarehouseModal setShowModal={setShowWarehouseModal} /> }
		</>
	);
}