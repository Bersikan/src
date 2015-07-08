package com.example.tests;


public class ContactData implements Comparable<ContactData> {
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
		this.groupAssign = null;
		this.secAddr = secAddr;
		this.secHomeAddr = secHomeAddr;
	}
	
	@Override
	public String toString() {
		return "ContactData [contactName=" + contactName + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ContactData other = (ContactData) obj;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		return true;
	}

	@Override
	public int compareTo(ContactData other) {
		return this.contactName.toLowerCase().compareToIgnoreCase(other.contactName.toLowerCase());
		
	}
	
	

	
}