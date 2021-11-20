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
public class RequestedRide extends Ride{
    Offer[] offers;
    Driver[] drivers;
    int numofoffers;
    public RequestedRide(Client client, Area src, Area Dest) {
        super(client, src, Dest);
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
