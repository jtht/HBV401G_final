/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Interfaces.BookingInterface;

/**
 *
 * @author Mogget
 */
public class Booking implements BookingInterface{
    private TripPackage packageToBook;
    private User user;
    final private pakki.OrderManager flightBooker = new pakki.OrderManager();
    private int[] ret;

    public int[] bookPackageForUser(TripPackage pakki, Profile profile, User user) {
        List<pakki.Person> people = new ArrayList<>();
        DateFormat df = new SimpleDateFormat("ddMMyy");
        for(int i = 0; i < profile.getPartySize(); i++) {
            people.add(flightBooker.makePersons(user.getName() + i,
                    df.format(user.getBirthDate()) + "-xxxx",
                    false,
                    false,
                    "seat" + i,
                    1));
        }
        
        pakki.Order tmp = flightBooker.makeOrder(people,
                "tmp@tmp.tmp",
                "555-tmp",
                "",
                profile.getYoungChildren() ? 1 : 0,
                pakki.getFlight(),
                1);
        
        ret = new int[4];
        ret[0] = tmp.getOrderNr();
        
        boolean hotelret = HotelSearch.System.HotelBooker.bookHotel(user.getName(),
                Integer.parseInt(df.format(user.getBirthDate())),
                Date.from(profile.getDepartingDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                Date.from(profile.getArrivalDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                pakki.getHotel().rooms.get(0));
        
        if(hotelret) {
            ret[1] = 1;
        } else {
            ret[1] = -1;
        }
        
        return ret;
    }
    
}
