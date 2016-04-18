package model.Interfaces;

import model.DayTour;
import model.Flight;
import model.Hotel;

public interface TripPackageInterface {
	public void setFlight(mock.FlightMock flight);
	public mock.FlightMock getFlight();

	public void setHotel(mock.HotelMock hotel);
	public mock.HotelMock getHotel();

	public void addDayTour(DayTour dayTour);
	public DayTour[] getDayTour();

	public void setReturnFlight(mock.FlightMock returnFlight);
	public mock.FlightMock getReturnFlight();
}