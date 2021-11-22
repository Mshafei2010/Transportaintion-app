/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import Ride_System.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Client extends Person implements User{
    ReqRide requested;
    Offer [] ridesoffer= new Offer [100];

    public Client(String UserName,String Password,String MoblieNumber) {
        super(UserName, Password,MoblieNumber);
    }
       public Client(String UserName,String Password,String MoblieNumber,String Email) {
        //Calling the super class Consturctor
        super( UserName,Password, MoblieNumber,Email);
    }

    

    @Override
    public boolean login( String UserName, String Password) {
        
           File file=new File("Files to launch\\Clients\\"+UserName+".txt");
           if(file.exists())
           {
               FileReader fr = null;
               try {
                   fr = new FileReader (file.getPath());
                   BufferedReader inf = new BufferedReader(fr);
                   String line;
                while((line=inf.readLine())!=null){
                    if (Password.contains(line))
                        return true;
                }
                fr.close();
                } catch (FileNotFoundException ex) {
                   Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
               }  catch (IOException ex) {
                       Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
               }
           }

        return false;
    }
    


    @Override
    public void logout() {
       System.exit(0);
    }

    @Override
    public boolean Signup(Register register) {
        if (register.Regist(this))
            return true;
        else
            return false;
    }

    @Override
    public void update() {
        listoffers(requested);
        
    }

    public ReqRide requestRide(String src, String dest) {
       return requested=new ReqRide(this, src, dest);
    }



    @Override
    public void listoffers(ReqRide ride) {
        try{
        Offer[] offers=ride.getOffers();
        for (int i=0;i<offers.length;i++)
        {
            System.out.println("Driver Name"+offers[i].getDriver().getUserName()+"////"+"Price :"+offers[i].getprice());
        }
        }
        catch(Exception IO){
            System.out.print("");
        }
    }


    @Override
    public void selectOffer(Offer offer) {
         throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddFavArea(String area) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addOffer(ReqRide ride, int price ) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void listreqrides(ReqRide[] requests){}
    
    
}
