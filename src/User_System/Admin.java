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
public class Admin extends Person {
    
    //Constructors
    public Admin(String MoblieNumber, String Email, String Password, String UserName) {
        //Calling the super class Consturctor
        super(MoblieNumber, Email, Password, UserName);
    }
    public Admin(String MoblieNumber, String Password, String UserName) {
         //Calling the super class Consturctor
        super(MoblieNumber, Password, UserName);
    }

    @Override
    public void login(String MoblieNumber, String Email, String Password, String UserName) {
       
    }

 
    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    //
    public Driver[] listPendingReg()
    {
        return null;
        
    }
     public void updatePendingReg()
     {
         
     }
     public void verifyDriver(Driver Driver)
     {
         
     }

    
}
