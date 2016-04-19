package model;

import java.util.ArrayList;
import java.util.List;
import model.Interfaces.TripPackageInterface;

public class TripPackage implements TripPackageInterface {
	private pakki.Flight flight;
	private pakki.Flight returnFlight;
	private mock.HotelMock hotel;
	private List<DayTour> dayTours = new ArrayList<>();

	public void setFlight(pakki.Flight flight) {
		this.flight = flight;
	}

	public pakki.Flight getFlight() {
		return this.flight;
	}

	public void setHotel(mock.HotelMock hotel) {
		this.hotel = hotel;
	}

	public mock.HotelMock getHotel() {
		return this.hotel;
	}

	public void addDayTour(DayTour dayTour) {
		this.dayTours.add(dayTour);
	}

	public DayTour[] getDayTour() {
            DayTour[] res = new DayTour[this.dayTours.size()];
            res = this.dayTours.toArray(res);
            return res;
	}

	public void setReturnFlight(pakki.Flight returnFlight) {
		this.returnFlight = returnFlight;
	}

	public pakki.Flight getReturnFlight() {
		return this.returnFlight;
	}
}