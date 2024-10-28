CREATE TABLE agrocare_animals (
    id UUID PRIMARY KEY,
    nome VARCHAR(255),
    especie VARCHAR(255),
    idade INTEGER,
    peso DOUBLE PRECISION,
    url_image VARCHAR(255)
);


INSERT INTO agrocare_animals (id, nome, especie, idade, peso, url_image) VALUES
    ('22222222-2222-2222-2222-222222222222', 'Bovino 1', 'Bovino', 5, 600.5, 'url_bovino1.jpg')