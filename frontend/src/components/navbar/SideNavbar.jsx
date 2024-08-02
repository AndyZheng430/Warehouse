import classes from './SideNavbar.module.css';
import { Link } from 'react-router-dom';
import { HiBars3, HiBars3BottomRight } from "react-icons/hi2";
import { FaWarehouse } from "react-icons/fa";
import { LuBox } from "react-icons/lu";

export const SideNavbar = ({collapse, setCollapse}) => {
    
  const toggleNavbar = () => {
    setCollapse(!collapse);
  }
    
  return (
    <nav className={collapse ? classes.minimize : classes.maximize} > 
      <div className={classes.toggle}>
        {collapse ? 
          <HiBars3 onClick={toggleNavbar} /> 
          : 
          <>
            <span>RPG Warehouse</span> 
            <HiBars3BottomRight onClick={toggleNavbar} />
          </>}
      </div>
      <Link to="/warehouses">
        <FaWarehouse /> {!collapse && <>Warehouse</>}
      </Link>
      <Link to="/items">
        <LuBox /> {!collapse && <>Items</>}
      </Link>
    </nav>
  );
}