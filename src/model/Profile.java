/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
//Tilraun

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

/**
 *
 * @author johannesthorkell
 */

public class Profile {
	private LocalDate departingDate;
	private LocalDate arrivalDate;
	private String origin;
	private String destination;
	private int partySize;
        // þarf að ákveða hvernig framboð daytours er implementað
	private List<String> dayTourActivities;
	private boolean smoker;
	private boolean youngChildren;

	public void setDepartingDate(LocalDate date) {
		departingDate = date;
	}

	public LocalDate getDepartingDate() {
		return departingDate;
	}

	public void setArrivalDate(LocalDate date) {
		arrivalDate = date;
	}

	public LocalDate getArrivalDate() {
		return arrivalDate;
	}

	public void setOrigin(String origin) {
		this.origin = origin;
	}

	public String getOrigin() {
		return origin;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDestination() {
		return destination;
	}

	public void setPartySize(int partySize) {
		this.partySize = partySize;
	}

	public int getPartySize() {
		return partySize;
	}

	public void addDayTourActivity(String activity) {
		dayTourActivities.add(activity);
	}

	public List<String> getDayTourActivitys() {
		return dayTourActivities;
	}

	public void setSmokers(boolean smoker) {
		this.smoker = smoker;
	}

	public boolean getSmokers() {
		return smoker;
	}

	public void setYoungChildren(boolean youngChildren) {
		this.youngChildren = youngChildren;
	}

	public boolean getYoungChildren() {
		return youngChildren;
	}
}
