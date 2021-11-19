/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Registration_System;

import User_System.*;
public class ClientRegister extends RegisterFactory {

    public ClientRegister(RegisterDetails rd) {
        super(rd);
    }
    

    @Override
    public Client Signup(RegisterDetails rd) {
       return new Client(rd.getMoblieNumber(), rd.getPassword(), rd.getUserName());
    }
    
}
