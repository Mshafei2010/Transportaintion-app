/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;
import User_System.*;
public class SW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Admin admin=new Admin("shaf3i", "123", "fdadadad");
        Register regadmin=new AdminRegister();
        admin.Signup(regadmin);
        DriverRegister register=new DriverRegister();
        Person p2= new Driver("Reda", "123", "102313131313", "fafsfs", "1312131");
        register.setAdmin(admin);
        admin.verifyDriverregister(register);
        p2.Signup(register);
        
       
    }
    
}
