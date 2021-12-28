/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import Ride_System.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Client extends Person {
    ReqRide requested;
    Offer [] ridesoffer= new Offer [100];

    public Client(String UserName,String Password,String MoblieNumber) {
        super(UserName, Password,MoblieNumber);
    }
       public Client(String UserName,String Password,String MoblieNumber,String Email) {
        //Calling the super class Consturctor
        super( UserName,Password, MoblieNumber,Email);
    }

    

    public boolean validate() {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From client");
            while(resultset.next())
            {
                String Name=resultset.getString("clientName");
                if(Name.equalsIgnoreCase(UserName))
                {
                    String password=resultset.getString("CPassword");
                    if(password.equals(Password))
                    {
                        String Number=resultset.getString("CNumber");
                        this.setMoblieNumber(Number);
                        String email=resultset.getString("Email");
                        this.setEmail(email);
                        
                        con.close();
                        return true;
                    }
                }
            }
            con.close();   
            return false;
        } catch (SQLException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    



 
    public boolean insert(Register register) {
         if (register.Regist(this))
            return true;
        else
            return false;
    }

    
    
}
