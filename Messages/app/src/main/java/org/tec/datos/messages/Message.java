package org.tec.datos.messages;


import java.io.Serializable;

public class Message implements Serializable{

    private User sender;
    private User receiver;
    private String text;
    private String attached;

    public Message(String text){
        this.text=text;
        
    }
    public Message(User sender, User receiver, String attached, String text){
        this.sender=sender;
        this.receiver=receiver;
        this.attached=attached;
        this.text=text;
    }

    public String getText() {
        return this.text;
    }

    public User getReceiver() {
        return this.receiver;
    }
}
