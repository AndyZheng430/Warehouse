import './CreateWarehouseModal.css';
import { useState } from 'react';

export const CreateWarehouseModal = ({setShowModal}) => {

  const [message, setMessage] = useState();
  const [error, setError] = useState();

  function closeModal() {
    setShowModal(false);
  }

  function handleSubmit(e) {
    e.preventDefault();

    const data = new FormData(e.target);

    const warehouse = {
      name: data.get("warehouseName"),
      owner: data.get("warehouseOwner"),
      location: data.get("warehouseLocation"),
      maxCapacity: data.get("warehouseCapacity")
    }
  
    e.target.reset();
  
    fetch(import.meta.env.VITE_GET_INVENTORIES, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify(warehouse)
    })
      .then(data => data.json())
      .then((returnedData) => {
        console.log(returnedData);
        setMessage("Succesfully created new movie with id " + returnedData?.id);
      })
      .catch(err => {
        console.log(err);
        setError(err);
      });
  
  }

  return (
    <div className="warehouse-modal">
      <div className="modal-content">
        <h2>Create Warehouse</h2>
        <hr />
        <form action="#" method="post" onSubmit={handleSubmit}>
          <label htmlFor="warehouse-name">Name</label>
          <input type="text" id="warehouse-name" name="warehouseName" />
          <div>
            <label>Owner</label>
            <input type="text" id="warehouse-owner" name="warehouseOwner" />
          </div>
          <div>
            <label>Location</label>
            <input type="text" id="warehouse-location" name="warehouseLocation" />
          </div>
          <div>
            <label>Maximum Capacity</label>
            <input type="number" id="warehouse-capacity" name="warehouseCapacity" />
          </div>
          <button onSubmit={(e)=>handleSubmit(e)}>Submit</button>
          <button onClick={closeModal}>Close</button>
        </form>
      </div>
    </div>

  );
}