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
import User_System.*;
public abstract class RegisterFactory {
   RegisterDetails rd;

    public RegisterFactory(RegisterDetails rd) {
        this.rd = rd;
    }

    public void setRd(RegisterDetails rd) {
        this.rd = rd;
    }
   
   
   public abstract Person Signup(RegisterDetails rd);

}
