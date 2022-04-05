package com.example.PIM.model;



import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class MessageRecipientKey implements Serializable
{
    @Column(name = "userid")
    public int userid;

    @Column(name = "messageid")
    public int messageid;

    public MessageRecipientKey(int userid, int messageid) {
        this.userid = userid;
        this.messageid = messageid;
    }

    public MessageRecipientKey(){

    }



    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public int getMessageid() {
        return messageid;
    }

    public void setMessageid(int messageid) {
        this.messageid = messageid;
    }
}
