package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;



public class ContactCreationTests extends TestBase {



  @Test (dataProvider ="randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	 app.getNavigationHelper().openMainPage();
    
    //save old state
  
    List<ContactData> oldcList = app.getContactHelper().getContacts();
      
    //actions   
	
    app.getContactHelper().initContactCreation();
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContact();
    app.getContactHelper().returnToHomePage();
    
    //save new state
    
    List<ContactData> newcList = app.getContactHelper().getContacts();
    
    //compare states   
    oldcList.add(contact);
    Collections.sort(oldcList);
    //Collections.sort(newcList);
    assertEquals(newcList, oldcList);
  
  }
}
 
  

