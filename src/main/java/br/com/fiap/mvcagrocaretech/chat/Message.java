package br.com.fiap.mvcagrocaretech.chat;

import lombok.Data;

import java.time.Instant;

@Data
public class Message {
    private String content;
    private String user;
    private Instant timestamp;
    private String avatar;

    public Message(String content, String user, Instant timestamp, String avatar) {
        this.content = content;
        this.user = user;
        this.timestamp = timestamp;
        this.avatar = avatar;
    }
}
