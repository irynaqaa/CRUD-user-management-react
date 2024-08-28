CREATE TABLE IF NOT EXISTS migrations (id INT PRIMARY KEY, name VARCHAR(255));
INSERT INTO migrations (id, name) VALUES (1, 'Initial migration');
ALTER TABLE migrations ADD COLUMN description VARCHAR(255);