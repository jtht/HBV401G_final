package model;

import model.Interfaces.HotelInterface;

public class Hotel implements HotelInterface {
	private String name;
	private String location;
	private int rating;
	private int id;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return this.location;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public int getRating() {
		return this.rating;
	}

	public void setID(int id) {
		this.id = id;
	}

	public int getID() {
		return this.id;
	}
}