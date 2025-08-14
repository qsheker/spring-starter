-- Drop tables if they exist
DROP TABLE IF EXISTS order_items;
DROP TABLE IF EXISTS orders;
DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS categories;
DROP TABLE IF EXISTS users;

-- Users table
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(150) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL
);

-- Categories table
CREATE TABLE categories (
                            id BIGSERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL
);

-- Products table
CREATE TABLE products (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(150) NOT NULL,
                          description TEXT,
                          price DECIMAL(10,2) NOT NULL,
                          stock INT NOT NULL,
                          category_id BIGINT REFERENCES categories(id) ON DELETE SET NULL
);

-- Orders table
CREATE TABLE orders (
                        id BIGSERIAL PRIMARY KEY,
                        order_date TIMESTAMP NOT NULL,
                        status VARCHAR(50) NOT NULL,
                        total_price DECIMAL(10,2) NOT NULL,
                        user_id BIGINT REFERENCES users(id) ON DELETE CASCADE
);

-- Order Items table
CREATE TABLE order_items (
                             id BIGSERIAL PRIMARY KEY,
                             quantity INT NOT NULL,
                             product_id BIGINT REFERENCES products(id) ON DELETE CASCADE,
                             order_id BIGINT REFERENCES orders(id) ON DELETE CASCADE
);
