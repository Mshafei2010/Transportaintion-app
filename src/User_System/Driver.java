/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class Driver extends Person{
    
    private String NationalID;
    private String DriverLicense ;
    private boolean state;
//favoriteareas:FavouriteArea[]
//-ridesHistory:CompletedRide[]

     public Driver(String MoblieNumber, String Email, String Password, String UserName,String NationalID,String DriverLicense) {
        //Calling the super class Consturctor
        super(MoblieNumber, Email, Password, UserName);
        this.NationalID = NationalID;
        this.DriverLicense = DriverLicense;
        state=false;
    }
    public Driver(String MoblieNumber, String Password, String UserName,String NationalID,String DriverLicense) {
         //Calling the super class Consturctor
        super(MoblieNumber, Password, UserName);
          this.NationalID = NationalID;
        this.DriverLicense = DriverLicense;
    }

    public void setDriverLicense(String DriverLicense) {
        this.DriverLicense = DriverLicense;
    }

    public void setNationalID(String NationalID) {
        this.NationalID = NationalID;
    }

    public void setState(boolean state) {
        this.state = state;
    }
    
    

    
    @Override
    public void login(String MoblieNumber, String Email, String Password, String UserName) {
        
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
