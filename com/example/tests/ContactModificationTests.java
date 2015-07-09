package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactModificationTests extends TestBase {
	@Test(dataProvider ="randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		app.getNavigationHelper().openMainPage();
		
		
		//save old state
	    List<ContactData> oldcList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldcList.size() -1);
	    
		//actions
	    app.getContactHelper().clickEditButtonByIndex(index);
	    app.getContactHelper().fillContactForm(contact);
	    app.getContactHelper().submitUpdate();
	    app.getContactHelper().returnToHomePage();
		
		//save new state
		List<ContactData> newcList = app.getContactHelper().getContacts();
	    
	    //compare states	    
	    oldcList.remove(index);
	    oldcList.add(contact);
	    Collections.sort(oldcList);	 Collections.sort(newcList);	    
	    assertEquals(oldcList, newcList);
	}

}
