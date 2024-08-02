import { useState, useEffect } from 'react';
import { Record } from '../components/records/Record.jsx';
import { WarehouseLabel } from '../components/labels/WarehouseLabel.jsx';
import { Header } from '../components/header/Header.jsx';
import { WarehouseModal } from '../components/modals/WarehouseModal.jsx';
import { InventoryModal } from '../components/modals/InventoryModal.jsx';

export const Warehouse = () => {

	const [warehouses, setWarehouses] = useState([]);
	const [editWarehouse, setEditWarehouse] = useState();
	const [inventoryWarehouseId, setInventoryWarehouseId] = useState();
	const [inventoryItem, setInventoryItem] = useState();
	const [showWarehouseModal, setShowWarehouseModal] = useState(false);
	const [showInventoryModal, setShowInventoryModal] = useState(false);
	
	useEffect(()=> {
		getWarehouses();
	}, []);
	
	// get request for all warehouses
	const getWarehouses = async () => {
		fetch(import.meta.env.VITE_GET_WAREHOUSES)
			.then(response => response.json())
			.then(data => {
				setWarehouses(data);
				console.log(data);
			})
			.catch(error => {console.log(error)});
	}

	// removes inventory if the item exists in that warehouse
	const removeInventory = (warehouseId, itemId) => {
		return warehouses.map(warehouse => {
			if (warehouseId === warehouse.id) {
				return {
					...warehouse,
					inventory: warehouse.inventory.filter(item => item.item.itemId === itemId)
				}
			}
			return warehouse;
		});
	} 

	// delete warehouse request
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

	// display Modal UI for warehouse edit
	const handleEdit = (warehouse) => {
		setEditWarehouse(warehouse);
    setShowWarehouseModal(true);
	}

	// delete inventory request
	const handleDeleteInventory = async (id1, id2) => {
		fetch(import.meta.env.VITE_DELETE_INVENTORY+"/"+id1 + "/"+ id2, {
			method: "DELETE",
			headers: {
				"Content-Type": "application/json"
			}
		})
		.then(() => {
			const newWarehouses = removeInventory(id1, id2);
			setWarehouses(newWarehouses)
		})
		.catch(error => {console.log(error)});
	}

	return (
		<>
			<Header title="Warehouses" setShowModal={setShowWarehouseModal} />
			<hr style={{width: '90%'}}/> 
			<WarehouseLabel />
			<hr />
			{warehouses && warehouses.map(
				warehouse => (
					<Record 
						key={warehouse.id} 
						warehouse={warehouse} 
						handleDelete={() => handleDelete(warehouse.id)} 
						handleEdit={() => handleEdit(warehouse)} 
						handleDeleteInventory={handleDeleteInventory}
						setShowInventoryModal={setShowInventoryModal}
						setInventoryWarehouseId={setInventoryWarehouseId}
						setInventoryItem={setInventoryItem}
					/>
				)
			)}
			{ showWarehouseModal && 
				<WarehouseModal 
					setShowModal={setShowWarehouseModal} 
					editWarehouse={editWarehouse} 
					setEditWarehouse={setEditWarehouse} 
					warehouses={warehouses} 
					setWarehouses={setWarehouses} 
				/> 
			}
			{ showInventoryModal && 
				<InventoryModal 
					setShowModal={setShowInventoryModal} 
					warehouseId={inventoryWarehouseId} 
					setWarehouseId={setInventoryWarehouseId}
					inventory={inventoryItem}
					setInventory={setInventoryItem}
				/> 
			}
		</>
	);
}