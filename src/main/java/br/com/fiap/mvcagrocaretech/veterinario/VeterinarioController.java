package br.com.fiap.mvcagrocaretech.veterinario;

import br.com.fiap.mvcagrocaretech.animal.AnimalService;
import br.com.fiap.mvcagrocaretech.servico.ServicoService;
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
@Slf4j
@RequestMapping("/veterinario")
public class VeterinarioController {

    private final VeterinarioService veterinarioService;


    public VeterinarioController(VeterinarioService veterinarioService) {
        this.veterinarioService = veterinarioService;
    }

    @GetMapping
    public String index(Model model) {
        var veterinarios = veterinarioService.findAll();
        model.addAttribute("veterinarios", veterinarios);
        return "veterinario";
    }




}
