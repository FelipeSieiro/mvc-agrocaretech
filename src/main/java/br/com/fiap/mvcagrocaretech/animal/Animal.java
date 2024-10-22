package br.com.fiap.mvcagrocaretech.animal;




import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@Table(name = "agrocare_animals")
public class Animal {

        @Id
        UUID id = UUID.randomUUID();
        private String nome;
        private String especie;
        private Integer idade;
        private Double peso;
        private String urlImage;
}

