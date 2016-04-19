package model;

import model.Interfaces.ResultsInterface;

public class Results implements ResultsInterface {
	private Profile profile;
        private User user;
	private TripPackage[] tripPackages;
	private Booking booker;

	public TripPackage[] getTripPackages() {
		return this.tripPackages;
	}

	public void bookPackage(TripPackage packag) {
		this.booker.bookPackageForUser(packag, this.profile, this.user);
	}
}