/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ride_System;

import User_System.Driver;

/**
 *
 * @author mshaf
 */
public class Offer {
    float price=0;
    Driver driver;
    
    Offer(int price, Driver driver)
    {
        this.price=price;
        this.driver = driver;
    }
    public void setprice(int price)
    {
        this.price = price;
    }
    public float getprice()
    {
        return price;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }
    
    
            
}
