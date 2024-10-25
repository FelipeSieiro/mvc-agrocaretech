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
    private final List<Message> messages = new ArrayList<>(); // Lista de mensagens

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String chatPage(Model model) {
        model.addAttribute("messages", messages); // Adiciona as mensagens ao modelo
        return "chat";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String userMessage, Model model) {
        messages.add(new Message(userMessage, "Você", Instant.now())); // Adiciona a mensagem do usuário
        String chatResponse = chatService.sentToAi(userMessage); // Obtém resposta da IA
        messages.add(new Message(chatResponse, "Sr. Pigson", Instant.now())); // Adiciona a resposta da IA

        model.addAttribute("messages", messages); // Atualiza o modelo com as mensagens
        return "chat"; // Retorna a página de chat
    }

    @PostMapping("/clear")
    public String clearChat() {
        messages.clear(); // Limpa a lista de mensagens
        return "redirect:/chat"; // Redireciona para a página de chat
    }

    public static class Message {
        private String content;
        private String user;
        private Instant timestamp;

        public Message(String content, String user, Instant timestamp) {
            this.content = content;
            this.user = user;
            this.timestamp = timestamp;
        }

        // Getters
        public String getContent() { return content; }
        public String getUser() { return user; }
        public Instant getTimestamp() { return timestamp; }
    }
}
