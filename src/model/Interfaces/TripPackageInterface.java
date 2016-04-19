package model.Interfaces;

import model.DayTour;
import model.Flight;
import model.Hotel;

public interface TripPackageInterface {
	public void setFlight(pakki.Flight flight);
	public pakki.Flight getFlight();

	public void setHotel(HotelSearch.Classes.Hotel hotel);
	public HotelSearch.Classes.Hotel getHotel();

	public void addDayTour(DayTour dayTour);
	public DayTour[] getDayTour();

	public void setReturnFlight(pakki.Flight returnFlight);
	public pakki.Flight getReturnFlight();
}