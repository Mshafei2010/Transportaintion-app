/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;


public abstract class Person {
    private String MoblieNumber;
    private String Email;
    private String Password;
    private String UserName;
    
    //Constructors
    public Person(String MoblieNumber, String Email, String Password, String UserName) {
        this.MoblieNumber = MoblieNumber;
        this.Email = Email;
        this.Password = Password;
        this.UserName = UserName;
    }
     public Person(String MoblieNumber, String Password, String UserName) {
        this.MoblieNumber = MoblieNumber;
        this.Password = Password;
        this.UserName = UserName;
    }
     
    

    //setters
    public void setEmail(String Email) {
        this.Email = Email;
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
    
    //login
    public abstract void login(String MoblieNumber, String Email, String Password, String UserName);
    public abstract void logout();
    
    
    
    
}
