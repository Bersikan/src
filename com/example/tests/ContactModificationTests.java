package com.example.tests;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {


	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().clickEditButtonByIndex(1);
		ContactData contact = new ContactData();
		contact.contactName ="new name"; 
		contact.contactLastName = "new lastName";
		contact.birhDay="17";
		contact.birthMonth="July";
		contact.birthYear="";
		app.getContactHelper().updateContactForm(contact);
		app.getContactHelper().submitUpdate();
		app.getContactHelper().returnToHomePage();
		
	}

}
