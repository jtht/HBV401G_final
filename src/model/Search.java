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
    private final pakki.FlightSearch flightSearch = new pakki.FlightSearch();
    private final mock.HotelSearchMock hotelSearch = new mock.HotelSearchMock();
    private final mock.DayTourSearchMock dayTourSearch = new mock.DayTourSearchMock();
    
    private List<pakki.Flight> possibleFlights;
    private List<pakki.Flight> possibleReturns;
    private List<mock.HotelMock> possibleHotels;
    private DayTour[] possibleDayTours;
    private Profile profile;

    public void search(Profile profile) {
        possibleFlights = flightSearch.search(profile.getPartySize(),
                Date.from(profile.getDepartingDate().atStartOfDay().atZone(ZoneId.systemDefault()).toInstant()),
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
        Object[] tmp = dayTourSearch.search("Vatnajökull", "Fjallganga", tmpInput);
        //Búa til DayTour objectin. Vantar að vita hvernig nákvæmlega þetta á eftir að enda
        DayTour[] tmpTours = new DayTour[tmp.length];
        for(int i = 0; i < tmp.length; i++) {
            DayTour tmptour = new DayTour();
            tmptour.setActivity("Fjallganga");
            tmptour.setLocation("Vatnajökull");
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
    
    /*private List<mock.HotelMock> hotelFormatSearch(mock.HotelSearchFilterMock filter) {
        String din = new SimpleDateFormat("yyyy-MM-dd").format(filter.getDateIn());
        String dout = new SimpleDateFormat("yyyy-MM-dd").format(filter.getDateOut());

        List<String> sendList = new ArrayList<>();
        sendList.add(filter.getAreaName());
        sendList.add(din);
        sendList.add(dout);

        List<String>  queryList = new QueryStringBuilder().makeSearchHotelsQuery(sendList);

        ResultSet results = new DbUtils().SearchDB(queryList);

        return new SqlMapper().mapHotelSearch(results);
    }*/
    
}
