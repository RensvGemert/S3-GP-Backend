package com.example.PIM.model;

import javax.persistence.*;

@Entity
public class MessageRecipient {
    @EmbeddedId
    public MessageRecipientKey  id;

    @ManyToOne
    @MapsId("userid")
    @JoinColumn(name = "userid")
    public User user;

    @ManyToOne
    @MapsId("messageid")
    @JoinColumn(name = "messageid")
    public Message message;

    public MessageRecipient(MessageRecipientKey id, User user, Message message) {
        this.id = id;
        this.user = user;
        this.message = message;
    }

    public MessageRecipient(User user, Message message) {
        this.user = user;
        this.message = message;
    }

    public MessageRecipient(){

    }

    public MessageRecipientKey getId() {
        return id;
    }

    public void setId(MessageRecipientKey id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageRecipient{" +
                "id=" + id +
                ", user=" + user +
                ", message=" + message +
                '}';
    }
}
