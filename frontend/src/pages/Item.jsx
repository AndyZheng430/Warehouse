import { useState, useEffect } from 'react';
import { Header } from '../components/header/Header.jsx';
import { ItemLabel } from '../components/labels/ItemLabel.jsx';
import { ItemRecord } from '../components/records/ItemRecord.jsx';
import { ItemModal } from '../components/modals/ItemModal.jsx';

export const Item = () => {

	const [items, setItems] = useState([]);
	const [showItemModal, setShowItemModal] = useState(false);
	const [editItem, setEditItem] = useState();

	useEffect(() => {
		getItems();
	}, []);

	// get item requests
	const getItems = async () => {
		fetch(import.meta.env.VITE_GET_ITEMS)
			.then(response => response.json())
			.then(data => {
				console.log(data);
				setItems(data);
			})
			.catch(error => {console.log(error)});
	}

	// delete item request
	const handleDelete = async (id) => {
		fetch(import.meta.env.VITE_DELETE_ITEM+"/"+id, {
			method: "DELETE",
			headers: {
				"Content-Type": "application/json"
			}
		})
		.then(console.log("Deleted " + id))
		.catch(error => {console.log(error)});

		getItems();
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
			<ItemLabel />
			<hr />
			{items?.length > 0 && items.map(
				item => (
					<ItemRecord 
						key={item.id} 
						item={item} 
						handleDelete={() => handleDelete(item.id)} 
						handleEdit={() => handleEdit(item)} 
					/>
				)
			)}
			{showItemModal && <ItemModal 
				setShowModal={setShowItemModal} 
				editItem={editItem} 
				setEditItem={setEditItem} 
				items={items} 
				setItems={setItems} 
			/>}
		</>
	)
}