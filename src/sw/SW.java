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

        Register register=new AdminRegister();
        Person p2= new Admin("nnn","dasdas123","mmmmm");
        if(p2.login( "nnn","dasdas123"))
        {
            System.out.println("sw.SW.main()");
        }
        else
            System.out.println("no");
        
        
       
    }
    
}
