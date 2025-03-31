CREATE TABLE likes (
                       id BIGSERIAL PRIMARY KEY,
                       is_liked BOOLEAN NOT NULL,
                       user_id BIGINT,
                       feedback_id BIGINT,
                       FOREIGN KEY (user_id) REFERENCES users(id) ON DELETE CASCADE,
                       FOREIGN KEY (feedback_id) REFERENCES feedbacks(id) ON DELETE CASCADE
);
