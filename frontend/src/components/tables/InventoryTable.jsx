import classes from './Table.module.css';

export const InventoryTable = ({ inventories, handleEdit, getWarehouse }) => {

    // delete warehouse request
    const handleDelete = async (id) => {
        await fetch(import.meta.env.VITE_DELETE_INVENTORY + "/" + id, {
            method: "DELETE",
            headers: {
                "Content-Type": "application/json"
            }
        })
            .then(console.log("Deleted Inventory: " + id))
            .catch(error => { console.log(error) });

        // retrieve warehouses after deleting warehouse
        getWarehouse();
    }

    return (
        <div className={classes.container}>
            <table className={classes.table}>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Amount</th>
                        <th className={classes.options}>Options</th>
                    </tr>
                </thead>
                <tbody>
                    {Array.isArray(inventories) && inventories.map(
                        (inventory, index) => (
                            <tr key={index} className={`${classes.row} inventory-${inventory.item.itemId}`}>
                                <td>{inventory.item.name}</td>
                                <td>{inventory.amount}</td>
                                <td className={classes.options}>
                                    <button type='button' className={classes.edit} onClick={() => handleEdit(inventory)}>
                                        Edit
                                    </button>
                                    <button type='button' className={classes.delete} onClick={() => handleDelete(inventory.id)}>
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
