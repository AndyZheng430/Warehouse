import { useState, useEffect } from 'react';
import { Header } from '../components/header/Header.jsx';
import { WarehouseModal } from '../components/modals/WarehouseModal.jsx';
import { WarehouseTable } from '../components/tables/WarehouseTable.jsx';

export const Warehouse = () => {

	const [warehouses, setWarehouses] = useState([]);
	const [editWarehouse, setEditWarehouse] = useState();
	const [showWarehouseModal, setShowWarehouseModal] = useState(false);

	useEffect(() => {
		getWarehouses();
	}, []);

	// get request for all warehouses
	const getWarehouses = async () => {
		await fetch(import.meta.env.VITE_GET_WAREHOUSES)
			.then(response => response.json())
			.then(data => {
				const updatedData = data.map(warehouse => {
					const amount = warehouse.inventory.reduce((sum, item) => sum + item.amount, 0);
					return { ...warehouse, amount}
				});
				setWarehouses(updatedData);
				console.log(updatedData);
				console.log(Array.isArray(updatedData));
			})
			.catch(error => { console.log(error) });
	}


	// display Modal UI for warehouse edit
	const handleEdit = (warehouse) => {
		setEditWarehouse(warehouse);
		setShowWarehouseModal(true);
	}

	return (
		<>
			<Header title="Warehouses" setShowModal={setShowWarehouseModal} />
			<hr style={{ width: '90%' }} />
			<WarehouseTable 
				warehouses={warehouses}
				handleEdit={handleEdit}
				getWarehouses={getWarehouses}
			/>
			{showWarehouseModal &&
				<WarehouseModal
					setShowModal={setShowWarehouseModal}
					editWarehouse={editWarehouse}
					warehouses={warehouses}
					getWarehouses={getWarehouses}
				/>
			}
		</>
	);
}