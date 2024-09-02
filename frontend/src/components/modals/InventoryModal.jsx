import classes from './InventoryModal.module.css';
import { useState } from 'react';

export const InventoryModal = ({setShowModal, warehouseId, inventory, getWarehouses}) => {

  const [message, setMessage] = useState();
  const [error, setError] = useState();

  function closeModal() {
    setShowModal(false);
  }

  function handleSubmit(e) {
    e.preventDefault();

    const data = new FormData(e.target);

    e.target.reset();

    closeModal();
    
    if (inventory) {
      // sets up inventory object
      const itemData = {
        warehouseId: inventory.warehouseId,
        itemId: data.get("itemId"),
        amount: data.get("amount")
      }

      // send put request to edit inventory
      fetch(import.meta.env.VITE_EDIT_INVENTORY+"/"+inventory?.warehouseId+"/"+inventory.item.itemId, {
        method: "PUT",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(itemData)
      })
      .then(data => data.json())
      .then((returnedData) => {
        console.log(returnedData);
        setMessage("Succesfully updated Item " + returnedData?.name);
      })
      .catch(err => {
        console.log(err);
        setError(err);
      });
    } else {
      // sets up inventory object
      const itemData = {
        warehouseId: warehouseId,
        itemId: data.get("itemId"),
        amount: data.get("amount")
      }

      // send post request to create new inventory
      fetch(import.meta.env.VITE_CREATE_INVENTORY, {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(itemData)
      })
      .then(data => data.json())
      .then((returnedData) => {
        console.log(returnedData);
        setMessage("Succesfully created new Item " + returnedData?.name);
      })
      .catch(err => {
        console.log(err);
        setError(err);
      });
    }

    getWarehouses();
  }

  return (
    <div className={classes.modal}>
      <div className={classes.content}>
        <div className={classes.title}>
          <h2>Create Inventory</h2>
          <span className={classes.close} onClick={closeModal}>&times;</span>
        </div>
        <hr />
        <form action="#" method="post" onSubmit={handleSubmit}>
          <div className={classes.row}> 
            <div className={classes.input}>
              <label htmlFor="item-id">Item Id: </label>
              <input type="text" id="item-id" name="itemId" defaultValue={inventory?.item?.itemId} />
            </div>
            <div className={classes.input}>
              <label htmlFor="inventory-amount">Amount: </label>
              <input type="text" id="inventory-amount" name="amount" defaultValue={inventory?.amount} />
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