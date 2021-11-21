/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ride_System;

import User_System.Client;
import User_System.Driver;
import Ride_System.Offer;
/**
 *
 * @author mshaf
 */
public class ReqRide extends Ride{
    Offer[] offers;
    Driver[] drivers;
    int numofoffers;
    ReqRide(Client client ,Area src ,Area Dest){
        
    }
    
    public void addnewOffer(Offer offer,Driver driver)
    {
        
    }
    Offer [] getOfferDetails(){
        return offers;
    }




    public Ride Notify()
    {
        System.out.println("Ride is requested");
        return this;
    }

    public void setOffers(Offer[] offers) {
        this.offers = offers;
    }

    public void setDrivers(Driver[] drivers) {
        this.drivers = drivers;
    }

    public void setNumofoffers(int numofoffers) {
        this.numofoffers = numofoffers;
    }

    public Driver[] getDrivers() {
        return drivers;
    }

    public int getNumofoffers() {
        return numofoffers;
    }

    public Offer[] getOffers() {
        return offers;
    }
    
    
}
