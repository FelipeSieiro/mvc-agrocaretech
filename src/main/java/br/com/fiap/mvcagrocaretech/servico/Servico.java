package br.com.fiap.mvcagrocaretech.servico;



import br.com.fiap.mvcagrocaretech.animal.Animal;
import br.com.fiap.mvcagrocaretech.veterinario.Veterinario;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Entity
@Table(name = "agrocare_servico")
public class Servico {

    @Id
    UUID id = UUID.randomUUID();
    private LocalDate dataServico;
    private BigDecimal precoServico;
    private String diagnostico;

    @ManyToOne
    private Animal animal;

    @ManyToOne
    private Veterinario veterinario;
}
