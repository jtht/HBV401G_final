package model;

import java.util.List;
import model.Interfaces.TripPackageInterface;

public class TripPackage implements TripPackageInterface {
	private mock.FlightMock flight;
	private mock.FlightMock returnFlight;
	private Hotel hotel;
	private List<DayTour> dayTours;

	public void setFlight(mock.FlightMock flight) {
		this.flight = flight;
	}

	public mock.FlightMock getFlight() {
		return this.flight;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

	public Hotel getHotel() {
		return this.hotel;
	}

	public void addDayTour(DayTour dayTour) {
		this.dayTours.add(dayTour);
	}

	public DayTour[] getDayTour() {
		return (DayTour[]) this.dayTours.toArray();
	}

	public void setReturnFlight(mock.FlightMock returnFlight) {
		this.returnFlight = returnFlight;
	}

	public mock.FlightMock getReturnFlight() {
		return this.returnFlight;
	}
}