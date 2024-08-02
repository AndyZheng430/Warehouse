import classes from './Record.module.css';
import { useState } from 'react';
import { IoIosArrowDown, IoIosArrowUp } from "react-icons/io";
import { InventoryRecord } from './InventoryRecord.jsx';
import { MdEdit } from "react-icons/md";
import { FaTrash, FaPlus } from "react-icons/fa";

export const Record = ({warehouse, handleDelete, handleEdit}) => {

	const [showInventory, setShowInventory] = useState(false);

	const toggleInventory = () => {
		setShowInventory(!showInventory);
	}

	const handleCreateInventory = () => {}
	
	// console.log(warehouse);

	return (
		<>
			<div className={classes.record}>
				<div className={classes.check}></div>
				<div className={classes.col}>{warehouse.name}</div>
				<div className={classes.col}>{warehouse.owner}</div>
				<div className={classes.col}>{warehouse.location}</div>
				<div className={classes.col}>{warehouse.capacity}</div>
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
						<InventoryRecord key={inventory.item.itemId} name={inventory.item.name} amount={inventory.amount} />
					);
				}
			)}
		</>
	);
}