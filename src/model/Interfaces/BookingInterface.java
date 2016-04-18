package model.Interfaces;

import model.TripPackage;
import model.User;

public interface BookingInterface {
	public int[] bookPackageForUser(TripPackage packag, User user);
}