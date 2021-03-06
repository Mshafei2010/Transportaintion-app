/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
import NotificationCenter.NotificationModel;
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
     //done
    public boolean login(Driver driver){
       return driverModel.validate(driver);
    }
    //done
      public void logout() {
            System.exit(0);
        }
       //done     
    public boolean SignUp(Driver driver) throws SQLException {
        
   
      return driverModel.insert(driver);
      
    }
   //done
    public void AddFavArea(String Area,Driver driver) {
        driverModel.InsertFavArea(driver,Area);
        
    }
    //done
    public List<Ride> listreqrides(Driver driver) {
       RideController ridecontoroller=new RideController();
       return ridecontoroller.getmyRides(driver);
        
    }
    
   //done
    public ArrayList<Notification> Notifications(Driver driver) throws SQLException {
       return NotificationModel.Retrive(driver,"Driver");
    }
    
    //done
    public void addOffer(Ride ride,int price,String Dname) {
        Offer offer;
       offer = new Offer(price, Dname, ride.getClientName());
       RideController ridecontroller =new RideController();
       ridecontroller.AddOffer(offer);
    }
    //done
    public void StartRide(String Name){
          RideController ridecontroller =new RideController();
       ridecontroller.RideBegin(Name);
    }
    //To end the ride we need to call the controller to end it
    //then we need to call the driver model to update the driver balance
     public void EndRide(String Name){
       RideController ridecontroller =new RideController();
       ridecontroller.RideEnd(Name);
       driverModel.updateBalance(Name);
    }
       public int getMybalance(Driver driver) {
        return driverModel.retrivebalance(driver);
        
    }
    

    
    
}
