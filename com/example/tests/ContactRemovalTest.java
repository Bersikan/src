package com.example.tests;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import java.util.Random;
import org.testng.annotations.Test;
import com.example.utils.SortedListOf;

public class ContactRemovalTest extends TestBase {

	@Test
	public void deleteSomeContact() {

		// save old state
		SortedListOf<ContactData> oldcList = app.getContactHelper().getContacts();

		Random rnd = new Random();
		int index = rnd.nextInt(oldcList.size() - 1);

		app.getContactHelper().removeContact(index);

		// save new state
		SortedListOf<ContactData> newcList = app.getContactHelper().getContacts();
		// compare states

		assertThat(newcList, equalTo(oldcList.without(index)));
	}

}
