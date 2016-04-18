package model.Interfaces;

import java.util.Date;

public interface DayTourInterface {
	public void setActivity(String activity);
	public String getActivity();

	public void setDate(Date date);
	public Date getDate();

	public void setLocation(String location);
	public String getLocation();

	public void setDayTourID(int id);
	public int getDayTourID();
}