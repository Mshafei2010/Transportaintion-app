/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ride_System;

import User_System.*;
import java.util.ArrayList;

/**
 *
 * @author mshaf
 */
public class RideController{
   Ride ride;
    RideModel ridemodel;
    public RideController() {
        ridemodel=new RideModel();
    }
    
    public void RequestnewRide(Ride ride)
    {
        ridemodel.Insert(ride);
        ridemodel.notifydriverofarea(ride.getSrc());
        
    }
    public ArrayList<Offer>getmyOffers(String ClientName){
        ArrayList<Offer>offers=ridemodel.RetriveOffers(ClientName);
        return  offers;
    }
     public ArrayList<Ride>getmyRides(Driver driver){
        ArrayList<Ride>rides=ridemodel.retriveDriverfavRides(driver);
        return  rides;
    }
     public void AddOffer(Offer offer)
     {
         ridemodel.addnewOffer(offer);
     }
    
    
    
    
   

}
