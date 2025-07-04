DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS reviews;

-- Create the product table
CREATE TABLE products (
                         id UUID PRIMARY KEY,
                         product_id VARCHAR(50),
                         name VARCHAR(100),
                         description TEXT,
                         price DOUBLE PRECISION,
                         currency VARCHAR(1),
                         UNIQUE (product_id)
);

CREATE INDEX idx_productId ON products (product_id);

CREATE TABLE reviews (
                         id UUID PRIMARY KEY,
                         product_id VARCHAR(50),
                         review VARCHAR(200),
                         FOREIGN KEY (product_id) REFERENCES products(product_id)
);

-- Insert initial data into the product table
INSERT INTO products (id, product_id, name, description, price, currency) VALUES
                                                       ('550e8400-e29b-41d4-a716-446655440001', 'camiseta-1234', 'Camiseta Blanca', 'Description 1', 10.0, '€'),
                                                       ('550e8400-e29b-41d4-a716-446655440002', 'pantalon-111', 'Pantalón negro', 'Description 2', 20.0, '$');