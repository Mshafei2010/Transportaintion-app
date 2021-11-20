/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ride_System;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author mshaf
 */
public class FavouriteAreas {
    Area [] arr ;
    FavouriteAreas () throws FileNotFoundException
    {
        try{
        List <String> fileStream = Files.readAllLines(Paths.get("Files to launch\\FavouriteAreas.txt"));
        int numofLn = fileStream.size();
        Scanner in = new Scanner(new File("Files to launch\\FavouriteAreas.txt"));
        arr = new Area [numofLn] ;
        int i = 0;
        while(in.hasNextLine())
            {
                arr[i++].setAName(in.nextLine());
                System.out.println(arr[i]);
            }
        }
        catch(Exception IO)
                {
                    System.out.println("Favoirte area do not work now");
                }
    }
    public void addnewArea(Area area){
        //Files.write(Paths.get("D:\\uni\\5th term\\Software Design\\SW\\Files to launch"), .getBytes(StandardCharsets.UTF_8),StandardOpenOption.APPEND);
        try{
        List <String> fileStream = Files.readAllLines(Paths.get("Files to launch\\FavouriteAreas.txt"));
        int numofLn = fileStream.size();
        Scanner in = new Scanner(new File("Files to launch\\FavouriteAreas.txt"));
        arr = new Area [numofLn] ;
        int i = 0;
        while(in.hasNextLine())
            {
                arr[i++].setAName(in.nextLine());
                System.out.println(arr[i]);
            }
        }
        catch(Exception IO)
                {
                    System.out.println("Favoirte area do not work now");
                }
    }
    public void deleteArea(Area area){
        
    }
    public Area[] getFavouriteAreas(){
        return arr;
    }
}
