package model.Interfaces;

import model.TripPackage;

public interface ResultsInterface {
	public TripPackage[] getTripPackages();
	public void bookPackage(TripPackage packag);
}