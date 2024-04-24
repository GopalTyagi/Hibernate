package com.rays.subclass;

public class Cheque extends Payment {

	private String chqNumber;
	private String bankName;

	public String getChqNumber() {
		return chqNumber;
	}

	public void setChqNumber(String chqNumber) {
		this.chqNumber = chqNumber;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

}
