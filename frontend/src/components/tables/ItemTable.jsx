import classes from './Table.module.css';

export const ItemTable = ({ items, handleEdit, getItems }) => {

    // delete item request
	const handleDelete = async (id) => {
		await fetch(import.meta.env.VITE_DELETE_ITEM+"/"+id, {
			method: "DELETE",
			headers: {
				"Content-Type": "application/json"
			}
		})
		.then(console.log("Deleted " + id))
		.catch(error => {console.log(error)});

		getItems();
	}

    return (
        <div className={classes.container}>
            <table className={classes.table}>
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Description</th>
                        <th className={classes.options}>Options</th>
                    </tr>
                </thead>
                <tbody>
                    {Array.isArray(items) && items.map(
                        item => (
                            <tr key={item.id} className={`${classes.row} item-${item.id}`}>
                                <td>{item.name}</td>
                                <td>{item.description}</td>
                                <td className={classes.options}>
                                    <button type='button' className={classes.edit} onClick={() => handleEdit(item)}>
                                        Edit
                                    </button>
                                    <button type='button' className={classes.delete} onClick={() => handleDelete(item.id)}>
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
