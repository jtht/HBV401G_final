package model.Interfaces;

public interface PaymentInfoInterface {
	public void setCCNumber(long ccNumber);
	public long getCCNumber();

	public void setExpirationDate(int expirationDate);
	public int getExpirationDate();

	public void setVerificationCode(int verificationCode);
	public int getVerificationCode();
}