/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClientRegister extends Register {



    @Override
    public boolean Regist(Person person) {
        
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            
            Statement smt=con.createStatement();
            String dbo="Insert Into client (clientName,Email,CNumber,CPassword)values('"+person.getUserName()+"','"+person.getEmail()+"','"+person.getMoblieNumber()+"','"+person.getPassword()+"')";
            smt.execute(dbo);
            smt.close();
            con.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ClientRegister.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        }

}
