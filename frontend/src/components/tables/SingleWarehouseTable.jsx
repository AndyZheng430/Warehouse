import classes from './Table.module.css';

export const SingleWarehouseTable = ({ warehouse }) => {

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
                    </tr>
                </thead>
                <tbody>
                    <tr key={warehouse.id}>
                        <td>{warehouse.name}</td>
                        <td>{warehouse.owner}</td>
                        <td>{warehouse.location}</td>
                        <td>{warehouse.amount}</td>
                        <td>{warehouse.maxCapacity}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    )
}
