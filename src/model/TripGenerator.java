package model;

import java.util.ArrayList;
import java.util.List;
import model.Interfaces.TripGeneratorInterface;

public class TripGenerator implements TripGeneratorInterface {
	private Profile profile;
	private Search search = new Search();
	private List<TripPackage> tripPackages = new ArrayList<TripPackage>();
	private mock.FlightMock[] flights;
	private mock.FlightMock[] returns;
	private mock.HotelMock[] hotels;
	private DayTour[] dayTours;

	public void TripGenerator() {
		makeTrips();
		fetchTripsData();
		this.tripPackages.add(makeTripPackage());
	}
        
        public void setProfile(Profile profile) {
            this.profile = profile;
        }

	public TripPackage[] getTrips() {
            TripPackage[] res = new TripPackage[this.tripPackages.size()];
            res = this.tripPackages.toArray(res);
            return res;
	}

	private void makeTrips() {
		this.search.search(this.profile);
	}

	private void fetchTripsData() {
		this.flights = this.search.getFlights();
		this.returns = this.search.getReturns();
		this.hotels = this.search.getHotels();
		this.dayTours = this.search.getDayTours();
	}

	private TripPackage makeTripPackage() {
		TripPackage tmp = new TripPackage();
		tmp.setFlight(this.flights[0]);
		tmp.setHotel(this.hotels[0]);
		tmp.addDayTour(this.dayTours[0]);
		tmp.setReturnFlight(this.returns[0]);
		return tmp;
	}
}