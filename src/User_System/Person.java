/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;


public abstract class Person {
    protected String MoblieNumber;
    protected String Email;
    protected String Password;
    protected String UserName;
    protected Register register;
    
    //Constructors
    public Person(String UserName,String Password,String MoblieNumber, String Email ) {
        this.MoblieNumber = MoblieNumber;
        this.Email = Email;
        this.Password = Password;
        this.UserName = UserName;
    }
     public Person(String UserName,String Password,String MoblieNumber) {
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

    public void setRegister(Register register) {
        this.register = register;
    }

    public Register getRegister() {
        return register;
    }
    
    public abstract boolean Signup(Register register );
    
    //login
    public abstract boolean login( String UserName, String Password);
    public abstract void logout();
    
    
    
    
}
