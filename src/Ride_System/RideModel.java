/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ride_System;

import NotificationCenter.Notification;
import User_System.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.awt.image.OffScreenImage;
/**
 *
 * @author mshaf
 */
public class RideModel{
   
   
    public ArrayList<Offer>RetriveOffers(String ClientName)
    {
        ArrayList<Offer>offers=new ArrayList<>();
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From Offers");
            while(resultset.next())
            {
                String Uname=resultset.getString("CName");
                if(Uname.equalsIgnoreCase(ClientName)) {
                    
                    int price=resultset.getInt("price");
                    String DName=resultset.getString("DName");
                    Offer offer= new Offer(price, DName, ClientName);
                    offers.add(offer);
                                       
                    
                }
            }
            con.close();
            return offers;
        } catch (SQLException ex) {
            Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
     public boolean Insert(Ride ride) {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            
            Statement smt=con.createStatement();
            String dbo="Insert Into Ride (src,dest,CName)values('"+ride.getSrc()+"','"+ride.getDest()+"','"+ride.getClientName()+"')";
            smt.execute(dbo);
            smt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
    }
     
     
    public void notifydriverofarea(String src)
    {
        ArrayList<Driver>Drivers=new ArrayList<Driver>();
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver,fav_area,Ride,client where  clientName=CName and driver.Name=fav_area.Dname and fav_area.Area=Ride.src and Fav_area.Area='"+src+"'");
             while(resultset.next())
            {
                 String Name=resultset.getString("Name");
                 String Number=resultset.getString("Number");
                 String email="";
                 Driver d=new Driver(Name,Number,email);
                 Drivers.add(d);            
            }
             con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Ride.class.getName()).log(Level.SEVERE, null, ex);
        }
        for(int i=0;i<Drivers.size();i++)
        {
            Notification notification=new Notification("New Request added from your favourite Areas", "Driver", Drivers.get(i).getUserName());
            notification.Insert();
        }
        
    }

    
    
    
    public void addnewOffer(Offer offer)
    {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            String dbo="Insert Into Offers (CName,price,DriverName)values('"+offer.getClient()+"','"+offer.getprice()+"','"+offer.getDriver()+"')";
            smt.execute(dbo);
            smt.close();
            con.close();
            Notifyclient(offer.getClient());
        } catch (SQLException ex) {
            Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void Notifyclient(String ClientName)
    {
        Notification notification =new Notification("New Offer Added To your Requested Ride ","Client",ClientName);
        notification.Insert();
    }
    
    public  Ride pickOffer(Offer offers) {
        
       System.out.println("Not supported yet");
        return null;
    }


    public ArrayList<Offer> getOffers() {/*
        return offers;
*/
         return null;
    }
    public static Ride getCleintride(String Name)
    {
        
         try {
             Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
             Statement smt=con.createStatement();
             ResultSet resultset=smt.executeQuery("SELECT * From Ride,driver");
               String src;
               String dest;
               String Uname;
             while(resultset.next())
             {
                 Uname=resultset.getString("CName");
                if(Uname.equalsIgnoreCase(Name)) {
                 
                 src=resultset.getString("src");
                 dest=resultset.getString("dest");
                 Ride ride=new Ride(Uname,src,dest);
                 con.close();
                 return ride;
                 
                }
             }
         } catch (SQLException ex) {
             Logger.getLogger(RideModel.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }
   
     public static ArrayList<Ride> retriveDriverfavRides(Driver driver)
     {
               ArrayList<Ride> rides=new ArrayList<Ride>();
        try {
           
            
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver,fav_area,Ride,client where clientName=CName and driver.Name=fav_area.Dname and Area=src and driver.Name='"+driver.getUserName()+"'");
            while(resultset.next())
            {
                String src=resultset.getString("src");
    
                String dest=resultset.getString("dest");
               String Uname=resultset.getString("clientName");
                String pass=resultset.getString("CPassword");
                String Number=resultset.getString("CNumber");

                Client c=new Client(Uname, pass, Number);
                Ride r=new Ride(c.getUserName(), src, dest);
                rides.add(r);
                
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rides;
     }

 
   
}
