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
public class CompleteRide {
    int rate;
    Offer Cost;
    Driver driver;
    //rRidespec spec;
    CompleteRide(Client client , Area src , Area Dest ,Driver driver)
    {
        
    }
    public void setRate(int rate) {
        this.rate = rate;
    }

    public void setCost(Offer Cost) {
        this.Cost = Cost;
    }
    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public int getRate() {
        return rate;
    }

    public Driver getDriver() {
        return driver;
    }

    public Offer getCost() {
        return Cost;
    }
    
    //setspec(spec:Ridespec):void
    //getspec():Ridespec
    void setroute( Area src ,Area dest)
    {
        
    }
}
