import { useState, useEffect } from 'react';
import { Record } from '../components/Record.jsx';
import { WarehouseLabel } from '../components/WarehouseLabel.jsx';
import { Header } from '../components/Header.jsx';
import { WarehouseModal } from '../components/modals/WarehouseModal.jsx';

export const Warehouse = () => {

	const [warehouses, setWarehouses] = useState([]);
	const [showWarehouseModal, setShowWarehouseModal] = useState(false);
	const [editWarehouse, setEditWarehouse] = useState();

	
	useEffect(()=> {
		getWarehouses();
	}, []);
	
	const getWarehouses = async () => {
		fetch(import.meta.env.VITE_GET_WAREHOUSES)
			.then(response => response.json())
			.then(data => {
				setWarehouses(data);
				console.log(data);
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

	const handleEdit = (warehouse) => {
		setEditWarehouse(warehouse);
        setShowWarehouseModal(true);
	}

	return (
		<>
			<Header title="Warehouses" setShowModal={setShowWarehouseModal} />
			<hr style={{width: '90%'}}/> 
			<WarehouseLabel />
			<hr />
			{warehouses && warehouses.map(
				warehouse => (
					<Record key={warehouse.id} warehouse={warehouse} handleDelete={() => handleDelete(warehouse.id)} handleEdit={() => handleEdit(warehouse)} />
				)
			)}
			{ showWarehouseModal && <WarehouseModal setShowModal={setShowWarehouseModal} editWarehouse={editWarehouse} setEditWarehouse={setEditWarehouse} warehouses={warehouses} setWarehouses={setWarehouses} /> }
		</>
	);
}