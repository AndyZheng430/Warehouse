import classes from './WarehouseTitle.module.css';
import { FaPlus } from "react-icons/fa";

export const WarehouseTitle = ({setShowModal}) => {

  function displayModal() {
    setShowModal(true);
  }
  
  return (
    <div className={classes.container}>
      <div className={classes.title}>Warehouses</div>
			<div className={classes.create}> 
				<button onClick={displayModal}>
          <FaPlus /> Create
				</button>
			</div>
    </div>
  );
}