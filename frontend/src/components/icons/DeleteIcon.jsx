import classes from './DeleteIcon.module.css';
import { FaTrash } from "react-icons/fa";

export const DeleteIcon = ({click}) => {
    return (
        <FaTrash onClick={click} className={classes.delete}/> 
    );
}