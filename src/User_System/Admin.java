/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

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
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Admin extends Person {
  
    //Constructors
    public Admin(String UserName,String Password,String MoblieNumber,String Email) {
        //Calling the super class Consturctor
        super(UserName, Password,   MoblieNumber, Email);
       
    }
    public Admin(String UserName,String Password,String MoblieNumber) {
         //Calling the super class Consturctor
        super( UserName, Password,MoblieNumber);
    
    }
    public boolean validate() {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From Admin");
            while(resultset.next())
            {
                String Name=resultset.getString("Name");
                if(Name.equalsIgnoreCase(UserName))
                {
                    String password=resultset.getString("Password");
                    if(password.equals(Password))
                    {
                        String Number=resultset.getString("Number");
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
     public void verifyDriverDatabase(String name) throws ClassNotFoundException, SQLException
     {   try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From driver where Name='"+name+"'");
            boolean first = resultset.next();
            if(first){
                    String Name=resultset.getString("Name");
                    String NationalID=resultset.getString("ID");
                    String DL=resultset.getString("driver_license");
                    Statement smt2=con.createStatement();
                    int state =1;
                    String dbo;
                    dbo = "Update driver set state="+state+" where Name='"+name+"'";
                    smt.execute(dbo);
                    
                    System.out.println("Driver ->Name :"+Name+"///National ID :"+NationalID+"///Driver License :"+DL+" IS Verified Successfuly");
            }
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Admin.class.getName()).log(Level.SEVERE, null, ex);
        }
     }


   
    public boolean insert(Register register) {
         if (register.Regist(this))
            return true;
        else
            return false;
    }
    
}
