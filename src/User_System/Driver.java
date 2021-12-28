/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
import Ride_System.Offer;
import Ride_System.ReqRide;
import Ride_System.Ride;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Driver extends Person {
    
    private String NationalID;
    private String DriverLicense ;
    private int state=0;

   
     public Driver(String MoblieNumber, String Email, String Password, String UserName,String NationalID,String DriverLicense) {
        //Calling the super class Consturctor
        super(UserName, Password, MoblieNumber, Email);
        this.NationalID = NationalID;
        this.DriverLicense = DriverLicense;
    }
    public Driver(String UserName,String Password,String MoblieNumber,String NationalID,String DriverLicense) {
         //Calling the super class Consturctor
        super( UserName,Password,MoblieNumber);
          this.NationalID = NationalID;
        this.DriverLicense = DriverLicense;
    }
     public Driver(String UserName,String Password,String MoblieNumber) {
         //Calling the super class Consturctor
        super( UserName,Password,MoblieNumber);
    }

    public void setDriverLicense(String DriverLicense) {
        this.DriverLicense = DriverLicense;
    }

    public void setNationalID(String NationalID) {
        this.NationalID = NationalID;
    }
   
    public String getDriverLicense() {
        return DriverLicense;
    }

    public String getNationalID() {
        return NationalID;
    }
    public void setState(int state) {
        this.state = state;
    }
    public int getstate()
    {
        return state;
    }
   
    public boolean validate(){
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver");
            while(resultset.next())
            {
                String Name=resultset.getString("Name");
                if(Name.equalsIgnoreCase(UserName))
                {
                    String password=resultset.getString("Password");
                    if(password.equals(Password))
                    {
                        boolean state=resultset.getBoolean("state");
                        String Number=resultset.getString("Number");
                        this.setMoblieNumber(Number);
                        String Id=resultset.getString("ID");
                       this.setMoblieNumber(Id);
                        String DL=resultset.getString("driver_license");
                        this.setMoblieNumber(DL);
                        this.setUserName(Name);
                        
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
    
    @Override
    public boolean insert(Register register) {  
        setRegister(register);
        register.Regist(this);
        Notification Notify = new Notification("New Pending Registeration From Driver -->","Admin",this.getUserName());
        Notify.Insert();
        if(state==0)
        {
            return false;
        }
        else
        {
            return true;
        }
    }
    
    
    
    public void InsertFavArea(String area) {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo="Insert Into fav_area values('"+area+"','"+this.getUserName()+"')";
            smt.execute(dbo);
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
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
}