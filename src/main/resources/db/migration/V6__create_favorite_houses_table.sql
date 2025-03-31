CREATE TABLE favorite_houses (
                                 id BIGSERIAL PRIMARY KEY,
                                 house_id BIGINT NOT NULL,
                                 added_at DATE NOT NULL,
                                 user_id BIGINT,
                                 FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE
);
