import classes from './Record.module.css';
import { useState } from 'react';
import { IoIosArrowDown, IoIosArrowUp } from "react-icons/io";
import { InventoryRecord } from './InventoryRecord.jsx';
import { MdEdit } from "react-icons/md";
import { FaTrash, FaPlus } from "react-icons/fa";

export const Record = ({warehouse, handleDelete, handleEdit, handleDeleteInventory, setShowInventoryModal, setInventoryWarehouseId, setInventoryItem}) => {

	const [showInventory, setShowInventory] = useState(false);

	const toggleInventory = () => {
		setShowInventory(!showInventory);
	}

	const handleCreateInventory = () => {
		setShowInventoryModal(true);
		setInventoryWarehouseId(warehouse.id);
	}

	const handleEditInventory = (inventory) => {
		setShowInventoryModal(true);
		setInventoryItem(inventory);
	}

	return (
		<>
			<div className={classes.record}>
				<div className={classes.check}></div>
				<div className={classes.col}>{warehouse.name}</div>
				<div className={classes.col}>{warehouse.owner}</div>
				<div className={classes.col}>{warehouse.location}</div>
				<div className={classes.col}>{warehouse.maxCapacity}</div>
				<div className={`${classes.add} ${classes.option}`} onClick={handleCreateInventory}>
					<FaPlus />
				</div>
				<div className={`${classes.edit} ${classes.option}`} onClick={handleEdit}>
					<MdEdit />
				</div>
				<div className={`${classes.delete} ${classes.option}`} onClick={handleDelete}>
					<FaTrash />
				</div>
				<div className={`${classes.option} ${classes.display}`} onClick={toggleInventory}>
					{ showInventory ? <IoIosArrowUp /> : <IoIosArrowDown /> }
				</div>
			</div>
			<hr />
			{(showInventory && warehouse.inventory?.length > 0) && warehouse.inventory.map(
				inventory => {
					return (
						<InventoryRecord 
							key={inventory.item.itemId + " " + inventory.warehouseId} 
							itemId={inventory.item.itemId} 
							warehouseId={inventory.warehouseId} 
							name={inventory.item.name} 
							amount={inventory.amount} 
							handleDelete={()=>handleDeleteInventory(inventory.warehouseId, inventory.item.itemId)}
							handleEdit={()=>handleEditInventory(inventory)}
						/>
					);
				}
			)}
		</>
	);
}