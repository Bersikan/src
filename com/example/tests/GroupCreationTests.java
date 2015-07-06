package com.example.tests;

import org.testng.annotations.Test;

public class GroupCreationTests extends TestBase {
  @Test
  public void NonEmptyGroupCreation() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getNavigationHelper().openGroupsPage();
    app.getGroupHelper().initNewGroupCreation();
    GroupData group = new GroupData();
    group.groupname = "name 1";
    group.footer = "footer 1";
    group.header = "header 1";
	app.getGroupHelper().feelGroupForm(group);
    app.getGroupHelper().submitGroupCreation();
    app.getGroupHelper().returnToGroupPage();
  }
 


@Test
public void EmptyGroupCreation() throws Exception {
		app.getNavigationHelper().openMainPage();
	    app.getNavigationHelper().openGroupsPage();
	    app.getGroupHelper().initNewGroupCreation();
	    app.getGroupHelper().feelGroupForm(new GroupData("", "", ""));
	    app.getGroupHelper().submitGroupCreation();
	    app.getGroupHelper().returnToGroupPage();
	  }



}