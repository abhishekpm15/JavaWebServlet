package com.bean;

public class Customer {
	 int customerID;
	 String customerName;
	 String customerEmail;
	 String customerPassword;
	 String customerAddress;
	 String customerContact;
	
	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public String getCustomerContact() {
		return customerContact;
	}

	public void setCustomerContact(String customerContact) {
		this.customerContact = customerContact;
	}

	public Customer(int customerID, String customerName, String customerEmail, String customerPassword,
	String customerAddress, String customerContact) {
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
		this.customerContact = customerContact;
	}
	
	public Customer(int customerID , String customerPassword ) {
		this.customerID = customerID;
		this.customerPassword = customerPassword;
	}
	
}
