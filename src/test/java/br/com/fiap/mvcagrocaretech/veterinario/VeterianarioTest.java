package br.com.fiap.mvcagrocaretech.veterinario;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VeterinarioTest {

    private Veterinario veterinario;

    @BeforeEach
    void setUp() {
        veterinario = new Veterinario();
    }

    @Test
    void testGetNome() {
        assertEquals("Dr. João", veterinario.getName());
    }

    @Test
    void testGetEmail() {
        assertEquals("joao@example.com", veterinario.getEmail());
    }

}
