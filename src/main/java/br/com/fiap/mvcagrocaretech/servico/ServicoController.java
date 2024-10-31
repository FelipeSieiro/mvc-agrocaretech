package br.com.fiap.mvcagrocaretech.servico;

import br.com.fiap.mvcagrocaretech.animal.AnimalService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
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
    private final RabbitTemplate rabbitTemplate;

    public ServicoController(ServicoService servicoService, AnimalService animalService, RabbitTemplate rabbitTemplate) {
        this.servicoService = servicoService;
        this.animalService = animalService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public String index(Model model) {
        var servicos = servicoService.findAll();
        var animais = animalService.findAll();

        rabbitTemplate.convertAndSend("servico-queue", "Serviços e animais consultados");

        model.addAttribute("animais", animais);
        model.addAttribute("servicos", servicos);

        return "servico";
    }
}
