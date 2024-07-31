DROP TABLE IF EXISTS item_formula, inventory, warehouse, item;

CREATE TABLE warehouse (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    location VARCHAR(255),
    owner VARCHAR(255),
    max_capacity BIGINT
);

CREATE TABLE item (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255),
    description Text
);

CREATE TABLE inventory (
    warehouse_id BIGINT references warehouse(id),
	item_id BIGINT references item(id),
	amount BIGINT,
    PRIMARY KEY (warehouse_id, item_id)
);

CREATE TABLE item_formula (
    id BIGSERIAL PRIMARY KEY,
    material BIGINT references item(id),
    item_id BIGINT references item(id),
	amount int
);