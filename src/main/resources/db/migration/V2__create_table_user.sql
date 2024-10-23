CREATE TABLE epicuser (
    id UUID PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255) UNIQUE NOT NULL,
    avatar VARCHAR(255),
    score INT DEFAULT 0
);