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
        super(UserName,Password,MoblieNumber);
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
  
}