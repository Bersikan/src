package com.example.tests;

import org.testng.annotations.Test;

public class GroupModificationTests extends TestBase {
	@Test
	public void modifySomeGroup(){
		app.getNavigationHelper().openMainPage();
		app.getNavigationHelper().openGroupsPage();
		app.getGroupHelper().initGroupModification(1);
		GroupData group = new GroupData();
		group.groupname ="new name"; 
		app.getGroupHelper().feelGroupForm(group);
		app.getGroupHelper().submitGroupModification();
		app.getGroupHelper().returnToGroupPage();
	}

}
