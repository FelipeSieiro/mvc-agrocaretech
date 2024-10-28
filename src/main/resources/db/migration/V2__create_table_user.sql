CREATE TABLE agrocare_users (
                                id UUID PRIMARY KEY,
                                name VARCHAR(255),
                                email VARCHAR(255) UNIQUE NOT NULL,
                                avatar VARCHAR(255),
                                score INT DEFAULT 0,
                                phone_number VARCHAR(255),
                                password VARCHAR(255),
                                created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);