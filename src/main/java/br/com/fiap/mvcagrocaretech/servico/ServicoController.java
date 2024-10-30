    package br.com.fiap.mvcagrocaretech.servico;

    import br.com.fiap.mvcagrocaretech.animal.AnimalService;
    import br.com.fiap.mvcagrocaretech.servico.ServicoService;
    import jakarta.validation.Valid;
    import lombok.extern.slf4j.Slf4j;
    import org.springframework.security.core.annotation.AuthenticationPrincipal;
    import org.springframework.security.oauth2.core.user.OAuth2User;
    import org.springframework.stereotype.Controller;
    import org.springframework.ui.Model;
    import org.springframework.web.bind.annotation.GetMapping;
    import org.springframework.web.bind.annotation.RequestMapping;

    @Controller
    @RequestMapping("/servico")
    @Slf4j
    public class ServicoController {

        private final ServicoService servicoService;
        private final AnimalService animalService;

        public ServicoController(ServicoService servicoService, AnimalService animalService) {
            this.servicoService = servicoService;
            this.animalService = animalService;
        }

        @GetMapping
        public String index(Model model) {
            var servicos = servicoService.findAll();
            var animais = animalService.findAll();
            log.info(servicos.toString());
            model.addAttribute("animais", animais);
            model.addAttribute("servicos", servicos);
            return "servico";
        }
    }

