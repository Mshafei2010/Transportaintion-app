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
public class Client extends Person {

    public Client(String MoblieNumber, String Password, String UserName) {
        super(MoblieNumber, Password, UserName);
    }
       public Client(String MoblieNumber, String Email, String Password, String UserName) {
        //Calling the super class Consturctor
        super(MoblieNumber, Email, Password, UserName);
    }

    

    @Override
    public void login(String MoblieNumber, String Email, String Password, String UserName) {
        
    }


    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Signup(Register register) {
        if (register.Regist(this))
            return true;
        else
            return false;
    }
    
}
