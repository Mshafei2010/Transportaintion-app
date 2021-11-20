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
    DriverRegister [] pendinglist;
    int countpending;
    //Constructors
    public Admin(String MoblieNumber, String Email, String Password, String UserName) {
        //Calling the super class Consturctor
        super(MoblieNumber, Email, Password, UserName);
        pendinglist=new DriverRegister[100];
        countpending=0;
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
    public DriverRegister[] listPendingReg()
    {
        return pendinglist;
        
    }
     public void updatePendingReg(DriverRegister dregiste)
     {
         addpending(dregiste);
     }
     public void verifyDriverregister(DriverRegister dregist)
     {
         dregist.setState(true);
     }

    @Override
    public boolean Signup(Register register) {
        return false;
       
    }
      public void addpending(DriverRegister pdriver)
    {
        
        pendinglist[countpending]=pdriver;
        countpending++;
    }

    
}
