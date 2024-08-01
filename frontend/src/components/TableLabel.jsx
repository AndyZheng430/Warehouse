import './TableLabel.css';

export const TableLabel = ({name, owner, location, capacity}) => {

    return (
        <div className="tableHeader">
            <div className="col-10 tableLabel"></div>
            <div className="col-5 tableLabel">{name}</div>
            <div className="col-5 tableLabel">{owner}</div>
            <div className="col-5 tableLabel">{location}</div>
            <div className="col-5 tableLabel">{capacity}</div>
            <div className="col-10 tableLabel"></div>
        </div>
    );
}