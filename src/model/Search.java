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
    private List<mock.HotelMock> possibleHotels;
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
        
        mock.HotelSearchFilterMock filter = new mock.HotelSearchFilterMock();
        filter.wifi = true;
        filter.smoking = false;
        filter.breakfast = true;
        filter.rating = 4.0;
        filter.areaId = 1;
        filter.dateIn = Date.from(profile.getDepartingDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        filter.dateOut = Date.from(profile.getArrivalDate().atStartOfDay(ZoneId.systemDefault()).toInstant());
        possibleHotels = hotelSearch.findHotels(filter);
        
        //Object[] a = {cardDir, selectLanguage, review, animals, insurence, pickUp, accessibility};
        Object[] tmpInput = {3, 1, 3, false, true, true, false};
        Object[] tmp = dayTourSearch.search("Vatnajökull", "Hike", tmpInput);
        //Búa til DayTour objectin. Vantar að vita hvernig nákvæmlega þetta á eftir að enda
        DayTour[] tmpTours = new DayTour[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            DayTour tmptour = new DayTour();
            tmptour.setActivity("Hiking");
            tmpTours[i] = tmptour;
        }
        this.possibleDayTours = tmpTours;
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

    public mock.HotelMock[] getHotels() {
        mock.HotelMock[] res = new mock.HotelMock[this.possibleHotels.size()];
        res = this.possibleHotels.toArray(res);
        return res;
    }

    public DayTour[] getDayTours() {
        //return this.possibleDayTours;
        DayTour[] res = new DayTour[1];
        res[0] = new DayTour();
        res[0].setActivity("Hiking");
        return res;
    }
    
}
