CREATE TABLE agrocare_servico (
                                  id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                  data_servico DATE NOT NULL,
                                  preco_servico DECIMAL(10, 2) NOT NULL,
                                  diagnostico VARCHAR(255),


                                  animal_id UUID NOT NULL,
                                  veterinario_id UUID NOT NULL,


                                  CONSTRAINT fk_animal FOREIGN KEY (animal_id) REFERENCES agrocare_animals(id),
                                  CONSTRAINT fk_veterinario FOREIGN KEY (veterinario_id) REFERENCES agrocare_veterinario(id)
);

