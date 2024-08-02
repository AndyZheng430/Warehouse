import classes from './WarehouseModal.module.css';
import { useState } from 'react';

export const WarehouseModal = ({setShowModal, editWarehouse, setEditWarehouse, warehouses, setWarehouses}) => {

  const [message, setMessage] = useState();
  const [error, setError] = useState();

  function closeModal() {
    setShowModal(false);
  }

  function handleSubmit(e) {
    e.preventDefault();

    const data = new FormData(e.target);

    const warehouseData = {
      name: data.get("warehouseName"),
      owner: data.get("warehouseOwner"),
      location: data.get("warehouseLocation"),
      maxCapacity: data.get("warehouseCapacity")
    }
    
    e.target.reset();

    closeModal();
    
    if (warehouse) {
      fetch(import.meta.env.VITE_EDIT_WAREHOUSE+"/"+warehouse?.id, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(warehouseData)
      })
      .then(data => data.json())
      .then((returnedData) => {
        console.log(returnedData);
        setMessage("Succesfully updated Warehouse " + returnedData?.name);
      })
      .catch(err => {
        console.log(err);
        setError(err);
      });
    } else {
      fetch(import.meta.env.VITE_CREATE_WAREHOUSE, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(warehouseData)
      })
      .then(data => data.json())
      .then((returnedData) => {
        setWarehouses([...warehouses, returnedData]);
        console.log(returnedData);
        setMessage("Succesfully created new Warehouse " + returnedData?.name);
      })
      .catch(err => {
        console.log(err);
        setError(err);
      });
    }
  }

  return (
    <div className={classes.modal}>
      <div className={classes.content}>
        <div className={classes.title}>
          <h2>Create Warehouse</h2>
          <span className={classes.close} onClick={closeModal}>&times;</span>
        </div>
        <hr />
        <form action="#" method="post" onSubmit={handleSubmit}>
          <div className={classes.row}> 
            <div className={classes.input}>
              <label htmlFor="warehouse-name">Name: </label>
              <input type="text" id="warehouse-name" name="warehouseName" value={warehouse?.name} />
            </div>
            <div className={classes.input}>
              <label htmlFor="warehouse-owner">Owner: </label>
              <input type="text" id="warehouse-owner" name="warehouseOwner" value={warehouse?.owner} />
            </div>
            <div className={classes.input}>
              <label htmlFor="warehouse-location">Location: </label>
              <input type="text" id="warehouse-location" name="warehouseLocation" value={warehouse?.location} />
            </div>
            <div className={classes.input}>
              <label htmlFor="warehouse-capacity">Maximum Capacity: </label>
              <input type="number" id="warehouse-capacity" name="warehouseCapacity" value={warehouse?.maxCapacity} />
            </div>
          </div>
          <div>
            <hr />
            <button onSubmit={(e)=>handleSubmit(e)}>Submit</button>
          </div>
        </form>
      </div>
    </div>

  );
}