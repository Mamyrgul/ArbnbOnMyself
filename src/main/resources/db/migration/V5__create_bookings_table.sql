CREATE TABLE bookings (
                          id BIGSERIAL PRIMARY KEY,
                          checkin DATE NOT NULL,
                          checkout DATE NOT NULL,
                          user_id BIGINT,
                          house_id BIGINT,
                          FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                          FOREIGN KEY (house_id) REFERENCES houses(id) ON DELETE CASCADE
);
