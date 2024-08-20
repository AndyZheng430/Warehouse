import './App.css'
import { useState } from 'react'
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import { SideNavbar } from './components/navbar/SideNavbar.jsx'
import { Warehouse, Item } from './pages';

function App() {
  const [collapse, setCollapse] = useState(true);

  return (
    <>
      <main>
        <BrowserRouter>

          <SideNavbar collapse={collapse} setCollapse={setCollapse} />
          <div className={collapse ? "content-minimize" : "content-maximize"} >
            <Routes>
              <Route path='/'/>
              <Route path='/warehouses' element={<Warehouse />}/>
              <Route path='/items' element={<Item />} />
            </Routes>
          </div>
        </BrowserRouter>
      </main>
    </>
  )
}

export default App
