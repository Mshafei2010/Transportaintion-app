/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Driver extends Person{
    
    private String NationalID;
    private String DriverLicense ;

//favoriteareas:FavouriteArea[]
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
        return false;
           
    }


    @Override
    public void logout() {
        
    }

    @Override
    public boolean Signup(Register register) {
        
        if(register.Regist(this))
        {
            Scanner input =new Scanner(System.in);
            String license=input.nextLine();
            String NAID=input.nextLine();
            setDriverLicense(license);
            setNationalID(NAID);
            return true;
        }
        return false;
    }
    
    
    
}
