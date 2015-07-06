package com.example.tests;


public class ContactData {
	public String contactName;
	public String contactLastName;
	public String address;
	public String homePhone;
	public String mobilePhone;
	public String workPhone;
	public String email_1;
	public String email_2;
	public String birhDay;
	public String birthMonth;
	public String birthYear;
	public String groupAssign;
	public String secAddr;
	public String secHomeAddr;
	
	public ContactData(){
		
	}

	public ContactData(String contactName, String contactLastName,
			String address, String homePhone, String mobilePhone,
			String workPhone, String email_1, String email_2, String birhDay,
			String birthMonth, String birthYear, String groupAssign,
			String secAddr, String secHomeAddr) {
		this.contactName = contactName;
		this.contactLastName = contactLastName;
		this.address = address;
		this.homePhone = homePhone;
		this.mobilePhone = mobilePhone;
		this.workPhone = workPhone;
		this.email_1 = email_1;
		this.email_2 = email_2;
		this.birhDay = birhDay;
		this.birthMonth = birthMonth;
		this.birthYear = birthYear;
		this.groupAssign = groupAssign;
		this.secAddr = secAddr;
		this.secHomeAddr = secHomeAddr;
	}

	
}