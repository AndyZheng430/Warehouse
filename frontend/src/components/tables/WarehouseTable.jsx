import { useNavigate } from 'react-router-dom';
import classes from './Table.module.css';

export const WarehouseTable = ({ warehouses, handleEdit, getWarehouses }) => {

    const navigate = useNavigate();
    // delete warehouse request
    const handleDelete = async (id) => {
        await fetch(import.meta.env.VITE_DELETE_WAREHOUSE + "/" + id, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(console.log("Deleted Warehouse: " + id))
            .catch(error => { console.log(error) });

        // retrieve warehouses after deleting warehouse
        getWarehouses();
    }

    // display Modal UI to create inventory
    const handleView = (id) => {
        console.log("View Inventory");
        navigate("/warehouses/" + id);
    }

    return (
        <div className={classes.container}>
            <table className={classes.table}>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Owner</th>
                        <th>Location</th>
                        <th>Amount</th>
                        <th>Capacity</th>
                        <th className={classes.options}>Options</th>
                    </tr>
                </thead>
                <tbody>
                    {Array.isArray(warehouses) && warehouses.map(
                        warehouse => (
                            <tr key={warehouse.id} className={`${classes.row} warehouse-${warehouse.id}`}>
                                <td>{warehouse.name}</td>
                                <td>{warehouse.owner}</td>
                                <td>{warehouse.location}</td>
                                <td>{warehouse.amount}</td>
                                <td>{warehouse.maxCapacity}</td>
                                <td className={classes.options}>
                                    <button type='button' className={classes.view} onClick={() => handleView(warehouse.id)}>
                                        View
                                    </button>
                                    <button type='button' className={classes.edit} onClick={() => handleEdit(warehouse)}>
                                        Edit
                                    </button>
                                    <button type='button' className={classes.delete} onClick={() => handleDelete(warehouse.id)}>
                                        Delete
                                    </button>
                                </td>
                            </tr>
                        )
                    )}
                </tbody>
            </table>
        </div>
    )
}
