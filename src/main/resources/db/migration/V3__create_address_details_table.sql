CREATE TABLE IF NOT EXISTS address_details (
    id BIGSERIAL PRIMARY KEY,
    region region NOT NULL,
    city VARCHAR(255) NOT NULL,
    address TEXT NOT NULL
    );

