package com.example.tests;

import org.testng.annotations.Test;

public class GroupRemovalTest extends TestBase {
	
	@Test
	public void deleteSomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openGroupsPage();
		app.getGroupHelper().deleteGroup(1);
		app.getGroupHelper().returnToGroupPage();
	}

}
