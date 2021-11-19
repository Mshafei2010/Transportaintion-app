/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration_System;

/**
 *
 * @author Dell
 */
public class RegisterDetails {
     private String MoblieNumber;
    private String Email;
    private String Password;
    private String UserName;
    private String NationalID;
    private String DriverLicense ;
    //Constructors
    public RegisterDetails(String MoblieNumber, String Email, String Password, String UserName) {
        this.MoblieNumber = MoblieNumber;
        this.Email = Email;
        this.Password = Password;
        this.UserName = UserName;
    }
     public RegisterDetails(String MoblieNumber, String Password, String UserName) {
        this.MoblieNumber = MoblieNumber;
        this.Password = Password;
        this.UserName = UserName;
    }
     
    

    //setters
    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setDriverLicense(String DriverLicense) {
        this.DriverLicense = DriverLicense;
    }

    public void setNationalID(String NationalID) {
        this.NationalID = NationalID;
    }
    

    public void setMoblieNumber(String MoblieNumber) {
        this.MoblieNumber = MoblieNumber;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setUserName(String UserName) {
        this.UserName = UserName;
    }
  //Getters
    public String getEmail() {
        return Email;
    }

    public String getMoblieNumber() {
        return MoblieNumber;
    }

    public String getPassword() {
        return Password;
    }

    public String getUserName() {
        return UserName;
    }

    public String getDriverLicense() {
        return DriverLicense;
    }

    public String getNationalID() {
        return NationalID;
    }
    
}
