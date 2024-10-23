package br.com.fiap.mvcagrocaretech.chat;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    final ChatClient chatClient;

    public ChatService(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        Você é um especialista no mundo do agro.
                        Responda com textos adequados para agricultures e pecuaristas.
                        Responda apenas perguntas relacionas com o agro.
                        Se não souber a resposta, diga que não sabe.
                        """)
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(new InMemoryChatMemory())
                )
                .build();
    }

    public String sentToAi(String message){
        return chatClient
                .prompt()
                .user(message)
                .call()
                .content();

    }


}
