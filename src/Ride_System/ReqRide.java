/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ride_System;

import User_System.*;
/**
 *
 * @author mshaf
 */
public class ReqRide extends Ride{
    Offer[] offers = new Offer[100];
    int indexOfOffer=0;
    String AName;
    
    public void setAName(String name)
    {
        AName =name;
    }
    public String getAName()
    {
        return AName;
    }
    public ReqRide(Client client, String src, String dest) {
        super(client, src, dest);
        Notifyofarea();
    }
    
    
    public void addnewOffer(int price ,Driver driver)
    {
        Offer off = new Offer(price ,driver); 
        offers[indexOfOffer]= off ;
        indexOfOffer++;
        Notify();
    }

    public void Notify()
    {
        client.update();
    }
    public void Notifyofarea()
    {
        System.out.println("Driver ->New Request added please list all requests to get your favourite");
        
    }

    public  CompleteRide pickOffer(Offer offers) {
        
       System.out.println("Not supported yet");
        return null;
    }


    public Offer[] getOffers() {
        return offers;
    }
    public ReqRide getride()
    {
        return this;
    }
   
    
    
}
