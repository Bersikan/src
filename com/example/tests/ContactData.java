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
				+ contactLastName + ", homePhone=" + homePhone + ", email="
				+ email_1 + "]";
	}	
	@Override
	 public int compareTo(ContactData other) {
	  if (this.contactLastName.toLowerCase().equals(other.contactLastName.toLowerCase())) {
	   if (this.contactName.toLowerCase().equals(other.contactName.toLowerCase())) {
	    if (this.email_1.toLowerCase().equals(other.email_1.toLowerCase())) {	      
	      return this.homePhone.toLowerCase().compareTo(other.homePhone.toLowerCase());	    	     
	    } else {
	     return this.email_1.toLowerCase().compareTo(other.email_1.toLowerCase());
	    }
	    
	   } else {
	    return this.contactName.toLowerCase().compareTo(other.contactName.toLowerCase());
	   }
	  } else {
	   return this.contactLastName.toLowerCase().compareTo(other.contactLastName.toLowerCase());
	  }
	 }

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
//		result = prime * result
//				+ ((contactLastName == null) ? 0 : contactLastName.hashCode());
//		result = prime * result
//				+ ((contactName == null) ? 0 : contactName.hashCode());
//		result = prime * result + ((email_2 == null) ? 0 : email_2.hashCode());
//		result = prime * result
//				+ ((mobilePhone == null) ? 0 : mobilePhone.hashCode());
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
		if (homePhone == null) {
			if (other.homePhone!= null)
				return false;
		} else if (!homePhone.equals(other.homePhone))
			return false;
		return true;
	}
	

	
}