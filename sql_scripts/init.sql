CREATE TABLE partners (
  partner_id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  legal_address VARCHAR(255),
  inn VARCHAR(12) UNIQUE NOT NULL,
  director_name VARCHAR(255),
  contact_phone VARCHAR(15),
  contact_email VARCHAR(255),
  logo VARCHAR(255),
  rating INT CHECK (rating BETWEEN 1 AND 5),
  history TEXT
);

CREATE TABLE employees (
  employee_id SERIAL PRIMARY KEY,
  full_name VARCHAR(255) NOT NULL,
  birth_date DATE,
  passport_data VARCHAR(50),
  bank_details VARCHAR(100),
  family_status VARCHAR(50),
  health_status VARCHAR(50)
);

CREATE TABLE suppliers (
  supplier_id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  inn VARCHAR(12) UNIQUE NOT NULL,
  supply_history TEXT
);

CREATE TABLE materials (
  material_id SERIAL PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  supplier_id INT REFERENCES suppliers(supplier_id) ON DELETE SET NULL,
  unit VARCHAR(50),
  description TEXT,
  image VARCHAR(255),
  price DECIMAL(10, 2),
  quantity_in_stock INT NOT NULL,
  min_quantity INT NOT NULL
);

CREATE TABLE products (
  product_id SERIAL PRIMARY KEY,
  article VARCHAR(50) UNIQUE NOT NULL,
  name VARCHAR(255) NOT NULL,
  description TEXT,
  min_price DECIMAL(10, 2) NOT NULL,
  size_length DECIMAL(10, 2),
  size_width DECIMAL(10, 2),
  size_height DECIMAL(10, 2),
  weight_no_package DECIMAL(10, 2),
  weight_with_package DECIMAL(10, 2),
  quality_certificate VARCHAR(255),
  standard_number VARCHAR(50),
  manufacturing_time INT,
  cost DECIMAL(10, 2) NOT NULL,
  workshop_number INT,
  workers_count INT
);

