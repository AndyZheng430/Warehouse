import './WarehouseTitle.css';

export const WarehouseTitle = ({setShowModal}) => {

  function displayModal(e) {
    setShowModal(true);
  }
  
  return (
    <div className="title-container">
      <div className="title">Warehouses</div>
			<div className="create"> 
				<button onClick={displayModal}>
					Add Warehouse
				</button>
			</div>
    </div>
  );
}