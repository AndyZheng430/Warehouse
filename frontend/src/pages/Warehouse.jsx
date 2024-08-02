import { useState, useEffect } from 'react';
import { Record } from '../components/Record.jsx';
import { WarehouseLabel } from '../components/WarehouseLabel.jsx';
import { Header } from '../components/Header.jsx';
import { WarehouseModal } from '../components/modals/WarehouseModal.jsx';

export const Warehouse = () => {

	const [warehouses, setWarehouses] = useState([]);
	const [showWarehouseModal, setShowWarehouseModal] = useState(false);
	const [editWarehouse, setEditWarehouse] = useState();

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
			<Header title="Warehouses" setShowModal={setShowWarehouseModal} />
			<hr style={{width: '90%'}}/> 
			<WarehouseLabel />
			<hr />
			{warehouses && warehouses.map(
				warehouse => (
					<Record key={warehouse.id} editWarehouse={editWarehouse} setEditWarehouse={setEditWarehouse} handleDelete={() => handleDelete(warehouse.id)} handleEdit={() => handleEdit(warehouse.id)} />
				)
			)}
			{ showWarehouseModal && <WarehouseModal setShowModal={setShowWarehouseModal} warehouses={warehouses} setWarehouses={setWarehouses} /> }
		</>
	);
}