package br.com.fiap.mvcagrocaretech.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;





import java.time.Instant;
import java.time.ZoneId;

@Service
public class ChatService {

    final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        Não escreva em formato Markdown.
                        Você é um especialista no mundo do agro.
                        Seu nome é  Sr. Pigson.
                        Responda com textos adequados para agricultures e pecuaristas.
                        Responda apenas perguntas relacionadas ao agro.
                        Não escreva por tópicos, e faça a indentação respeitando as regras da língua portuguesa.
                        Se não souber a resposta, diga que não sabe.
                        """)
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(new InMemoryChatMemory())
                )
                .build();
    }

    public String sentToAi(String message) {
        int hour = Instant.now().atZone(ZoneId.systemDefault()).getHour();
        String greeting;

        if (hour >= 5 && hour < 12) {
            greeting = "Bom dia!";
        } else if (hour >= 12 && hour < 18) {
            greeting = "Boa tarde!";
        } else {
            greeting = "Boa noite!";
        }

        String fullMessage = String.format("%s %s", greeting, message);

        return chatClient
                .prompt()
                .user(fullMessage)
                .call()
                .content();
    }
}
