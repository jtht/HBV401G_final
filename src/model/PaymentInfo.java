package model;

import model.Interfaces.PaymentInfoInterface;

public class PaymentInfo implements PaymentInfoInterface {
	private long ccNumber;
	private int expirationDate;
	private int verificationCode;

	public void setCCNumber(long ccNumber) {
		this.ccNumber = ccNumber;
	}

	public long getCCNumber() {
		return this.ccNumber;
	}

	public void setExpirationDate(int expirationDate) {
		this.expirationDate = expirationDate;
	}

	public int getExpirationDate() {
		return this.expirationDate;
	}

	public void setVerificationCode(int verificationCode) {
		this.verificationCode = verificationCode;
	}

	public int getVerificationCode() {
		return this.verificationCode;
	}
}