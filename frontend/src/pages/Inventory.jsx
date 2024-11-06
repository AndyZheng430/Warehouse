import { useEffect, useState } from "react";
import { useParams } from "react-router-dom"
import { Header } from "../components/header/Header";
import { InventoryTable } from "../components/tables/InventoryTable";
import { SingleWarehouseTable } from "../components/tables/SingleWarehouseTable";

export const Inventory = () => {

    let { id: warehouseId } = useParams(); // destructure id to warehouseId
    const [warehouse, setWarehouse] = useState({});

    useEffect(() => {
        getWarehouse();
    }, []);

    const getWarehouse = async () => {
        await fetch(import.meta.env.VITE_GET_WAREHOUSES + "/" + warehouseId)
            .then(response => {
                return response.json();
            })
            .then(data => {
                const amount = data.inventory.reduce((sum, item) => sum + item.amount, 0);
                const updatedData = { ...data, amount }
                setWarehouse(updatedData);
                console.log(updatedData);
            })
            .catch(error => { console.log(error) });
    }

    const handleEdit = () => {
        console.log("Edit");
    }

    return (
        <>
            <Header title={"Inventory: " + warehouse.name} />
            <hr style={{ width: '90%' }} />
            <h2 style={{textAlign:"left", paddingLeft: "1%"}}>Warehouse:</h2>
            <SingleWarehouseTable 
                warehouse={warehouse}
            />
            <h2 style={{textAlign:"left", paddingLeft: "1%"}}>Inventory: </h2>
            <InventoryTable 
                inventories={warehouse.inventory}
                handleEdit={handleEdit}
                getWarehouse={getWarehouse}
            />
        </>
    )
}