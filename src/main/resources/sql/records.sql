-- Users
INSERT INTO users (name, email, password, role) VALUES
                                                    ('John Smith', 'john@example.com', 'pass123', 'CUSTOMER'),
                                                    ('Emily Johnson', 'emily@example.com', 'pass456', 'CUSTOMER'),
                                                    ('Michael Brown', 'michael@example.com', 'pass789', 'ADMIN');

-- Categories
INSERT INTO categories (name) VALUES
                                  ('Electronics'),
                                  ('Books'),
                                  ('Clothing'),
                                  ('Home Appliances');

-- Products
INSERT INTO products (name, description, price, stock, category_id) VALUES
                                                                        ('Smartphone X100', 'Latest 5G smartphone with AMOLED display', 699.99, 50, 1),
                                                                        ('Wireless Headphones', 'Noise cancelling over-ear headphones', 199.99, 30, 1),
                                                                        ('Gaming Laptop Z', 'High-performance laptop with RTX graphics', 1499.00, 15, 1),
                                                                        ('Science Fiction Novel', 'Bestselling sci-fi adventure book', 15.99, 100, 2),
                                                                        ('Cookbook Deluxe', 'Over 200 delicious recipes', 25.50, 80, 2),
                                                                        ('Men''s Leather Jacket', 'Stylish brown leather jacket', 120.00, 20, 3),
                                                                        ('Women''s Summer Dress', 'Light cotton dress for summer', 45.00, 25, 3),
                                                                        ('Blender Pro', 'High-speed kitchen blender', 89.99, 10, 4),
                                                                        ('Microwave Oven 700W', 'Compact microwave for small kitchens', 110.00, 8, 4);

-- Orders
INSERT INTO orders (order_date, status, total_price, user_id) VALUES
                                                                  ('2025-08-01 10:15:00', 'COMPLETED', 899.98, 1),
                                                                  ('2025-08-03 14:30:00', 'PENDING', 45.00, 2),
                                                                  ('2025-08-05 09:45:00', 'COMPLETED', 1499.00, 1);

-- Order Items
INSERT INTO order_items (quantity, price, product_id, order_id) VALUES
                                                                    (1, 699.99, 1, 1), -- Smartphone X100
                                                                    (1, 199.99, 2, 1), -- Wireless Headphones
                                                                    (1, 45.00, 7, 2),  -- Women's Summer Dress
                                                                    (1, 1499.00, 3, 3); -- Gaming Laptop Z