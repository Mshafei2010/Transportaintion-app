/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NotificationCenter;

import User_System.Person;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Notification {
    private String Message;
    private String Type;
    private String Name ;

    public Notification(String Message, String Type, String Name) {
        this.Message = Message;
        this.Type = Type;
        this.Name = Name;
        
    }

    public void Insert()
    {
        try {
            Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            
            Statement smt=con.createStatement();
            String dbo="Insert Into NotiicationCenter values('"+Message+"','"+Name+"','"+Type+"')";
            smt.execute(dbo);
            smt.close();
            con.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(Notification.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //to retrive all the Notifcation from the Notification Center Data Base
    public static ArrayList<Notification>Retrive(Person person,String typ) throws SQLException
    {
          ArrayList<Notification>Notifys=new ArrayList<Notification>();
        Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From NotiicationCenter");
            while(resultset.next())
            {
                String Name=resultset.getString("Name");
                if(Name.equalsIgnoreCase(person.getUserName()))
                {
                    String type=resultset.getString("Type");
                    if(type.equals(type))
                    {
                        String Message=resultset.getString("Message");
                       Notifys.add(new Notification(Message,typ,Name));
                        
                       
                    }
                }
            }
             con.close();
             return Notifys;
    }
      public static ArrayList<Notification>RetriveNotification(String typ) throws SQLException
    {
          ArrayList<Notification>Notifys=new ArrayList<Notification>();
        Connection con=DriverManager.getConnection("jdbc:sqlite:transportationDB.db");
            Statement smt=con.createStatement();
            ResultSet resultset=smt.executeQuery("SELECT * From NotiicationCenter");
            while(resultset.next())
            {
               
                    String type=resultset.getString("Type");
                    if(type.equals(typ))
                    {
                        String Message=resultset.getString("Message");
                        String Name=resultset.getString("Name");
                       Notifys.add(new Notification(Message,typ,Name));
                        
                       
                    }
                
            }
             con.close();
             return Notifys;
    }
     
    
    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getMessage() {
        return Message;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }
    
    
    
}
