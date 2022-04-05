package com.example.PIM.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message
{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int messageId;
    public String messageContent;
    public LocalDateTime createdAt;



    @ManyToOne
    @JoinColumn(name = "senderid")
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }



    public Message(){

    }

    public Message(int messageId, String messageContent, LocalDateTime createdAt, User user) {
        this.messageId = messageId;
        this.messageContent = messageContent;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Message(String messageContent, LocalDateTime createdAt, User user) {
        this.messageContent = messageContent;
        this.createdAt = createdAt;
        this.user = user;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageId=" + messageId +
                ", messageContent='" + messageContent + '\'' +
                ", createdAt=" + createdAt +
                ", user=" + user +
                '}';
    }
}
