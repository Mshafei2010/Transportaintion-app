/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sw;
import User_System.*;
import Ride_System.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class SW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Scanner cin = new Scanner(System.in);
        while (true)
        {
            System.out.println("1-Admin");
            System.out.println("2-Driver");
            System.out.println("3-client");
            int choice=cin.nextInt();
            if(choice==1)
            {
                AdminView adminmenu=new AdminView();
                adminmenu.ListAdminMenu();
            }
            else if(choice==2)
            {
                DriverView drivermenu=new DriverView();
                drivermenu.ListDriverMenu();
            }
            else if(choice==3)
            {
                ClientView clientview=new ClientView();
                clientview.ListClientMenu();
            }
        }
        /*
        //admin register
        Admin admin=new Admin("shaf3i", "123", "0123");
        Register regadmin=new AdminRegister();
        admin.Signup(regadmin);
        //making this admin aproving the drivers
        DriverRegister driverregist=new DriverRegister();
        ClientRegister clientRegister=new ClientRegister();
        driverregist.setAdmin(admin);
        String name,password,phoneNumber,NAID,license,email,choice;
        Driver d1;
        Client c1 = null;
        Driver d2=null;
        while (true){
            System.out.println("choose ");
             System.out.println("1- Register as A driver :");
             System.out.println("2- Register as A client :");
             System.out.println("3- show pending driver registeration :");
             System.out.println("4- sign in as driver :");
             System.out.println("5- sign in as client:");
             System.out.println("6- Exit");
             
             choice=cin.next();
            if(choice.equals("1")){
        //driver register 
                 
                 System.out.println("Enter your name: ");
                 name=cin.next();
                 System.out.println("Enter your password: ");
                 password=cin.next();
                 System.out.println("Enter your phone number: ");
                phoneNumber=cin.next();
                System.out.println("Enter your  Email(optional if you want to skip press enter): ");
                email=cin.next();
                 System.out.println("Enter your  National ID: ");
                NAID=cin.next();
                System.out.println("Enter your License: ");
                license=cin.next();
                d1= new Driver(phoneNumber, email, password, name, NAID, license);
                d1.Signup(driverregist);
            }
            else if(choice.equals("2"))
            {
                cin.nextLine();
                System.out.println("Enter your name: ");
                name=cin.nextLine();
                System.out.println("Enter your password: ");
                password=cin.nextLine();
                System.out.println("Enter your phone number: ");
                phoneNumber=cin.nextLine();
                System.out.println("Enter your  Email(optional if you want to skip press enter): ");
                email=cin.nextLine();
                Client c=new Client(name, password, phoneNumber, email);
                if(c.Signup(clientRegister)){
                     System.out.println("client1-->regsiter completed");
              
                }
                else
                {
                    System.out.println("client-->You Already Registered in the system try to log in");
                }
            }
            else if(choice.equalsIgnoreCase("3"))
            {
                admin.listPendingReg();
              System.out.print("Admin->type the Name of the driver you want to verify:");
               String choice2;
                choice2 = cin.next();
                admin.verifyDriverregister(choice2);
            
            }
            else if(choice.equalsIgnoreCase("4"))
            {
                System.out.println("Enter your name: ");
                name=cin.next();
                System.out.println("Enter your password: ");
                password=cin.next();
                System.out.println("Enter your phone number: ");
                phoneNumber=cin.next();
                d2=new Driver(name, password, phoneNumber);
                if(d2.login(name, password))
                {
                    System.out.println("Sign in completed"); 
                    System.out.println("click (1) to - Add A new Favourite Area");
                    System.out.println("click (2) to - list all reqested rides");
                     String choice2=cin.next();
                     if(choice2.equalsIgnoreCase("1"))
                     {
                             System.out.println("Enter your fav area: ");
                             String src=cin.next();
                             d2.AddFavArea(src);
                     }
                     else if(choice2.equalsIgnoreCase("2"))
                     {
                        List<ReqRide>driverfav= d2.listreqrides();
                         for(int i=0;i<driverfav.size();i++)
                         {
                             System.out.println((i+1)+"-Requested from user-->"+driverfav.get(i).getClient().getUserName()+"//Src->>"+driverfav.get(i).getSrc());
                         }
                        System.out.println("Enter ride number to add offer");
                        int num=cin.nextInt();
                        if(driverfav.size()>=num)
                        {
                         System.out.println("Enter your offer please");
                         int offer=cin.nextInt();
                        driverfav.get(num-1).addnewOffer(offer, d2);
                        }
                     }
                    
                    
                }
                else
                {
                    System.out.println("sign in rejected");
                }
                
            }
             else if(choice.equalsIgnoreCase("5"))
            {
                System.out.println("Enter your name: ");
                name=cin.next();
                System.out.println("Enter your password: ");
                password=cin.next();
                System.out.println("Enter your phone number: ");
                phoneNumber=cin.next();
                c1=new Client(name, password, phoneNumber);
                
                if(c1.login(name, password))
                {
                    System.out.println("Sign in completed");
                     System.out.println("click (1) to - Request a Ride as Client");
                    String choice2=cin.next();
                    if(choice2.equalsIgnoreCase("1"))
                    {
                         System.out.println("Enter your src: ");
                         String src=cin.next();
                         System.out.println("Enter your dest: ");
                         String dest=cin.next();
                         c1.requestRide(src, dest);
                    }
                    
                }
                else
                {
                    System.out.println("sign in rejected");
                }
                
            }
             else if(choice.equalsIgnoreCase("6"))
             {
                 System.exit(0);
             }
            
            
            
            
            }
            
        
       /*
            d1=driversystem.get(0);
                 System.out.println("Enter your fav area: ");
                 String src=cin.next();
                 d1.AddFavArea(src);
        System.out.print("client1-->if you want to request a ride enter y:");
                choice=cin.next();
                if(choice.equalsIgnoreCase("y"))
                {
                    System.out.print("Enter a src :");
                    String src=cin.next();
                    System.out.print("Enter a destination :");
                     String dest=cin.next();
                    r[0]=client.requestRide(src, dest);
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
        }
        Driver d2= new Driver(name,password,phoneNumber,NAID,license);
        d2.Signup(driverregist);
        System.out.print("Admin->type y if you want to list pending registeration:");
         choice=cin.next();
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
         System.out.print("client2-->if you want to request a ride enter y :");
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
         
        }*/
         
         
         
        
        
        
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
