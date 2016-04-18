/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import model.Interfaces.SearchInterface;

/**
 *
 * @author Mogget
 */
public class Search implements SearchInterface{
    private final mock.FlightSearchMock flightSearch = new mock.FlightSearchMock();
    private final mock.HotelSearchMock hotelSearch = new mock.HotelSearchMock();
    private final mock.DayTourSearchMock dayTourSearch = new mock.DayTourSearchMock();
    private List<mock.FlightMock> possibleFlights;
    private List<mock.FlightMock> possibleReturns;
    private Hotel[] possibleHotels;
    private DayTour[] possibleDayTours;
    private Profile profile;

    public void search(Profile profile) {
        possibleFlights = flightSearch.search(profile.getPartySize(),
                Date.from(profile.getDepartingDate().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                profile.getDestination(),
                profile.getOrigin());
        possibleReturns = flightSearch.search(profile.getPartySize(),
                Date.from(profile.getArrivalDate().atStartOfDay(ZoneId.systemDefault()).toInstant()),
                profile.getOrigin(),
                profile.getDestination());
    }

    public mock.FlightMock[] getFlights() {
        mock.FlightMock[] res = new mock.FlightMock[this.possibleFlights.size()];
        res = this.possibleFlights.toArray(res);
        return res;
    }

    public mock.FlightMock[] getReturns() {
        mock.FlightMock[] res = new mock.FlightMock[this.possibleReturns.size()];
        res = this.possibleReturns.toArray(res);
        return res;
    }

    public Hotel[] getHotels() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public DayTour[] getDayTours() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
