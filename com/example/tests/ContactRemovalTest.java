package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeContact(){
		app.getNavigationHelper().openMainPage();

		 //save old state
		List<ContactData> oldcList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldcList.size() -1);
	    
		app.getContactHelper().clickEditButtonByIndex(index);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
		//save new state
		List<ContactData> newcList = app.getContactHelper().getContacts();
	    //compare states
	    
	    oldcList.remove(index);
	    Collections.sort(oldcList);
	    Collections.sort(newcList);
	    assertEquals(newcList, oldcList);
	}

}
