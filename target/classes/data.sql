-- Default password: 123456
INSERT INTO users (id, username, password, role) VALUES
(1, 'admin', '$2a$10$6qot.bU3LaogZ/GBmOrMCeEHNg/HT/7KmOB/Y5kd.0nOaO2Bbxm82', 'ROLE_ADMIN'),
(2, 'user',  '$2a$10$6qot.bU3LaogZ/GBmOrMCeEHNg/HT/7KmOB/Y5kd.0nOaO2Bbxm82', 'ROLE_USER');
INSERT INTO products (id, name, description, price) VALUES
(1, 'Laptop', 'A high-performance laptop', 999.99),
(2, 'Smartphone', 'A latest model smartphone', 699.99),
(3, 'Headphones', 'Noise-cancelling headphones', 199.99); 