import classes from './WarehouseLabel.module.css';

export const WarehouseLabel = () => {

    return (
        <div className={classes.container}>
            <div className={`${classes.check} ${classes.label}`}></div>
            <div className={classes.col}>Name</div>
            <div className={classes.col}>Owner</div>
            <div className={classes.col}>Location</div>
            <div className={classes.col}>Maximum Capacity</div>
            <div className={`${classes.option} ${classes.label}`}>Add</div>
            <div className={`${classes.option} ${classes.label}`}>Edit</div>
            <div className={`${classes.option} ${classes.label}`}>Delete</div>
            <div className={classes.option}></div>
        </div>
    );
}