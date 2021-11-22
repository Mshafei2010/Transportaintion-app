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
        //making this admin aproving the drivers
        DriverRegister driverregist=new DriverRegister();
        driverregist.setAdmin(admin);
        
        //driver register 1
        System.out.println("Register as A driver d1 please :");
        String name,password,phoneNumber,NAID,license;
       
        System.out.println("Enter your name: ");
        name=cin.next();
        System.out.println("Enter your password: ");
        password=cin.next();
        System.out.println("Enter your phone number: ");
        phoneNumber=cin.next();
        System.out.println("Enter your  National ID: ");
        NAID=cin.next();
        System.out.println("Enter your License: ");
        license=cin.next();
        
        //Driver register 2
        Driver d1= new Driver(name,password,phoneNumber,NAID,license);
        d1.Signup(driverregist);
          System.out.print("Register as A driver d2 please");
        System.out.println("Enter your name: ");
        name=cin.next();
        System.out.println("Enter your password: ");
        password=cin.next();
        System.out.println("Enter your phone number: ");
        phoneNumber=cin.next();
        System.out.println("Enter your  National ID: ");
        NAID=cin.next();
        System.out.println("Enter your License: ");
        license=cin.next();
        
        Driver d2= new Driver(name,password,phoneNumber,NAID,license);
        d2.Signup(driverregist);
        System.out.print("Admin->type y if you want to list pending registeration:");
        String choice=cin.next();
        if(choice.equalsIgnoreCase("y"))
        {
            admin.listPendingReg();
            System.out.print("Admin->type the number of the driver you want to verify:");
             String choice2=cin.next();
             if(choice2.equalsIgnoreCase("1"))
             {
                admin.verifyDriverregister(d1);
             }
             else if(choice2.equalsIgnoreCase("2"))
             {
                 admin.verifyDriverregister(d2);
             }
        }
        //Adding Favourit areas to driver d1
        if(d1.getstate())
        {
            String farea;
            System.out.print("Driver d1->Enter your favourite Area :");
           farea =cin.next();
            d1.AddFavArea(farea);
            System.out.print("Driver d1->Enter your favourite Area :");
             farea=cin.next();
            d1.AddFavArea(farea);
            System.out.print("Driver d1->Enter your favourite Area :");
             farea=cin.next();
            d1.AddFavArea(farea);
           
        }
         System.out.print("Register as A client please");
        System.out.println("Enter your name: ");
        name=cin.next();
        System.out.println("Enter your password: ");
        password=cin.next();
        System.out.println("Enter your phone number: ");
        phoneNumber=cin.next();
        Client client=new Client(name, password, phoneNumber);
        ClientRegister clientRegister=new ClientRegister();
        ReqRide[] r=new ReqRide[2];
        if(client.Signup(clientRegister)){
        
        //request ride
         System.out.print("client1-->if you want to request a ride enter y:");
         choice=cin.next();
         if(choice.equalsIgnoreCase("y"))
         {
             System.out.print("Enter a src :");
             String src=cin.next();
             System.out.print("Enter a destination :");
             String dest=cin.next();
             r[0]=client.requestRide(src, dest);
         }
        }
        //Registering a second client 
          System.out.print("Register as A client 2 please");
        System.out.println("Enter your name: ");
        name=cin.next();
        System.out.println("Enter your password: ");
        password=cin.next();
        System.out.println("Enter your phone number: ");
        phoneNumber=cin.next();
        Client client2=new Client(name, password, phoneNumber);
        client.Signup(clientRegister);
         System.out.print("client2-->if you want to request a ride enter y:");
         choice=cin.next();
         if(choice.equalsIgnoreCase("y"))
         {
             System.out.print("Enter a src :");
             String src=cin.next();
             System.out.print("Enter a destination :");
             String dest=cin.next();
             r[1]=client2.requestRide(src, dest);
         }
          System.out.print("D1-->if you want to show requested rides from your fav areas enter y :");
           choice=cin.next();
         if (choice.equalsIgnoreCase("y")){
         d1.listreqrides(r);
         }
         
         
         
        
        
        
        //p2.AddFavArea("Giza");p2.AddFavArea("Giza");
        
        //user Register
        /*
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
        }*/
    }
    
}
