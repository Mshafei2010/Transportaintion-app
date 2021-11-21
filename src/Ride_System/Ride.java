/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ride_System;

import User_System.Client;

/**
 *
 * @author mshaf
 */
public abstract class Ride {
    protected String title;
    protected String description;
    protected Client client;
    protected String src;
    protected String dest;
    
    Ride(Client client , String src ,String dest){
        this.client=client;
        this.dest=dest;
        this.src=src;
    }
    public abstract void Notify();
    
    public void setClient(Client client) {
        this.client = client;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public void setSrc(String src) {
        this.src = src;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Client getClient() {
        return client;
    }

    public String getSrc() {
        return src;
    }

    public String getDescription() {
        return description;
    }

    public String getDest() {
        return dest;
    }

    public String getTitle() {
        return title;
    }
    
    

}
