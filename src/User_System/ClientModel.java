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
 
   Client client;
    public ClientModel(Client client ) {
       this.client=client;
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
    
 
    public boolean insert(Client client) {
       try {
             Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            
            Statement smt=con.createStatement();
            String dbo="Insert Into client (clientName,Email,CNumber,CPassword)values('"+client.getUserName()+"','"+client.getEmail()+"','"+client.getMoblieNumber()+"','"+client.getPassword()+"')";
            smt.execute(dbo);
            smt.close();
            con.close();
            return true;
          
       } catch (SQLException ex) {
           Logger.getLogger(ClientModel.class.getName()).log(Level.SEVERE, null, ex);
       }
       return false;
    }

    
    
}
