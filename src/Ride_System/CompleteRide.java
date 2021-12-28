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
public class CompleteRide extends Ride{
    int rate;
    Offer Cost;
    Driver driver;
    Ridespec spec;
    CompleteRide(Client client , String src , String Dest ,Driver driver)
    {
        super(client, src, Dest);
        this.driver=driver;
    }
    public void Notifyclient() {
        System.out.println("Ride is Completed");
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
    
    public void etspec(Ridespec spec){
        this.spec=spec;
    }
    public Ridespec getspec()
    {
        return spec;
    }
    public void setroute( String src ,String dest)
    {
        this.src=src;
        this.dest=dest;
    }

}
