INSERT INTO customers (id, name, cell) VALUES (1, 'Ibrahim Chowdhury', '+8801689443975');
INSERT INTO customers (id, name, cell) VALUES (2, 'Shah Marin', '+8801758445587');
INSERT INTO customers (id, name, cell) VALUES (3, 'Ismail Chowdhury', '+8801689443567');
INSERT INTO customers (id, name, cell) VALUES (4, 'Ibrahim Khalil', '+8801689443456');

INSERT INTO products (id, name, price, description) VALUES (1, 'Fabrilife Mens Premium Jacket', 1733.00, 'Micro Polar Fleece Fabric');
INSERT INTO products (id, name, price, description) VALUES (2, 'Denim Pant', 1500.00, 'Jeans fabric');
INSERT INTO products (id, name, price, description) VALUES (3, 'Table lamp', 500.00, 'Attractive Table lamp');
INSERT INTO products (id, name, price, description) VALUES (4, 'Ceiling Fan', 2500.00, 'Black Fan');
INSERT INTO products (id, name, price, description) VALUES (5, 'Polo t-shirt', 500.00, 'Cotton fabric t-shirt');
INSERT INTO products (id, name, price, description) VALUES (6, 'Apple Watch', 40000.00, 'Apple branded smartwatch');
INSERT INTO products (id, name, price, description) VALUES (7, 'Digital wall clock', 1200.00, 'Wall clock');

INSERT INTO orders (id, order_date, address) VALUES (1, '2022-04-01', 'Dhaka Bangladesh');
INSERT INTO orders (id, order_date, address) VALUES (2, '2022-04-01', 'Dhaka Bangladesh');
INSERT INTO orders (id, order_date, address) VALUES (3, '2022-04-01', 'Dhaka Bangladesh');
INSERT INTO orders (id, order_date, address) VALUES (4, '2022-04-02', 'Dhaka Bangladesh');
INSERT INTO orders (id, order_date, address) VALUES (5, '2024-02-01', 'Dhaka Bangladesh');
INSERT INTO orders (id, order_date, address) VALUES (6, '2024-02-01', 'Dhaka Bangladesh');
INSERT INTO orders (id, order_date, address) VALUES (7, '2022-04-03', 'Dhaka Bangladesh');
INSERT INTO orders (id, order_date, address) VALUES (8, '2022-04-03', 'Dhaka Bangladesh');
INSERT INTO orders (id, order_date, address) VALUES (9, '2022-04-03', 'Dhaka Bangladesh');
INSERT INTO orders (id, order_date, address) VALUES (10, '2022-04-04', 'Dhaka Bangladesh');

INSERT INTO customers_orders (customers_id, orders_id) values (1,1);
INSERT INTO customers_orders (customers_id, orders_id) values (1,2);
INSERT INTO customers_orders (customers_id, orders_id) values (2,3);
INSERT INTO customers_orders (customers_id, orders_id) values (3,4);
INSERT INTO customers_orders (customers_id, orders_id) values (4,5);
INSERT INTO customers_orders (customers_id, orders_id) values (4,6);
INSERT INTO customers_orders (customers_id, orders_id) values (3,7);
INSERT INTO customers_orders (customers_id, orders_id) values (2,8);
INSERT INTO customers_orders (customers_id, orders_id) values (1,9);
INSERT INTO customers_orders (customers_id, orders_id) values (3,10);

INSERT INTO line_products (id, product_id, quantity, unit_price) values (1, 1, 2, 1733.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (2, 4, 3, 500.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (3, 1, 4, 1733.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (4, 1, 3, 1733.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (5, 4, 3, 500.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (6, 1, 3, 1733.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (7, 7, 5, 1200.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (8, 1, 7, 1733.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (9, 1, 3, 1733.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (10, 4, 3, 500.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (11, 7, 2, 1200.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (12, 1, 3, 1733.00);
INSERT INTO line_products (id, product_id, quantity, unit_price) values (13, 1, 3, 1733.00);


-- INSERT INTO line_products_product (line_products_id, product_id) values (1,1);
-- INSERT INTO line_products_product (line_products_id, product_id) values (2,4);
-- INSERT INTO line_products_product (line_products_id, product_id) values (3,1);
-- INSERT INTO line_products_product (line_products_id, product_id) values (4,1);
-- INSERT INTO line_products_product (line_products_id, product_id) values (5,4);
-- INSERT INTO line_products_product (line_products_id, product_id) values (6,1);
-- INSERT INTO line_products_product (line_products_id, product_id) values (7,7);
-- INSERT INTO line_products_product (line_products_id, product_id) values (8,1);
-- INSERT INTO line_products_product (line_products_id, product_id) values (9,1);
-- INSERT INTO line_products_product (line_products_id, product_id) values (10,4);
-- INSERT INTO line_products_product (line_products_id, product_id) values (11,7);
-- INSERT INTO line_products_product (line_products_id, product_id) values (12,1);
-- INSERT INTO line_products_product (line_products_id, product_id) values (13,1);

INSERT INTO orders_line_product (line_product_id, orders_id) values (1,1);
INSERT INTO orders_line_product (line_product_id, orders_id) values (2,2);
INSERT INTO orders_line_product (line_product_id, orders_id) values (3,3);
INSERT INTO orders_line_product (line_product_id, orders_id) values (4,4);
INSERT INTO orders_line_product (line_product_id, orders_id) values (5,5);
INSERT INTO orders_line_product (line_product_id, orders_id) values (6,6);
INSERT INTO orders_line_product (line_product_id, orders_id) values (7,7);
INSERT INTO orders_line_product (line_product_id, orders_id) values (8,8);
INSERT INTO orders_line_product (line_product_id, orders_id) values (9,9);
INSERT INTO orders_line_product (line_product_id, orders_id) values (10,10);
INSERT INTO orders_line_product (line_product_id, orders_id) values (11,1);
INSERT INTO orders_line_product (line_product_id, orders_id) values (12,2);
INSERT INTO orders_line_product (line_product_id, orders_id) values (13,3);

