/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Interfaces.BookingInterface;

/**
 *
 * @author Mogget
 */
public class Booking implements BookingInterface{
    private TripPackage packageToBook;
    private User user;

    public int[] bookPackageForUser(TripPackage packag, User user) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
