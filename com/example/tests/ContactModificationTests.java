package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;
 

public class ContactModificationTests extends TestBase {
	@Test(dataProvider ="randomValidContactGenerator")
	public void modifySomeContact(ContactData contact){
		
		
		
		//save old state
		SortedListOf<ContactData> oldcList = app.getContactHelper().getContacts();
	    
	    Random rnd = new Random();
	    int index = rnd.nextInt(oldcList.size() -1);
	    
		//actions
	    app.getContactHelper().modifyContact(contact, index);
	 
		//save new state
	    SortedListOf<ContactData> newcList = app.getContactHelper().getContacts();
	    
	    //compare states	    
	    assertThat(newcList, equalTo(oldcList.without(index).withAdded(contact)));
	}

}
