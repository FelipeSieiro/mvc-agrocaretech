package br.com.fiap.mvcagrocaretech.chat;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.ZoneId;
import java.util.Locale;

@Service
public class ChatService {

    private final ChatClient chatClient;
    private final MessageSource messageSource;

    @Autowired
    public ChatService(ChatClient.Builder chatClientBuilder, MessageSource messageSource) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        Não escreva em formato Markdown.
                        Você é um especialista no mundo do agro.
                        Seu nome é Sr. Pigson.
                        Responda com textos adequados para agricultores e pecuaristas.
                        Responda apenas perguntas relacionadas ao agro.
                        Se não souber a resposta, diga que não sabe.
                        """)
                .defaultAdvisors(new MessageChatMemoryAdvisor(new InMemoryChatMemory()))
                .build();
        this.messageSource = messageSource;
    }

    public String sentToAi(String message, Locale locale) {
        int hour = Instant.now().atZone(ZoneId.systemDefault()).getHour();
        String greetingKey;

        if (hour >= 5 && hour < 12) {
            greetingKey = "greeting_morning";
        } else if (hour >= 12 && hour < 18) {
            greetingKey = "greeting_afternoon";
        } else {
            greetingKey = "greeting_evening";
        }

        String greeting = messageSource.getMessage(greetingKey, null, locale);
        String fullMessage = String.format("%s %s", greeting, message);

        return chatClient
                .prompt()
                .user(fullMessage)
                .call()
                .content();
    }
}
