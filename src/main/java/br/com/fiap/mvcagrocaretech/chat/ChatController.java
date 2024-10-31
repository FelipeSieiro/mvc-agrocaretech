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
import java.util.Locale;

@Controller
public class ChatController {

    private final ChatService chatService;
    private final List<Message> messages = new ArrayList<>();

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public String chatPage(Model model, @AuthenticationPrincipal OAuth2User principal) {
        messages.clear();
        model.addAttribute("messages", messages);
        return "chat";
    }

    @PostMapping("/send")
    public String sendMessage(@RequestParam("message") String userMessage,
                              @RequestParam(name = "lang", defaultValue = "pt") String lang,
                              Model model,
                              @AuthenticationPrincipal OAuth2User principal) {
        var user = (User) principal;
        Locale locale = new Locale(lang);

        messages.add(new Message(userMessage, user.getName(), Instant.now(), user.getAvatar()));

        String chatResponse = chatService.sentToAi(userMessage, locale);

        messages.add(new Message(chatResponse, "Sr. Pigson", Instant.now(), "https://avatar.iran.liara.run/public/job/farmer/male"));

        model.addAttribute("messages", messages);
        model.addAttribute("user", user);
        return "chat";
    }
}
