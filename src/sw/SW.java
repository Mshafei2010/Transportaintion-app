/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;
import User_System.*;
import Ride_System.*;
import java.util.Scanner;
public class SW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        //admin register
        Admin admin=new Admin("shaf3i", "123", "fdadadad");
        Register regadmin=new AdminRegister();
        admin.Signup(regadmin);
        //Driver register
        DriverRegister register=new DriverRegister();
        Driver p2= new Driver("Reda", "123", "102313131313", "fafsfs", "1312131");
        Driver p4= new Driver("Mohamed", "123", "wwwwwwwwwww", "dddddd", "111111");
        p2.AddFavArea("Giza");
        //verify Driver
        register.setAdmin(admin);
        admin.verifyDriverregister(register);
        p2.Signup(register);
        //user Register
        String name,email,password,phoneNumber;
        boolean yesForemail=false;
        Person p3;
        System.out.println("Enter your name: ");
        name=cin.next();
        System.out.println("Enter your password: ");
        password=cin.next();
        System.out.println("Enter your phone number: ");
        phoneNumber=cin.next();
        System.out.println("Do you want email :for yes press 1 for no press 0 ");
        email=cin.next();
        if(email.equals("1"))
        {
            System.out.println("Enter your email: ");
            email=cin.next();
            p3 = new Client(name , password , phoneNumber,email);
        }
        else{
            p3= new Client(name , password , phoneNumber);
        }
        //request ride
        String src , dest;
        System.out.println("Enter your soucre: ");
        src=cin.next();
        System.out.println("Enter your destenation: ");
        dest=cin.next();
        ReqRide r=new ReqRide((Client) p3 , src , dest);
        //Driver add offer
        System.out.println("Enter price for ride: ");
        int pric =cin.nextInt();
        r.addnewOffer(pric, (Driver)p2);
        System.out.println("Enter price for ride: ");
        pric =cin.nextInt();
        r.addnewOffer(pric, (Driver)p4);
        Offer [] offers = r.getOffers();
        for(int i = 0 ; i < offers.length ; i++)
        {
            if(offers[i]==null){
                break;
            } 
            Driver d= offers[i].getDriver();
            System.out.println(offers[i].getprice());
            System.out.println(d.getUserName());
            System.out.println(d.getMoblieNumber());
        }
    }
    
}
