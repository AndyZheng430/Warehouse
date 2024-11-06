import './App.css'
import { useState } from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { SideNavbar } from './components/navbar/SideNavbar.jsx'
import { Warehouse, Item, Inventory } from './pages';

function App() {
  const [collapse, setCollapse] = useState(true);

  return (
    <>
      <main>
        <BrowserRouter>

          <SideNavbar collapse={collapse} setCollapse={setCollapse} />
          <div className={collapse ? "content-minimize" : "content-maximize"} >
            <Routes>
              <Route path='/' element={<Warehouse />}/>
              <Route path='/warehouses' element={<Warehouse />}/>
              <Route path='/items' element={<Item />} />
              <Route path='/warehouses/:id' element={<Inventory />} />
            </Routes>
          </div>
        </BrowserRouter>
      </main>
    </>
  )
}

export default App
