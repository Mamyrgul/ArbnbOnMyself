CREATE TABLE IF NOT EXISTS houses (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type house_type NOT NULL,
    price DOUBLE PRECISION NOT NULL,
    description VARCHAR(500),
    state house_state NOT NULL,
    is_blocked BOOLEAN NOT NULL,
    max_guests INT NOT NULL,
    reject_info VARCHAR(400),
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE
    );