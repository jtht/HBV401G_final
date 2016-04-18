package model;

import java.util.Date;
import model.Interfaces.FlightInterface;

public class Flight implements FlightInterface {
	private String departureAirport;
	private String arrivalAirport;
	private Date departureDate;
	private Date arrivalDate;
	private String seatingClass;
	private boolean smoking;
	private boolean youngChildren;
	private int id;

	public void setDepartureAirport(String airport) {
		this.departureAirport = airport;
	}

	public String getDepartureAirport() {
		return this.departureAirport;
	}

	public void setArrivalAirport(String airport) {
		this.arrivalAirport = airport;
	}

	public String getArrivalAirport() {
		return this.arrivalAirport;
	}

	public void setDepartureDate(Date date) {
		this.departureDate = date;
	}

	public Date getDepartureDate() {
		return this.departureDate;
	}

	public void setArrivalDate(Date date) {
		this.arrivalDate = date;
	}

	public Date getArrivalDate() {
		return this.arrivalDate;
	}

	public void setSeatingClass(String seatingClass) {
		this.seatingClass = seatingClass;
	}

	public String getSeatingClass() {
		return this.seatingClass;
	}

	public void setSmoking(boolean smoking) {
		this.smoking = smoking;
	}

	public boolean getSmoking() {
		return this.smoking;
	}

	public void setYoungChildren(boolean children) {
		this.youngChildren = children;
	}

	public boolean getYoungChildren() {
		return this.youngChildren;
	}

	public void setFlightID(int id) {
		this.id = id;
	}

	public int getFlightID() {
		return this.id;
	}
}