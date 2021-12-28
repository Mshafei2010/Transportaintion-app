/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
import Ride_System.Offer;
import Ride_System.ReqRide;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientController {
    Client client;
    ReqRide requested;
    public ClientController(String MoblieNumber, String Email, String Password, String UserName) {
        client=new Client(UserName, Password, MoblieNumber, Email);
    }
    
    
    public boolean login( ) {
        return client.validate();
    }
    

    public void logout() {
       System.exit(0);
    }


    public boolean Signup() {
        Register register =new ClientRegister();
         return client.insert(register);
    }
    
    public ReqRide RequestRide(String src,String dest){
          requested=new ReqRide(client, src, dest);
          requested.Insert(requested);
          return requested;
                
    }   
    public ArrayList<Offer> listoffers() {
        if(requested!=null){
            ArrayList <Offer> offers=new ArrayList<Offer>();
            offers=requested.getOffers();
            return offers;
         
        }
    
            return null;
    }
    public ArrayList<Notification> Notifications() throws SQLException
    {  
       return Notification.Retrive(client,"Client");
    }

    
   
    public void selectOffer(Offer offer) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    //List all Rides From The Ride history
    //list all rides from the SAME PLACE FAV AREA
    //LIST all 
    /*public List selectOffer(Offer offer) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    

    
    
}
