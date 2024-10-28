package br.com.fiap.mvcagrocaretech.veterinario;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import jakarta.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("veterinario")
@Slf4j
public class VeterinarioController {

    @Autowired
    private VeterinarioRepository repository;

    @GetMapping
    public String findAll(Model model) {
        List<Veterinario> veterinarios = repository.findAll();
        model.addAttribute("veterinarios", veterinarios);
        model.addAttribute("veterinario", new Veterinario()); // Para o formulário
        return "veterinario/list"; // Nome da view para listar veterinários
    }

    @PostMapping
    public String create(@Valid @ModelAttribute("veterinario") Veterinario veterinario,
                         BindingResult result, RedirectAttributes redirect) {
        if (result.hasErrors()) {
            return "veterinario/list"; // Retorna para a lista se houver erro
        }
        // Setando data de criação e atualização
        veterinario.setCreatedAt(LocalDateTime.now());
        veterinario.setUpdatedAt(LocalDateTime.now());

        log.info("Cadastrando veterinário {}", veterinario);
        repository.save(veterinario);
        redirect.addFlashAttribute("message", "Veterinário cadastrado com sucesso!");
        return "redirect:/veterinario";
    }

    @PostMapping("{id}")
    public String delete(@PathVariable UUID id, RedirectAttributes redirect) {
        log.info("Excluindo veterinário com id {}", id);
        repository.deleteById(id);
        redirect.addFlashAttribute("message", "Veterinário excluído com sucesso!");
        return "redirect:/veterinario";
    }

}
