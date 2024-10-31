-- Inserindo mais bovinos
INSERT INTO agrocare_animals (id, nome, especie, idade, peso, url_image) VALUES
    (gen_random_uuid(), 'Bovino 2', 'Bovino', 3, 500.0, 'url_bovino2.jpg');

INSERT INTO agrocare_animals (id, nome, especie, idade, peso, url_image) VALUES
    (gen_random_uuid(), 'Bovino 3', 'Bovino', 4, 550.0, 'url_bovino3.jpg');

INSERT INTO agrocare_animals (id, nome, especie, idade, peso, url_image) VALUES
    (gen_random_uuid(), 'Bovino 4', 'Bovino', 2, 480.0, 'url_bovino4.jpg');

INSERT INTO agrocare_animals (id, nome, especie, idade, peso, url_image) VALUES
    (gen_random_uuid(), 'Bovino 5', 'Bovino', 6, 620.0, 'url_bovino5.jpg');

-- Inserindo veterinários para atender os bovinos
INSERT INTO agrocare_veterinario (id, name, phone_number, email, password, avatar, role, especializacao_veterinario, cmrv) VALUES
    (gen_random_uuid(), 'Dra. Ana Costa', '11888888888', 'ana.costa@exemplo.com', 'senha123', 'https://avatar.iran.liara.run/public/job/doctor/female', 'Veterinário', 'Nutrição Animal', 'CRMV5678');

-- Inserindo serviços para os bovinos
INSERT INTO agrocare_servico (data_servico, preco_servico, diagnostico, animal_id, veterinario_id) VALUES
    ('2024-10-10', 200.00, 'Consulta de rotina',
     (SELECT id FROM agrocare_animals WHERE nome = 'Bovino 2'),
     (SELECT id FROM agrocare_veterinario WHERE email = 'joao.silva@exemplo.com'));

INSERT INTO agrocare_servico (data_servico, preco_servico, diagnostico, animal_id, veterinario_id) VALUES
    ('2024-10-15', 250.00, 'Exame de sangue',
     (SELECT id FROM agrocare_animals WHERE nome = 'Bovino 3'),
     (SELECT id FROM agrocare_veterinario WHERE email = 'ana.costa@exemplo.com'));

INSERT INTO agrocare_servico (data_servico, preco_servico, diagnostico, animal_id, veterinario_id) VALUES
    ('2024-10-20', 220.00, 'Vacinação',
     (SELECT id FROM agrocare_animals WHERE nome = 'Bovino 4'),
     (SELECT id FROM agrocare_veterinario WHERE email = 'joao.silva@exemplo.com'));
