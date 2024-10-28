package br.com.fiap.mvcagrocaretech.chat;

import br.com.fiap.mvcagrocaretech.user.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ChatController {

    private final ChatService chatService;
    private final List<Message> messages = new ArrayList<>();

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String chatPage(Model model) {
        messages.clear();
        model.addAttribute("messages", messages);
        return "chat";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String userMessage, Model model) {
        messages.add(new Message(userMessage, "Você", Instant.now(), "https://img.icons8.com/?size=100&id=jNNpHMEKIOv5&format=png&color=000000")); // Adiciona a mensagem do usuário
        String chatResponse = chatService.sentToAi(userMessage);
        messages.add(new Message(chatResponse, "Sr. Pigson", Instant.now(), "https://avatar.iran.liara.run/public/job/farmer/male")); // Adiciona a resposta da IA

        model.addAttribute("messages", messages);
        return "chat";
    }



}
