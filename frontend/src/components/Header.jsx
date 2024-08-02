import classes from './Header.module.css';
import { FaPlus } from "react-icons/fa";

export const Header = ({title, setShowModal}) => {

  function displayModal() {
    setShowModal(true);
  }
  
  return (
    <div className={classes.container}>
      <div className={classes.title}>{title}</div>
			<div className={classes.create}> 
				<button onClick={displayModal}>
          <FaPlus /> Create
				</button>
			</div>
    </div>
  );
}