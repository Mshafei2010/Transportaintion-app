/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

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
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Driver extends Person implements User{
    
    private String NationalID;
    private String DriverLicense ;
   private boolean state=false;
   private int faindex=0;
    String[] favoriteareas=new String [100];
//-ridesHistory:CompletedRide[]

     public Driver(String MoblieNumber, String Email, String Password, String UserName,String NationalID,String DriverLicense) {
        //Calling the super class Consturctor
        super(MoblieNumber, Email, Password, UserName);
        this.NationalID = NationalID;
        this.DriverLicense = DriverLicense;
    
    }
    public Driver(String UserName,String Password,String MoblieNumber,String NationalID,String DriverLicense) {
         //Calling the super class Consturctor
        super( UserName,Password,MoblieNumber);
          this.NationalID = NationalID;
        this.DriverLicense = DriverLicense;
    }

    public void setDriverLicense(String DriverLicense) {
        this.DriverLicense = DriverLicense;
    }

    public void setNationalID(String NationalID) {
        this.NationalID = NationalID;
    }

    

    
    @Override
    public boolean login( String UserName, String Password){
    File file=new File("Files to launch\\Drivers\\"+UserName+".txt");
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
        
    }

    @Override
    public boolean Signup(Register register) {
        
        if(register.Regist(this))
        {
            try {
                File clientfile=new File("Files to launch\\Drivers\\"+UserName+".txt");
                clientfile.createNewFile();
                FileWriter fstream;
                fstream = new FileWriter(clientfile, true);
                BufferedWriter out = new BufferedWriter(fstream);
                out.append(NationalID + "\n");
                out.append(DriverLicense+ "\n");
                out.close();
                setState(true);
                return true;
            } catch (IOException ex) {
                Logger.getLogger(Driver.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return false;
    }
    
    public void setState(boolean state) {
        this.state = state;
    }
    
   public boolean isverified()
   {
       return state;
   }

    @Override
    public void update() {
        System.out.print("New Request added please list requests");
    }


    
    public void listoffers(ReqRide ride) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void selectOffer(Offer offer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    public void AddFavArea(String area) {
        favoriteareas[faindex]=area;
        faindex++;
    }

    
    public void addOffer(ReqRide ride, int price) {
       ride.addnewOffer(price, this);
    }

  
    public Ride[] listreqrides(ReqRide[] requests) {
        
        Ride[] favrequests=new Ride[requests.length];
        int counter=0;
        for (int i=0;i<requests.length;i++)
        {
            for(int c=0;c<faindex;c++)
            {
            if(requests[i].getSrc().contains(favoriteareas[c]))
            {
                favrequests[counter]=requests[i];
            }
        }
        }
        return favrequests;
        
    }


}
