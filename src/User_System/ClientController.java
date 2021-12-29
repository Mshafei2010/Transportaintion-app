/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
import NotificationCenter.NotificationModel;
import Ride_System.Offer;
import Ride_System.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ClientController {
    ClientModel clientmodel;
    public ClientController(Client client) {
        clientmodel= new ClientModel(client);
    }
    
    
    public boolean login(Client client) {
        return clientmodel.validate(client);
    }
    

    public void logout() {
       System.exit(0);
    }


    public boolean Signup(Client client) {
         return clientmodel.insert(client);
    }
    
    public Ride RequestRide(Client client,String src,String dest){
           Ride requested=new Ride (client.getUserName(), src, dest);
           RideController ridecontroller=new RideController();
          ridecontroller.RequestnewRide(requested);
          return requested;
                
    }   
    public ArrayList<Offer> listoffers(Client client) {
        
            RideController rideController=new RideController();
            return rideController.getmyOffers(client.getUserName());
    }
    public ArrayList<Notification> Notifications(Client client) throws SQLException
    {  
       return NotificationModel.Retrive(client,"Client");
    }

    
   
    public void selectOffer(Client client,Offer offer) {
        RideController rideController=new RideController();
        rideController.Clientpickoffer(offer);
    }
    //List all Rides From The Ride history
    //list all rides from the SAME PLACE FAV AREA
    //LIST all 
    /*public List selectOffer(Offer offer) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
    

    
    
}
