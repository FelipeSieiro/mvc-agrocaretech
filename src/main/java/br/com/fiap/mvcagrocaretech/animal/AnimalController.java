package br.com.fiap.mvcagrocaretech.animal;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/animais")
public class AnimalController {
    private final AnimalService animalService;
    private final RabbitTemplate rabbitTemplate;

    public AnimalController(AnimalService animalService, RabbitTemplate rabbitTemplate) {
        this.animalService = animalService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping
    public String index(Model model) {
        var animals = animalService.findAll();
        model.addAttribute("animals", animals);
        return "animais";
    }
}
