/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class ClientModel {
 

    public ClientModel() {
       
    }
      

    public boolean validate(Client client) {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From client");
            while(resultset.next())
            {
                String Name=resultset.getString("clientName");
                if(Name.equalsIgnoreCase(client.getUserName()))
                {
                    String password=resultset.getString("CPassword");
                    if(password.equals(client.getPassword()))
                    {
                        String Number=resultset.getString("CNumber");
                        client.setMoblieNumber(Number);
                        String email=resultset.getString("Email");
                        client.setEmail(email);
                        
                        con.close();
                        return true;
                    }
                }
            }
            con.close();   
            return false;
        } catch (SQLException ex) {
            return false;
        }
    }
    
 
    public boolean insert(Client client,Register register) {
         if (register.Regist(client))
            return true;
        else
            return false;
    }

    
    
}
