package model.Interfaces;

import java.util.Date;
import model.User;

public interface ProfileInterface {
	public void setDepartingDate(Date date);
	public Date getDepartingDate();

	public void setArrivalDate(Date date);
	public Date getArrivalDate();

	public void setOrigin(String origin);
	public String getOrigin();

	public void setDestination(String destination);
	public String getDestination();

	public void setPartySize(int partySize);
	public int getPartySize();

	public void addDayTourActivity(String activity);
	public String[] getDayTourActivitys();

	public void setSmokers(boolean smoker);
	public boolean getSmokers();

	public void setYoungChildren(boolean youngChildren);
	public boolean getYoungChildren();

	public User getUser();
}