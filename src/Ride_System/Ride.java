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
    String title;
    String description;
    Client client;
    Area src;
    Area dest;
    
    public abstract Ride Notify();
    
    public void setClient(Client client) {
        this.client = client;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDest(Area dest) {
        this.dest = dest;
    }

    public void setSrc(Area src) {
        this.src = src;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Client getClient() {
        return client;
    }

    public Area getSrc() {
        return src;
    }

    public String getDescription() {
        return description;
    }

    public Area getDest() {
        return dest;
    }

    public String getTitle() {
        return title;
    }
    
    

}
