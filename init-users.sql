DELETE FROM users;
INSERT INTO users (username, password, role) VALUES
('admin', '$2a$10$rS5cVBqJHxM5p7xKQ9mXqu8YZMfnT8TJYt0J.eU5K7pVyfqpC8v8O', 'ROLE_ADMIN'),
('user', '$2a$10$rS5cVBqJHxM5p7xKQ9mXqu8YZMfnT8TJYt0J.eU5K7pVyfqpC8v8O', 'ROLE_USER');
