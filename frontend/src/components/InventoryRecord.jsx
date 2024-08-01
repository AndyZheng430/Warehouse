import classes from './InventoryRecord.module.css';
import { DeleteIcon } from './icons/DeleteIcon.jsx';
import { EditIcon } from './icons/EditIcon.jsx';

export const InventoryRecord = ({id, name, amount}) => {

	return (
		<>
			<div className={classes.container}>
				<div className={classes.details}>
					<div className="label row">
						<div className={`${classes.label} ${classes.col4}`}>Name</div>
						<div className={`${classes.label} ${classes.col4}`}>Quantity</div>
					</div>
					<div className="data row" >
						<div className={`${classes.data} ${classes.col4}`}>{name}</div>
						<div className={`${classes.data} ${classes.col4}`}>{amount}</div>
					</div>
				</div>
				<div className={`${classes.col4} ${classes.controls}`}>
					<EditIcon />
					<DeleteIcon />
				</div>
			</div>
			<hr />
		</>
	);
	
}