```
CREATE TABLE IF NOT EXISTS migrations (
  id INT PRIMARY KEY,
  script VARCHAR(255) NOT NULL
);

INSERT INTO migrations (id, script) VALUES (1, 'initial migration');

ALTER TABLE schema ADD COLUMN new_column VARCHAR(255);
```