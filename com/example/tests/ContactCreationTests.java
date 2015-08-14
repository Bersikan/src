package com.example.tests;

import static org.testng.Assert.assertEquals;

import java.util.Collections;
import java.util.List;

import org.testng.annotations.Test;

import com.example.utils.SortedListOf;
import static com.example.fw.ContactHelper.CREATION;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;


public class ContactCreationTests extends TestBase {



  @Test (dataProvider ="randomValidContactGenerator")
  public void testContactCreationWithValidData(ContactData contact) throws Exception {
	
    
    //save old state
  
    SortedListOf<ContactData> oldcList = app.getContactHelper().getContacts();
      
    //actions       
    app.getContactHelper().createContact(contact);
   
    //save new state    
    SortedListOf<ContactData> newcList = app.getContactHelper().getContacts();
    
    //compare states   

    assertThat(newcList, equalTo(oldcList.withAdded(contact)));
  
  }
}
 
  

