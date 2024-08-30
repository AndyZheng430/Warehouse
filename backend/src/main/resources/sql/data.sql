-- 1. Clear existing data using TRUNCATE with CASCADE
TRUNCATE TABLE inventory;
TRUNCATE TABLE item RESTART IDENTITY CASCADE;
TRUNCATE TABLE warehouse RESTART IDENTITY CASCADE;


-- 2. Insert mock data into warehouse table
INSERT INTO warehouse (name, location, owner, max_capacity) VALUES
('Woodshop', 'New York', 'John Doe', 1000),
('Clothing depot', 'Los Angeles', 'Jane Smith', 1500),
('Water works', 'Chicago', 'Alice Johnson', 1200),
('Gym equipment', 'Orlando', 'Arnold', 1500);

-- 3. Insert mock data into item table
INSERT INTO item (name, description) VALUES
('Oak Wood', 'Premium wood'),
('Couch', 'Furniture Item'),
('Shirt', 'Clothing Item'),
('barbell', 'Olympic 45 pound'),
('45lb bumper plate', 'Blue rubber');

-- 4. Insert mock data into inventory table
-- Ensure that the warehouse_id and item_id match the IDs inserted into the warehouse and item tables
INSERT INTO inventory (warehouse_id, item_id, amount) VALUES
(1, 1, 100),
(1, 2, 200),
(2, 1, 150),
(2, 3, 50),
(3, 2, 300),
(3, 3, 250),
(4, 4, 50),
(4, 5, 100);