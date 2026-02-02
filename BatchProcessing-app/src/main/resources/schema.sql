CREATE TABLE IF NOT EXISTS products (
    product_id INT PRIMARY KEY,
    title VARCHAR(255),
    description VARCHAR(500),
    price NUMERIC,
    discount VARCHAR(10),
    discounted_price NUMERIC
);