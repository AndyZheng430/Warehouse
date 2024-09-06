import classes from './ItemRecord.module.css';
import { MdEdit } from "react-icons/md";
import { FaTrash } from "react-icons/fa";

export const ItemRecord = ({item, handleDelete, handleEdit}) => {

	return (
		<>
			<div className={`${classes.record} item-${item.id}`}>
				<div className={classes.check}></div>
				<div className={`${classes.id} item-id`}>{item.id}</div>
				<div className={`${classes.name} item-name`}>{item.name}</div>
				<div className={`${classes.description} item-description`}>{item.description ? item.description : "No description"}</div>
				<div className={`${classes.edit} ${classes.option}`} onClick={handleEdit}>
					<MdEdit />
				</div>
				<div className={`${classes.delete} ${classes.option}`} onClick={handleDelete} aria-label='delete'>
					<FaTrash />
				</div>
				<div className={classes.option}>
				</div>
			</div>
			<hr />
		</>
	);
}