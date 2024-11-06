import { useState, useEffect } from 'react';
import { Header } from '../components/header/Header.jsx';
import { ItemModal } from '../components/modals/ItemModal.jsx';
import { ItemTable } from '../components/tables/ItemTable.jsx';

export const Item = () => {

	const [items, setItems] = useState([]);
	const [showItemModal, setShowItemModal] = useState(false);
	const [editItem, setEditItem] = useState();

	useEffect(() => {
		getItems();
	}, []);

	// get item requests
	const getItems = async () => {
		await fetch(import.meta.env.VITE_GET_ITEMS)
			.then(response => response.json())
			.then(data => {
				console.log(data);
				setItems(data);
			})
			.catch(error => {console.log(error)});
	}

	// display Modal UI for items
	const handleEdit = (item) => {
		setEditItem(item);
		setShowItemModal(true);
	}

	return (
		<>
			<Header title="Items" setShowModal={setShowItemModal} />
			<hr style={{width: '90%'}}/>
			<ItemTable 
				items={items}
				handleEdit={handleEdit}
				getItems={getItems}
			/>
			{showItemModal && <ItemModal 
				setShowModal={setShowItemModal} 
				editItem={editItem} 
				items={items} 
				getItems={getItems}
			/>}
		</>
	)
}