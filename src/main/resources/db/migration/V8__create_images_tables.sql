CREATE TABLE feedback_images (
                                 feedback_id BIGINT,
                                 image_url TEXT NOT NULL,
                                 FOREIGN KEY (feedback_id) REFERENCES feedbacks(id) ON DELETE CASCADE
);

CREATE TABLE house_images (
                              house_id BIGINT,
                              image_url TEXT NOT NULL,
                              FOREIGN KEY (house_id) REFERENCES houses(id) ON DELETE CASCADE
);
