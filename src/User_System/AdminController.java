/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class AdminController {
    
     public boolean login(Admin admin) {
       return admin.validate();
    }
      public void logout() {
        System.exit(0);
    } 
    public boolean Signup(Admin admin) {
      Register adminreg=new AdminRegister();
      return admin.insert(adminreg);
    }
    
     public void verifyDriver(String name,Admin admin) throws ClassNotFoundException, SQLException
     {  
         admin.verifyDriverDatabase(name);
     }
     
      public ArrayList<Notification> Notifications(Admin admin) throws SQLException {
       return Notification.RetriveNotification("Admin");
    }
    



 public ArrayList<Driver> listPendingReg() throws ClassNotFoundException, SQLException
    {
       return Driver.retrivependingDrivers();
    }
      
     
    
}
