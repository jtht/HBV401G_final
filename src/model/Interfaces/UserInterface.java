package model.Interfaces;

import java.util.Date;
import model.PaymentInfo;

public interface UserInterface {
	public void setName(String name);
	public String getName();

	public void setBirthDate(Date date);
	public Date getBirthDate();

	public void setCountry(String country);
	public String getCountry();

	public void setCity(String city);
	public String getCity();

	public void setAddress(String address);
	public String getAddress();

	public void setPostalCode(int postalCode);
	public int getPostalCode();

	public void setPaymentInfo(PaymentInfo paymentInfo);
	public PaymentInfo getPaymentInfo();
}