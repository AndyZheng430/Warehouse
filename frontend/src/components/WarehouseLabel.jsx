import classes from './WarehouseLabel.module.css';

export const WarehouseLabel = ({name, owner, location, capacity}) => {

    return (
        <div className={classes.container}>
            <div className={`${classes.check} ${classes.label}`}></div>
            <div className={classes.col}>{name}</div>
            <div className={classes.col}>{owner}</div>
            <div className={classes.col}>{location}</div>
            <div className={classes.col}>{capacity}</div>
            <div className={`${classes.option} ${classes.label}`}>Add</div>
            <div className={`${classes.option} ${classes.label}`}>Edit</div>
            <div className={`${classes.option} ${classes.label}`}>Delete</div>
            <div className={classes.option}></div>
        </div>
    );
}