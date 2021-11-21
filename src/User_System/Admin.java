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
    public Admin(String UserName,String Password,String MoblieNumber,String Email) {
        //Calling the super class Consturctor
        super(UserName, Password,   MoblieNumber, Email);
        pendinglist=new DriverRegister[100];
        countpending=0;
    }
    public Admin(String UserName,String Password,String MoblieNumber) {
         //Calling the super class Consturctor
        super( UserName, Password,MoblieNumber);
    }

    @Override
    public boolean login( String UserName, String Password) {
        return false;
       
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
      return register.Regist(this);
    }
      public void addpending(DriverRegister pdriver)
    {
        
        pendinglist[countpending]=pdriver;
        countpending++;
    }

    
}
