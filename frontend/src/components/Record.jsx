import classes from './Record.module.css';
import { useState } from 'react';
import { FaTrash } from "react-icons/fa";
import { IoIosArrowDown, IoIosArrowUp } from "react-icons/io";

export const Record = ({name, owner, location, capacity}) => {

    const [showInventory, setShowInventory] = useState(false);

    const toggleInventory = () => {
        setShowInventory(!showInventory);
    }

    return (
        <div className={classes.record}>
            <div className={classes.col10}> </div>
            <div className={classes.col5}>{name}</div>
            <div className={classes.col5}>{owner}</div>
            <div className={classes.col5}>{location}</div>
            <div className={classes.col5}>{capacity}</div>
            <div className={classes.col10}>
                <FaTrash className={classes.delete}/>
                {showInventory ? 
                <IoIosArrowUp className={classes.display} onClick={toggleInventory} />
                :
                <IoIosArrowDown className={classes.display} onClick={toggleInventory} />
                }
            </div>
        </div>
    );
}