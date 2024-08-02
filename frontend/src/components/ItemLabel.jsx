import classes from './ItemLabel.module.css';

export const ItemLabel = () => {

    return (
        <div className={classes.container}>
            <div className={`${classes.check} ${classes.label}`}></div>
            <div className={classes.id}>Id</div>
            <div className={classes.name}>Name</div>
            <div className={classes.description}>Description</div>
            <div className={`${classes.option} ${classes.label}`}>Edit</div>
            <div className={`${classes.option} ${classes.label}`}>Delete</div>
            <div className={classes.option}></div>
        </div>
    );
}