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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class Client extends Person {

    public Client(String UserName,String Password,String MoblieNumber) {
        super(UserName, Password,MoblieNumber);
    }
       public Client(String UserName,String Password,String MoblieNumber,String Email) {
        //Calling the super class Consturctor
        super( UserName,Password, MoblieNumber,Email);
    }

    

    @Override
    public boolean login( String UserName, String Password) {
        
           File file=new File("Files to launch\\Clients\\"+UserName+".txt");
           if(file.exists())
           {
               FileReader fr = null;
               try {
                   fr = new FileReader (file.getPath());
                   BufferedReader inf = new BufferedReader(fr);
                   String line;
                while((line=inf.readLine())!=null){
                    if (Password.contains(line))
                        return true;
                }
                fr.close();
                } catch (FileNotFoundException ex) {
                   Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
               }  catch (IOException ex) {
                       Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
               }
           }

        return false;
    }
    


    @Override
    public void logout() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean Signup(Register register) {
        if (register.Regist(this))
            return true;
        else
            return false;
    }
    
}
