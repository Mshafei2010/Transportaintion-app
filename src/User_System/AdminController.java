/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
import NotificationCenter.NotificationModel;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Dell
 */
public class AdminController {
    Admin admin;
   AdminModel adminmodel;
    public AdminController(Admin admin ) {
        this.admin = admin;
        adminmodel =new AdminModel();
    }
    
     public boolean login(Admin admin) {
       return adminmodel.validate(admin);
    }
      public void logout() {
        System.exit(0);
    } 
    public boolean Signup(Admin admin) throws SQLException {
      return adminmodel.insert(admin);
    }
    
     public void verifyDriver(String name,Admin admin) throws ClassNotFoundException, SQLException
     {  
         adminmodel.verifyDriverDatabase(name);
     }
     
      public ArrayList<Notification> Notifications(Admin admin) throws SQLException {
          ArrayList<Notification> notification=NotificationModel.RetriveNotification("Admin");
          
       return notification;
    }




 public ArrayList<Driver> listPendingReg() throws ClassNotFoundException, SQLException
    {
       return DriverModel.retrivependingDrivers();
    }
      
     
    
}
