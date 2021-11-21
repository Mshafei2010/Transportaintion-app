/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ride_System;

import java.sql.Time;

/**
 *
 * @author mshaf
 */
public class Ridespec {
    Time timetoleave;
    int distance;
    int speed;
    Time finalETA;

    public Ridespec(Time timetoleave , int distance ,int speed , Time finalETA) {
        this.timetoleave = timetoleave;
        this.distance = distance;
        this.speed = speed;
        this.finalETA =finalETA;
    }
    
    public void settimeofleave(Time timeofleave){
        this.timetoleave=timeofleave;
    }
    Time gettimeofleave(){
        return timetoleave;
    }
    void setSpeed(int speed){
        this.speed = speed;
    }
    int getSpeed(){
        return speed;
    }
    /*int calcdest(Area src ,Area Dest){
        
    }*/
    Time calcfinalETA(){
        return finalETA;
    }
    int getdistance(){
        return distance;
    }
    

}
