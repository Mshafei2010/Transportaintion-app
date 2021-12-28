/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import NotificationCenter.Notification;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Dell
 */
public class ClientView {
    
    ClientController clientcontroller;
    public void ListAdminMenu() throws SQLException, ClassNotFoundException
    {
        while(true){
    
            Scanner cin = new Scanner(System.in);
            Client client;
            System.out.println("Admin menu:");
            System.out.println("1- Register as An Admin:");
            System.out.println("2- sign in as Admin :");
              System.out.println("3- Exit:");
            
            int choice= cin.nextInt();
             String name,password,phoneNumber,email;
            if(choice==1)
            {
                 System.out.println("Enter your name: ");
                 name=cin.next();
                 System.out.println("Enter your password: ");
                 password=cin.next();
                 System.out.println("Enter your phone number: ");
                 phoneNumber=cin.next();
                System.out.println("Enter your  Email(optional if you want to skip press enter): ");
                email=cin.next();
               client =new Client(name, password, phoneNumber, email);
               clientcontroller=new ClientController();
                if(clientcontroller.Signup(client))
                {
                    System.out.println("\nSign UP Completed");
                }
                else
                {
                    System.out.println("\nTry Another UserName please (Duplicated User Name)");
                }
            }
            else if(choice==2)
            {
                System.out.println("Enter your name: ");
                 name=cin.next();
                 System.out.println("Enter your password: ");
                 password=cin.next();
                 System.out.println("Enter your phone number: ");
                 phoneNumber=cin.next();
                 client=new Client(name, password, phoneNumber);
                  clientcontroller=new ClientController();
                 if(clientcontroller.login(client))
                 {
                      System.out.println("Sign in completed"); 
                    System.out.println("click (1) to - Get Your Notifications");
                    System.out.println("click (2) to - list all Offers");
                    int choice2=cin.nextInt();
                    if(choice2==1){
                        ArrayList<Notification> Notify=client.Notifications(client);
                        for (int i=0;i<Notify.size();i++) {
                            System.out.println((i+1)+"--->"+Notify.get(i).getMessage()+Notify.get(i).getName());
                                    }
                        
                       
                    }
                 }
                 else
                 {
                     System.out.println("\nlogin refused ");
                 }
            }
            else if(choice==3)
            {
                break;
            }
    
}
    }
}
