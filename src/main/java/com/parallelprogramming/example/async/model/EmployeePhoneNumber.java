package com.parallelprogramming.example.async.model;

import java.io.Serializable;
import java.util.List;

public class EmployeePhoneNumber implements Serializable{

	public String phoneNumber;

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	@Override
	public String toString() {
		return "EmployeePhone [phoneNumber=" + phoneNumber + "]";
	}

}
