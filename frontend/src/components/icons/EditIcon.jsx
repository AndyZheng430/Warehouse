import classes from './EditIcon.module.css';
import { MdEdit } from "react-icons/md";

export const EditIcon = ({click}) => {
    return (
        <MdEdit onClick={click} className={classes.edit}/>
    );
}
