import classes from './InventoryRecord.module.css';
import { MdEdit } from "react-icons/md";
import { FaTrash } from "react-icons/fa";

export const InventoryRecord = ({itemId, warehouseId, name, amount, handleDelete, handleEdit}) => {

	return (
		<>
			<div className={`${classes.container} ${itemId}-${warehouseId}`}>
				<div className={classes.details}>
					<div className="label row">
						<div className={`${classes.label} ${classes.col4}`}>Name</div>
						<div className={`${classes.label} ${classes.col4}`}>Quantity</div>
					</div>
					<div className="data row" >
						<div className={`${classes.data} ${classes.col4} inventory-name`}>{name}</div>
						<div className={`${classes.data} ${classes.col4} inventory-amount`}>{amount}</div>
					</div>
				</div>
				<div className={classes.controls}>
					<div className={`${classes.edit} ${classes.option}`} onClick={handleEdit}>
						<MdEdit />
					</div>
					<div className={`${classes.delete} ${classes.option}`} onClick={handleDelete}>
						<FaTrash />
					</div>
				</div>
			</div>
			<hr />
		</>
	);
	
}