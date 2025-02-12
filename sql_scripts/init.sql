CREATE TABLE partners (
  partner_id SERIAL PRIMARY KEY,
  partner_type VARCHAR(50),
  partner_name VARCHAR(100),
  director VARCHAR(100),
  email VARCHAR(100),
  phone VARCHAR(20),
  legal_address VARCHAR(200),
  inn VARCHAR(12),
  rating INT
);

CREATE TABLE material_type (
  type VARCHAR(50),
  defect_percentage DECIMAL(10, 6)
);

CREATE TABLE partner_products (
  product_name VARCHAR(100),
  partner_name VARCHAR(100),
  quantity INT,
  sale_date TIMESTAMP
);

CREATE TABLE products (
  product_type VARCHAR(50),
  product_name VARCHAR(100),
  article INT,
  min_cost DECIMAL(10, 2)
);

CREATE TABLE product_type (
  type VARCHAR(50),
  coefficient DECIMAL(10, 2)
);


-- Команды импорта, их нужно вводить в консоль psql (или psql tool прямо в pgAdmin)
\COPY partners (partner_type, partner_name, director, email, phone, legal_address, inn, rating) FROM '/home/goga_rid/ГИА/2025gia/Ресурсы/Partners_import.csv' DELIMITER ',' CSV HEADER;
\COPY product_type (type, coefficient) FROM '/home/goga_rid/ГИА/2025gia/Ресурсы/Product_type_import.csv' DELIMITER ';' CSV HEADER;
\COPY products (product_type, product_name, article, min_cost) FROM '/home/goga_rid/ГИА/2025gia/Ресурсы/Products_import.csv' DELIMITER ',' CSV HEADER;
\COPY partner_products (product_name, partner_name, quantity, sale_date) FROM '/home/goga_rid/ГИА/2025gia/Ресурсы/Partner_products_import.csv' DELIMITER ',' CSV HEADER;
\COPY material_type (type, defect_percentage) FROM '/home/goga_rid/ГИА/2025gia/Ресурсы/Material_type_import.csv' DELIMITER ',' CSV HEADER;

ALTER TABLE partners
    ADD COLUMN total_sales INT DEFAULT 0,  -- Поле для общего количества продаж
    ADD COLUMN discount INT DEFAULT 0;      -- Поле для размера скидки



