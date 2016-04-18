package model;

import java.util.Date;
import model.Interfaces.UserInterface;

public class User implements UserInterface {
	private String name;
	private Date birthDate;
	private String country;
	private String city;
	private String address;
	private int postalCode;
	private PaymentInfo paymentInfo;

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setBirthDate(Date date) {
		this.birthDate = date;
	}

	public Date getBirthDate() {
		return this.birthDate;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCity() {
		return this.city;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress() {
		return this.address;
	}

	public void setPostalCode(int postalCode) {
		this.postalCode = postalCode;
	}

	public int getPostalCode() {
		return this.postalCode;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public PaymentInfo getPaymentInfo() {
		return this.paymentInfo;
	}
}