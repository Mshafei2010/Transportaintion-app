/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration_System;

import User_System.*;

public class DriverRegister extends RegisterFactory {

    public DriverRegister(RegisterDetails rd) {
        super(rd);
    }

    @Override
    public Driver Signup(RegisterDetails rd) {
       return new Driver(rd.getMoblieNumber(), rd.getPassword(), rd.getUserName(),rd.getNationalID(),rd.getDriverLicense());
    }
    public void NotifyAdmin(Driver driver,Admin admin)
    {
        
    }
    
}
