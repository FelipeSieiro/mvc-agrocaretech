package br.com.fiap.mvcagrocaretech.chat;


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
        // Adiciona as mensagens atuais no modelo para exibição na página
        model.addAttribute("messages", messages);
        return "chat";  // Nome do arquivo Thymeleaf que será renderizado
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String userMessage, Model model) {
        messages.add(new Message(userMessage, "Estudante", 1, Instant.now()));
        String chatResponse = chatService.sentToAi(userMessage);
        messages.add(new Message(chatResponse, "Professor", 2, Instant.now()));

        model.addAttribute("messages", messages);
        return "chat";
    }

    public static class Message {
        private String content;
        private String user;
        private int color;
        private Instant timestamp;

        public Message(String content, String user, int color, Instant timestamp) {
            this.content = content;
            this.user = user;
            this.color = color;
            this.timestamp = timestamp;
        }

        // Getters e Setters
        public String getContent() { return content; }
        public String getUser() { return user; }
        public int getColor() { return color; }
        public Instant getTimestamp() { return timestamp; }
    }
}

