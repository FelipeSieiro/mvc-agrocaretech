INSERT INTO agrocare_animals (id, nome, especie, idade, peso, url_image) VALUES
    (gen_random_uuid(), 'Bovino 1', 'Bovino', 5, 600.5, 'url_bovino1.jpg');

INSERT INTO agrocare_veterinario (id, name, phone_number, email, password, avatar, role, especializacao_veterinario, cmrv) VALUES
    (gen_random_uuid(), 'Dr. João Silva', '11999999999', 'joao.silva@exemplo.com', 'senha123', NULL, 'Veterinário', 'Clínica Geral', 'CRMV1234');


INSERT INTO agrocare_servico (data_servico, preco_servico, diagnostico, animal_id, veterinario_id) VALUES
('2024-10-01', 150.00, 'Consulta inicial',
 (SELECT id FROM agrocare_animals WHERE nome = 'Bovino 1'),
 (SELECT id FROM agrocare_veterinario WHERE email = 'joao.silva@exemplo.com'));
