/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
import Ride_System.Offer;
import Ride_System.Ride;
import Ride_System.RideController;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Dell
 */
public class DriverController {
  
   Driver driver;
    DriverModel driverModel;
    public DriverController() {
     driverModel =new DriverModel();
    }

    public boolean login(Driver driver){
       return driverModel.validate(driver);
    }
      public void logout() {
            System.exit(0);
        }
            
    public boolean SignUp(Driver driver) throws SQLException {
        
   
      return driverModel.insert(driver);
      
    }
   
    public void AddFavArea(String Area,Driver driver) {
        driverModel.InsertFavArea(driver,Area);
        
    }
    
    public List<Ride> listreqrides(Driver driver) {
       RideController ridecontoroller=new RideController();
       return ridecontoroller.getmyRides(driver);
        
    }
    public ArrayList<Notification> Notifications(Driver driver) throws SQLException {
       return Notification.Retrive(driver,"Driver");
    }
    
    
    public void addOffer(Ride ride,int price,String Dname) {
        Offer offer;
       offer = new Offer(price, Dname, ride.getClientName());
       RideController ridecontroller =new RideController();
       ridecontroller.AddOffer(offer);
    }

    
    
}
