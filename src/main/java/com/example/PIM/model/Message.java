package com.example.PIM.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "message")
public class Message
{
    @javax.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int messageid;
    public String messagecontent;
    public LocalDateTime createdat;



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

    public Message(int messageid, String messagecontent, LocalDateTime createdat, User user) {

        this.messageid = messageid;
        this.messagecontent = messagecontent;
        this.createdat = createdat;
        this.user = user;
    }

    public Message(String messagecontent, LocalDateTime createdat, User user) {
        this.messagecontent = messagecontent;
        this.createdat = createdat;
        this.user = user;
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }

    public String getMessagecontent() {
        return messagecontent;
    }

    public void setMessagecontent(String messagecontent) {
        this.messagecontent = messagecontent;
    }

    public LocalDateTime getCreatedat() {
        return createdat;
    }

    public void setCreatedat(LocalDateTime createdat) {
        this.createdat = createdat;
    }

    @Override
    public String toString() {
        return "Message{" +
                "messageid=" + messageid +
                ", messagecontent='" + messagecontent + '\'' +
                ", createdat=" + createdat +
                ", user=" + user +
                '}';
    }
}
