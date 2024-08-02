import classes from './InventoryModal.module.css';
import { useState } from 'react';

export const InventoryModal = ({setShowModal, item}) => {

  const [message, setMessage] = useState();
  const [error, setError] = useState();

  function closeModal() {
    setShowModal(false);
  }

  function handleSubmit(e) {
    e.preventDefault();

    const data = new FormData(e.target);

    const itemData = {
      name: data.get("itemName"),
      description: data.get("itemDescription"),
    }
    
    e.target.reset();

    closeModal();
    
    if (item) {
      fetch(import.meta.env.VITE_EDIT_ITEMS+"/"+item?.id, {
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
      fetch(import.meta.env.VITE_CREATE_ITEM, {
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
  }

  return (
    <div className={classes.modal}>
      <div className={classes.content}>
        <div className={classes.title}>
          <h2>Create Item</h2>
          <span className={classes.close} onClick={closeModal}>&times;</span>
        </div>
        <hr />
        <form action="#" method="post" onSubmit={handleSubmit}>
          <div className={classes.row}> 
            <div className={classes.input}>
              <label htmlFor="item-name">Name: </label>
              <input type="text" id="item-name" name="itemName" value={item?.name} />
            </div>
            <div className={classes.input}>
              <label htmlFor="item-description">Owner: </label>
              <input type="text" id="item-description" name="itemDescription" value={item?.description} />
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
}