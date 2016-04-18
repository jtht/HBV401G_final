package model.Interfaces;

import model.DayTour;
import model.Flight;
import model.Hotel;
import model.Profile;

public interface SearchInterface {
	public void search(Profile profile);
	public mock.FlightMock[] getFlights();
	public mock.FlightMock[] getReturns();
	public Hotel[] getHotels();
	public DayTour[] getDayTours();
}