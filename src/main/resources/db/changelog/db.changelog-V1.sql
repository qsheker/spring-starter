--liquibase formatted sql

--changeset qsheker:1
CREATE TABLE users (
                       id BIGSERIAL PRIMARY KEY,
                       name VARCHAR(100) NOT NULL,
                       email VARCHAR(150) UNIQUE NOT NULL,
                       password VARCHAR(255) NOT NULL,
                       role VARCHAR(50) NOT NULL
);

--changeset qsheker:2
CREATE TABLE categories (
                            id BIGSERIAL PRIMARY KEY,
                            name VARCHAR(100) NOT NULL
);

--changeset qsheker:3
CREATE TABLE products (
                          id BIGSERIAL PRIMARY KEY,
                          name VARCHAR(150) NOT NULL,
                          description TEXT,
                          price DECIMAL(10,2) NOT NULL,
                          stock INT NOT NULL,
                          category_id BIGINT REFERENCES categories(id) ON DELETE SET NULL
);

--changeset qsheker:4
CREATE TABLE orders (
                        id BIGSERIAL PRIMARY KEY,
                        order_date TIMESTAMP NOT NULL,
                        status VARCHAR(50) NOT NULL,
                        total_price DECIMAL(10,2) NOT NULL,
                        user_id BIGINT REFERENCES users(id) ON DELETE CASCADE
);

--changeset qsheker:5
CREATE TABLE order_items (
                             id BIGSERIAL PRIMARY KEY,
                             quantity INT NOT NULL,
                             price DECIMAL(10,2) NOT NULL,
                             product_id BIGINT REFERENCES products(id) ON DELETE CASCADE,
                             order_id BIGINT REFERENCES orders(id) ON DELETE CASCADE
);
