CREATE TABLE agrocare_veterinario (
                                      id UUID PRIMARY KEY,
                                      name VARCHAR(255) NOT NULL,
                                      phone_number VARCHAR(15) NOT NULL,
                                      email VARCHAR(255) UNIQUE NOT NULL,
                                      password VARCHAR(255) NOT NULL,
                                      avatar VARCHAR(255),
                                      role VARCHAR(50) NOT NULL,
                                      created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
                                      especializacao_veterinario VARCHAR(255),
                                      cmrv VARCHAR(50)
);

INSERT INTO agrocare_veterinario (id, name, phone_number, email, password, avatar, role, especializacao_veterinario, cmrv) VALUES
    ('33333333-3333-3333-3333-333333333333', 'Dr. João Silva', '11999999999', 'joao.silva@exemplo.com', 'senha123', NULL, 'Veterinário', 'Clínica Geral', 'CRMV1234')