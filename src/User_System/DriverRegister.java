/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class DriverRegister extends Register{
   @Override
    public boolean Regist(Person person) {
         Driver driver=(Driver) person;
             try {
                 Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
                 Statement smt=con.createStatement();
                 String dbo="Insert Into driver (Name,Password,ID,driver_license,Number,state,Email)values('"+driver.getUserName()+"','"+driver.getPassword()+"','"+driver.getNationalID()+"','"+driver.getDriverLicense()+"','"+driver.getMoblieNumber()+"','"+driver.getstate()+"','"+driver.getEmail()+"')";
                 smt.execute(dbo);
                 smt.close();
                 con.close();
                 return true;
             } catch (SQLException ex) {
                 return false;
             }
        
        }
    

    
    
}
