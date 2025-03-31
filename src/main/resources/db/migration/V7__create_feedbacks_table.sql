CREATE TABLE feedbacks (
                           id BIGSERIAL PRIMARY KEY,
                           text TEXT NOT NULL,
                           rating INT CHECK (rating >= 1 AND rating <= 5),
                           created_at DATE NOT NULL,
                           user_id BIGINT,
                           house_id BIGINT,
                           FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                           FOREIGN KEY (house_id) REFERENCES houses(id) ON DELETE CASCADE
);
