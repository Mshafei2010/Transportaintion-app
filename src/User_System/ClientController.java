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
    ClientModel clientmodel;
    public ClientController() {
        clientmodel= new ClientModel();
    }
    
    
    public boolean login(Client client) {
        return clientmodel.validate(client);
    }
    

    public void logout() {
       System.exit(0);
    }


    public boolean Signup(Client client) {
        Register register =new ClientRegister();
         return clientmodel.insert(client,register);
    }
    
    public ReqRide RequestRide(Client client,String src,String dest){
        ReqRide requested;
          requested=new ReqRide(client, src, dest);
          requested.Insert(requested);
          return requested;
                
    }   
    public ArrayList<Offer> listoffers(Client client) {
     /*
            ArrayList <Offer> offers=new ArrayList<Offer>();
            offers=requested.getOffers();
            return offers;
         */
        
   
            return null;
    }
    public ArrayList<Notification> Notifications(Client client) throws SQLException
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
