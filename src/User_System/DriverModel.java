/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
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
public class DriverModel {
 
     
    public boolean validate(Driver driver){
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver");
            while(resultset.next())
            {
                String Name=resultset.getString("Name");
                if(Name.equalsIgnoreCase(driver.getUserName()))
                {
                    String password=resultset.getString("Password");
                    if(password.equals(driver.getPassword()))
                    {
                        boolean state=resultset.getBoolean("state");
                        String Number=resultset.getString("Number");
                        driver.setMoblieNumber(Number);
                        String Id=resultset.getString("ID");
                       driver.setMoblieNumber(Id);
                        String DL=resultset.getString("driver_license");
                        driver.setMoblieNumber(DL);
                        driver.setUserName(Name);
                        
                        con.close();
                        return state;
                    }
                }
                con.close();
            }
             return false;
        }  catch (SQLException ex) {
            
               return false;
        }
    }
       public static ArrayList<Driver> retrivependingDrivers(){
         ArrayList<Driver> pendingdrivers=new ArrayList<Driver>();
        try {
       

           Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver");
            while(resultset.next())
            {
                boolean state =resultset.getBoolean("state");
                if(state==false)
                {
                    String Name=resultset.getString("Name");
                    String NationalID=resultset.getString("ID");
                    String DL=resultset.getString("driver_license");
                     String phone=resultset.getString("Name");
                    String Number=resultset.getString("Number");
                     String password=resultset.getString("Password");
                    Driver d=new Driver(Name, password, Number, NationalID, DL);
                    pendingdrivers.add(d);
                    
                }
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pendingdrivers;    
}
       
    
    public void InsertFavArea(Driver driver,String area) {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo="Insert Into fav_area values('"+area+"','"+driver.getUserName()+"')";
            smt.execute(dbo);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
      public boolean insert(Driver driver,Register register) {  
        driver.setRegister(register);
        register.Regist(driver);
        Notification Notify = new Notification("New Pending Registeration From Driver -->","Admin",driver.getUserName());
        Notify.Insert();
        if(driver.getstate()==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

}
