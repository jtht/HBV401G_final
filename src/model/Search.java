/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import model.Interfaces.SearchInterface;

/**
 *
 * @author Mogget
 */
public class Search implements SearchInterface{
    private final pakki.FlightSearch flightSearch = new pakki.FlightSearch();
    private final HotelSearch.System.HotelFinder hotelSearch = new HotelSearch.System.HotelFinder();
    private final mock.DayTourSearchMock dayTourSearch = new mock.DayTourSearchMock();
    
    private List<pakki.Flight> possibleFlights;
    private List<pakki.Flight> possibleReturns;
    private List<HotelSearch.Classes.Hotel> possibleHotels;
    private DayTour[] possibleDayTours;
    private Profile profile;

    public void search(Profile profile) {
        this.profile = profile;
        
        possibleFlights = flightSearch.search(profile.getPartySize(),
                Date.from(profile.getDepartingDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
                profile.getDestination(),
                profile.getOrigin());

        possibleReturns = flightSearch.search(profile.getPartySize(),
                Date.from(profile.getArrivalDate().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                profile.getOrigin(),
                profile.getDestination());
        
        HotelSearch.Classes.HotelSearchFilter filter = new HotelSearch.Classes.HotelSearchFilter();
        filter.wifi = true;
        filter.smoking = false;
        filter.breakfast = true;
        filter.rating = 4.0;
        filter.areaId = 1;
        filter.areaName = findArea();
        filter.dateIn = java.sql.Date.valueOf(profile.getDepartingDate());
        filter.dateOut = java.sql.Date.valueOf(profile.getArrivalDate());
        possibleHotels = hotelFormatSearch(filter);
        
        //Object[] a = {cardDir, selectLanguage, review, animals, insurence, pickUp, accessibility};
        Object[] tmpInput = {3, 1, 3, false, true, true, false};
        Object[] tmp = dayTourSearch.search("Vatnajökull", "Fjallganga", tmpInput);
        //Búa til DayTour objectin. Vantar að vita hvernig nákvæmlega þetta á eftir að enda
        DayTour[] tmpTours = new DayTour[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            DayTour tmptour = new DayTour();
            tmptour.setActivity("Fjallganga");
            tmptour.setLocation(findArea());
            tmptour.setDate(Date.from(profile.getDepartingDate().atStartOfDay(ZoneId.systemDefault()).toInstant()));
            tmpTours[i] = tmptour;
        }
        this.possibleDayTours = tmpTours;
    }
    
    public pakki.Flight[] getFlights() {
        pakki.Flight[] res = new pakki.Flight[this.possibleFlights.size()];
        res = this.possibleFlights.toArray(res);
        return res;
    }
    
    public pakki.Flight[] getReturns() {
        pakki.Flight[] res = new pakki.Flight[this.possibleReturns.size()];
        res = this.possibleReturns.toArray(res);
        return res;
    }

    public HotelSearch.Classes.Hotel[] getHotels() {
        HotelSearch.Classes.Hotel[] res = new HotelSearch.Classes.Hotel[this.possibleHotels.size()];
        res = this.possibleHotels.toArray(res);
        return res;
    }

    public DayTour[] getDayTours() {
        return this.possibleDayTours;
    }
    
    private List<HotelSearch.Classes.Hotel> hotelFormatSearch(HotelSearch.Classes.HotelSearchFilter filter) {
        return hotelSearch.getHotels(filter);
    }
    
    private String findArea() {
        switch(this.profile.getDestination()) {
            case "RKV":
                return "Capital Area";
            case "AEY":
                return "North Iceland";
            case "IFJ":
                return "Westfjords";
            case "EGS":
                return "Eastern Iceland";
            case "VES":
                return "Vestmannaeyjar";
        }
        return "All areas";
    }
    
}
