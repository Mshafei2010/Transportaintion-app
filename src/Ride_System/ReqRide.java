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
/**
 *
 * @author mshaf
 */
public class ReqRide extends Ride{
    ArrayList<Offer> offers;
    String AName;
    
     public boolean Insert(Ride ride) {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            
            Statement smt=con.createStatement();
            String dbo="Insert Into Ride (src,dest,CName)values('"+ride.getSrc()+"','"+ride.getDest()+"','"+ride.getClient().getUserName()+"')";
            smt.execute(dbo);
            smt.close();
            con.close();/*
            Notifyofarea();*/
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
            Notifyofarea(Drivers.get(i));
        }
        
    }

    public void setAName(String name)
    {
        AName =name;
    }
    public String getAName()
    {
        return AName;
    }
    public ReqRide(Client client, String src, String dest) {
        super(client, src, dest);
        offers= new ArrayList<Offer>();
        
    }
    
    
    public void addnewOffer(int price ,Driver driver)
    {
        Offer offer= new Offer(price ,driver,client); 
        offers.add(offer) ;
        Notifyclient();
    }

    public void Notifyclient()
    {
        Notification notification =new Notification("New Offer Added To your Requested Ride ","Client",client.getUserName());
        notification.Insert();
    }
    
    public void Notifyofarea(Driver driver)
    {
        Notification notification =new Notification("New Requested ride Added To your Requested Ride from "+getSrc()+"//dest"+getDest(),"Driver",driver.getUserName());
        notification.Insert();
        
    }
    public  CompleteRide pickOffer(Offer offers) {
        
       System.out.println("Not supported yet");
        return null;
    }


    public ArrayList<Offer> getOffers() {
        return offers;
    }
    public ReqRide getride()
    {
        return this;
    }
   
     public static ArrayList<ReqRide> retriveRides(Driver driver)
     {
               ArrayList<ReqRide> rides=new ArrayList<ReqRide>();
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
                ReqRide r=new ReqRide(c, src, dest);
                rides.add(r);
                
            }
            con.close();
        } catch (SQLException ex) {
            Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
        }
        return rides;
     }

 
   
}
