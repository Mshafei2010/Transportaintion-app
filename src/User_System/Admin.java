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
    List <Driver>pendinglist;
    int countpending=0;
    //Constructors
    public Admin(String UserName,String Password,String MoblieNumber,String Email) {
        //Calling the super class Consturctor
        super(UserName, Password,   MoblieNumber, Email);
         pendinglist=new ArrayList<Driver>();
    }
    public Admin(String UserName,String Password,String MoblieNumber) {
         //Calling the super class Consturctor
        super( UserName, Password,MoblieNumber);
        pendinglist=new ArrayList<Driver>();
        countpending=0;
    }

    @Override
    public boolean login( String UserName, String Password) {
  File file=new File("Files to launch\\Admins\\"+UserName+".txt");
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
    
    //
    public void listPendingReg()
    {
        for(int i=0;i<pendinglist.size();i++)
        {
             System.err.println((i+1)+"- Name :"+pendinglist.get(i).getUserName()+"// National ID:"+pendinglist.get(i).getNationalID()+"// Driver License:"+pendinglist.get(i).getDriverLicense());
        }
    }
     public void updatePendingReg(Driver pdriver)
     {
         System.out.println("Admin:->Please check pending list");
         addpending(pdriver);
     }
     public void verifyDriverregister(Driver driver)
     {
         pendinglist.remove(driver);
         driver.setState(true);
         driver.Signup(driver.getRegister());
         
     }

    @Override
    public boolean Signup(Register register) {
      return register.Regist(this);
    }
      public void addpending(Driver pdriver)
    {
        boolean add = pendinglist.add(pdriver);
    }

    
}
