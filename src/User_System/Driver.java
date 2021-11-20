/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

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
    

    
    @Override
    public void login(String MoblieNumber, String Email, String Password, String UserName) {
        
    }


    @Override
    public void logout() {
        
    }

    @Override
    public boolean Signup(Register register) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
