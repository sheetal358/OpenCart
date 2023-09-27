package com.OpenCart.utils;

public class FakeData {
	static String firstName;
	static String lastName;
	static String emailId;
	static String phone;
	static String password;
	static String confirm_password;
	
	public static String getFirstName() {
		return FakeData.firstName;
	}
	public static void setFirstName(String firstName) {
		FakeData.firstName = firstName;
	}
	public static String getLastName() {
		return FakeData.lastName;
	}
	public static void setLastName(String lastName) {
		FakeData.lastName = lastName;
	}
	public static String getEmailId() {
		return FakeData.emailId;
	}
	public static void setEmailId(String emailId) {
		FakeData.emailId = emailId;
	}
	public static String getPhone() {
		return FakeData.phone;
	}
	public static void setPhone(String phone) {
		FakeData.phone = phone;
	}
	public static String getPassword() {
		return FakeData.password;
	}
	public static void setPassword(String password) {
		FakeData.password = password;
	}
	public static String getConfirm_password() {
		return FakeData.confirm_password;
	}
	public static void setConfirm_password(String confirm_password) {
		FakeData.confirm_password = confirm_password;
	}
	
}
