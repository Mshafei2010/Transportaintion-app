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
    Offer[] offers;
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
    }
    
    
    public void addnewOffer(int price ,Driver driver)
    {
        offers[indexOfOffer]=new Offer(price ,driver);
        indexOfOffer++;
        Notify();
    }

    public void Notify()
    {
        client.update();
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
