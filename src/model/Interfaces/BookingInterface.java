package model.Interfaces;

import model.Profile;
import model.TripPackage;
import model.User;

public interface BookingInterface {
	public int[] bookPackageForUser(TripPackage pakki, Profile profile, User user);
}