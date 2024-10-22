package br.com.fiap.mvcagrocaretech.animal;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface AnimalRepository extends JpaRepository<Animal, UUID> {

    public List<Animal> findAll();
    
}