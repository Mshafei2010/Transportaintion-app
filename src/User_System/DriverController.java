/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
import Ride_System.ReqRide;
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
            
    public boolean SignUp(Driver driver) {
        
      Register register=new DriverRegister();
      return driverModel.insert(driver,register);
      
    }
   
    public void AddFavArea(String Area,Driver driver) {
        driverModel.InsertFavArea(driver,Area);
        
    }
    
    public List<ReqRide> listreqrides(Driver driver) {
         ArrayList<ReqRide> rides=new ArrayList<ReqRide>();
        return rides=ReqRide.retriveRides(driver);
    }
    public ArrayList<Notification> Notifications(Driver driver) throws SQLException {
       return Notification.Retrive(driver,"Driver");
    }
    
    
    public void addOffer(ReqRide ride, int price,Driver driver) {
       ride.addnewOffer(price, driver);
    }

    
    
}
