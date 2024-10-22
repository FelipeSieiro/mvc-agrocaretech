package br.com.fiap.mvcagrocaretech.animal;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnimalController {
    private final AnimalService animalService;
    private final RabbitTemplate rabbitTemplate;

    public AnimalController(AnimalService animalService, RabbitTemplate rabbitTemplate) {
        this.animalService = animalService;
        this.rabbitTemplate = rabbitTemplate;
    }

    @GetMapping("/animais")
    public String index(Model model){
        var animals = animalService.findAll();

        model.addAttribute("animals", animals);
        return "animais";
    }
}
