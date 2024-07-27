DROP TABLE IF EXISTS warehouse, storage, item, itemFormula;

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

CREATE TABLE storage (
    id BIGSERIAL PRIMARY KEY,
	item_id BIGINT references item(id),
    warehouse_id BIGINT references warehouse(id),
	amount BIGINT
);

CREATE TABLE item_formula (
    id BIGSERIAL PRIMARY KEY,
    material BIGINT references item(id),
    item_id BIGINT references item(id),
	amount int
);