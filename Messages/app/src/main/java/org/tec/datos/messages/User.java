package org.tec.datos.messages;

import java.util.concurrent.atomic.AtomicInteger;


public class User {
    private String name, email;
    private int customerID;
    private static AtomicInteger ID_GENERATOR = new AtomicInteger(160);

    public User(String name, String email) {
        this.name=name;
        this.email=email;
        customerID= ID_GENERATOR.getAndIncrement();
    }
    public User(String name){
        this.name=name;
        customerID= ID_GENERATOR.getAndIncrement();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public int getCustomerID() {
        return this.customerID;
    }

    public String toString() {
        return this.customerID + "\t" + this.name + "\t" + this.email;

    }

    public String getName() {
        return this.name;
    }


}
