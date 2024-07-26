DROP TABLE IF EXISTS Warehouse, Storage, Item, ItemFormula;

CREATE TABLE Warehouse (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    location VARCHAR(255),
    max_capacity BIGINT,
    owner VARCHAR(255)
);

CREATE TABLE Storage (
    id BIGSERIAL PRIMARY KEY,
    amount BIGINT,
    item_id references Item(id),
    warehouse_id references Warehouse(id)
);

CREATE TABLE Item (
    id BIGSERIAL,
    name VARCHAR(255),
    description Text
);

CREATE TABLE ItemFormula (
    id BIGSERIAL,
    material VARCHAR(255),
    amount int,
    item_id references Item(id)
);