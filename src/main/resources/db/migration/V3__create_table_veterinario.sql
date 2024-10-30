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