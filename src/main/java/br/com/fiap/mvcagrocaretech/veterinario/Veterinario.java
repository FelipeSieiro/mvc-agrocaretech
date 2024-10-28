package br.com.fiap.mvcagrocaretech.veterinario;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table(name = "agrocare_veterinario")
public class Veterinario{

    @Id
    UUID id = UUID.randomUUID();
    String name;
    String phoneNumber;
    String email;
    String password;
    String avatar;
    String role;
    LocalDateTime createdAt;
    LocalDateTime updatedAt;
    String especializacaoVeterinario;
    String cmrv;
        
}
