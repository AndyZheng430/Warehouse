import classes from './Record.module.css';
import { useState } from 'react';
import { IoIosArrowDown, IoIosArrowUp } from "react-icons/io";
import { InventoryRecord } from './InventoryRecord.jsx';
import { DeleteIcon } from './icons/DeleteIcon.jsx';
import { EditIcon } from './icons/EditIcon.jsx';

export const Record = ({name, owner, location, capacity, inventories}) => {

	const [showInventory, setShowInventory] = useState(false);

	const toggleInventory = () => {
			setShowInventory(!showInventory);
	}
	
	return (
		<>
			<div className={classes.record}>
				<div className={classes.col10}> </div>
				<div className={classes.col5}>{name}</div>
				<div className={classes.col5}>{owner}</div>
				<div className={classes.col5}>{location}</div>
				<div className={classes.col5}>{capacity}</div>
				<div className={classes.col10}>
					<EditIcon />
					<DeleteIcon />
					{showInventory ? 
					<IoIosArrowUp className={classes.display} onClick={toggleInventory} />
					:
					<IoIosArrowDown className={classes.display} onClick={toggleInventory} />
					}
				</div>
			</div>
			<hr />
			{(showInventory && inventories.length > 0) && inventories.map(
				inventory => {
					return (
						<InventoryRecord key={inventory.item.itemId} name={inventory.item.name} amount={inventory.amount} />
					);
				}
			)}
		</>
	);
}