package model;

import java.util.Date;
import model.Interfaces.DayTourInterface;

public class DayTour implements DayTourInterface {
	private String activity;
	private Date date;
	private String location;
	private int id;

	public void setActivity(String activity) {
		this.activity = activity;
	}

	public String getActivity() {
		return this.activity;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getLocation() {
		return this.location;
	}

	public void setDayTourID(int id) {
		this.id = id;
	}

	public int getDayTourID() {
		return this.id;
	}
}