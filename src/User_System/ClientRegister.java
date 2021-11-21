/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package User_System;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
public class ClientRegister extends Register {



    @Override
    public boolean Regist(Person person) {
        
                        
        try {
             //Adding the user name to a client file .txt that contains all usersname 
              File Users_File=new File("Files to launch\\Clients\\Client.txt");
             FileWriter Ustream=new FileWriter(Users_File,true);
             BufferedWriter outusername=new BufferedWriter(Ustream);
             outusername.append(person.getUserName()+"\n");
             outusername.close();
             //Creating a Data File That Contains all the data of the client
            File clientfile=new File("Files to launch\\Clients\\"+person.getUserName()+".txt");
            clientfile.createNewFile();
            FileWriter fstream;
            fstream = new FileWriter(clientfile, true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.append(person.getUserName() + "\n");
            out.append(person.getPassword()+ "\n");
            out.append(person.getMoblieNumber()+"\n");
            out.close();
            return true;
        } catch (IOException ex) {
            return false;
        }
        }

}
