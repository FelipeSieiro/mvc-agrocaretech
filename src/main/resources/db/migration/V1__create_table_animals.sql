CREATE TABLE agrocare_animals (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    especie VARCHAR(255),
    idade INTEGER,
    peso DOUBLE PRECISION,
    url_image VARCHAR(255)
);
