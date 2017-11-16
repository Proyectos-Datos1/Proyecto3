package org.tec.datos.msgview.Message;

import org.tec.datos.msgview.User;



public class Message {

    private User sender;
    private User receiver;
    private String text;
    private String attached;

    public Message(User sender,User receiver,String attached,String text){
        this.sender=sender;
        this.receiver=receiver;
        this.attached=attached;
        this.text=text;
    }
}
