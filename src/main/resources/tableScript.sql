DROP SCHEMA IF EXISTS rewards_db;

CREATE SCHEMA rewards_db;
USE rewards_db;

CREATE TABLE customer (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   name VARCHAR(100),
   email VARCHAR(100)
);

CREATE TABLE transaction (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   customer_id BIGINT,
   amount DECIMAL(10,2),
   transaction_date DATE,
   FOREIGN KEY (customer_id) REFERENCES customer(id)
);

CREATE TABLE reward (
   id BIGINT PRIMARY KEY AUTO_INCREMENT,
   customer_id BIGINT,
   month VARCHAR(7),
   points INT,
   FOREIGN KEY (customer_id) REFERENCES customer(id)
);

-- Insert sample customers
INSERT INTO customer (id, name, email) VALUES (1, 'Alice Smith', 'alice@example.com');
INSERT INTO customer (id, name, email) VALUES (2, 'Bob Johnson', 'bob@example.com');
INSERT INTO customer (id, name, email) VALUES (3, 'Charlie Brown', 'charlie@example.com');

-- Insert sample transactions for different months
INSERT INTO transaction (id, customer_id, amount, transaction_date) VALUES (1, 1, 120.00, '2025-07-15');
INSERT INTO transaction (id, customer_id, amount, transaction_date) VALUES (2, 1, 75.00, '2025-08-10');
INSERT INTO transaction (id, customer_id, amount, transaction_date) VALUES (3, 1, 200.00, '2025-09-05');

-- Insert sample rewards based on transactions
INSERT INTO reward (id, customer_id, month, points) VALUES (1, 1, '2025-07', 90);
INSERT INTO reward (id, customer_id, month, points) VALUES (2, 1, '2025-08', 25);
INSERT INTO reward (id, customer_id, month, points) VALUES (3, 1, '2025-09', 250);

select * from customer;
select * from transaction;
select * from reward;
