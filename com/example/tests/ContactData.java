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
		return "ContactData [contactName=" + contactName + ", contactLastName="
				+ contactLastName + ", address=" + address + ", homePhone="
				+ homePhone + ", mobilePhone=" + mobilePhone + ", workPhone="
				+ workPhone + ", email_1=" + email_1 + ", email_2=" + email_2
				+ ", birhDay=" + birhDay + ", birthMonth=" + birthMonth
				+ ", birthYear=" + birthYear + ", groupAssign=" + groupAssign
				+ ", secAddr=" + secAddr + ", secHomeAddr=" + secHomeAddr + "]";
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		/*result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((contactLastName == null) ? 0 : contactLastName.hashCode());
		result = prime * result + ((contactName == null) ? 0 : contactName.hashCode());
		result = prime * result + ((email_1 == null) ? 0 : email_1.hashCode());
		result = prime * result + ((email_2 == null) ? 0 : email_2.hashCode());
		result = prime * result + ((homePhone == null) ? 0 : homePhone.hashCode());
		result = prime * result + ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
		result = prime * result + ((secAddr == null) ? 0 : secAddr.hashCode());
		result = prime * result + ((secHomeAddr == null) ? 0 : secHomeAddr.hashCode());
		result = prime * result + ((workPhone == null) ? 0 : workPhone.hashCode());*/
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
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (contactLastName == null) {
			if (other.contactLastName != null)
				return false;
		} else if (!contactLastName.equals(other.contactLastName))
			return false;
		if (contactName == null) {
			if (other.contactName != null)
				return false;
		} else if (!contactName.equals(other.contactName))
			return false;
		if (email_1 == null) {
			if (other.email_1 != null)
				return false;
		} else if (!email_1.equals(other.email_1))
			return false;
		if (email_2 == null) {
			if (other.email_2 != null)
				return false;
		} else if (!email_2.equals(other.email_2))
			return false;
		if (homePhone == null) {
			if (other.homePhone != null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		if (mobilePhone == null) {
			if (other.mobilePhone != null)
				return false;
		} else if (!mobilePhone.equals(other.mobilePhone))
			return false;
		if (secAddr == null) {
			if (other.secAddr != null)
				return false;
		} else if (!secAddr.equals(other.secAddr))
			return false;
		if (secHomeAddr == null) {
			if (other.secHomeAddr != null)
				return false;
		} else if (!secHomeAddr.equals(other.secHomeAddr))
			return false;
		if (workPhone == null) {
			if (other.workPhone != null)
				return false;
		} else if (!workPhone.equals(other.workPhone))
			return false;
		return true;
	}



	@Override
	public int compareTo(ContactData other) {
		return this.contactName.toLowerCase().compareToIgnoreCase(other.contactName.toLowerCase());
		
	}
	
	

	
}