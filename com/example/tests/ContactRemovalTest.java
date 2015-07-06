package com.example.tests;

import org.testng.annotations.Test;

public class ContactRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getContactHelper().clickEditButtonByIndex(12);
		app.getContactHelper().deleteContact();
		app.getContactHelper().returnToHomePage();
	}

}
