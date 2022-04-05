package com.example.PIM.model;



import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MessageRecipientKey implements Serializable
{
    @Column(name = "userId")
    public int userId;

    @Column(name = "messageId")
    public int messageId;

    public MessageRecipientKey(int userid, int messageid) {
        this.userId = userid;
        this.messageId = messageid;
    }

    public MessageRecipientKey(){

    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getMessageId() {
        return messageId;
    }

    public void setMessageId(int messageId) {
        this.messageId = messageId;
    }

    @Override
    public String toString() {
        return "MessageRecipientKey{" +
                "userId=" + userId +
                ", messageId=" + messageId +
                '}';
    }
}
