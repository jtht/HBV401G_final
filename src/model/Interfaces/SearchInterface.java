package model.Interfaces;

import model.DayTour;
import model.Flight;
import model.Hotel;
import model.Profile;

public interface SearchInterface {
	public void search(Profile profile);
	public pakki.Flight[] getFlights();
	public pakki.Flight[] getReturns();
	public HotelSearch.Classes.Hotel[] getHotels();
	public DayTour[] getDayTours();
}