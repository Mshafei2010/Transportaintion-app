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
}
