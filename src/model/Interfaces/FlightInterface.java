package model.Interfaces;

import java.util.Date;

public interface FlightInterface {
	public void setDepartureAirport(String airport);
	public String getDepartureAirport();

	public void setArrivalAirport(String airport);
	public String getArrivalAirport();

	public void setDepartureDate(Date date);
	public Date getDepartureDate();

	public void setArrivalDate(Date date);
	public Date getArrivalDate();

	public void setSeatingClass(String seatingClass);
	public String getSeatingClass();

	public void setSmoking(boolean smoking);
	public boolean getSmoking();

	public void setYoungChildren(boolean children);
	public boolean getYoungChildren();

	public void setFlightID(int id);
	public int getFlightID();
}