/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import Ride_System.*;
import java.util.List;

/**
 *
 * @author Dell
 */
public interface User {
    
    public void update(ReqRide ride);
    public void listoffers(ReqRide ride);
    public void selectOffer(Offer offer) ;
    public void AddFavArea(String area);
    public void addOffer(ReqRide ride, int price) ;
    public List<ReqRide>listreqrides();
    
    
}
