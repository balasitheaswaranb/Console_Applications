package com.model;

public class DoubleRoom extends SingleRoom {
	private String secondCustomerName;
	private String secondCustomerContactNumber;
	private String secondCustomerGender;
	
	public DoubleRoom(String name, String contact, String gender, String name2, String contact2, String gender2) {
		super(name,contact,gender);
		this.secondCustomerName = name2;
		this.secondCustomerContactNumber = contact2;
		this.secondCustomerGender = gender2;
	}
	public void setSecondCustomerName(String secondCustomerName) {
		this.secondCustomerName = secondCustomerName;
	}

	public String getSecondCustomerName() {
		return secondCustomerName;
	}

	public void setSecondCustomerContactNumber(String secondCustomerContactNumber) {
		this.secondCustomerContactNumber = secondCustomerContactNumber;
	}

	public String getSecondCustomerContactNumber() {
		return secondCustomerContactNumber;
	}

	public void setSecondCustomerGender(String secondCustomerGender) {
		this.secondCustomerGender = secondCustomerGender;
	}

	public String getSecondCustomerGender() {
		return secondCustomerGender;
	}
}