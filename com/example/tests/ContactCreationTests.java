package com.example.tests;

import org.testng.annotations.Test;



public class ContactCreationTests extends TestBase {


 

  @Test
  public void NonEmptyContactAdd() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
    ContactData contact = new ContactData();
	contact.contactName = "cName";
	contact.contactLastName ="cLName";
	contact.address = "cAddress";
	contact.homePhone = "hPhone";
	contact.mobilePhone ="mPhone";
	contact.workPhone="wPfone";
	contact.email_1="eM1";
	contact.email_2="eM2";
	contact.birhDay="17";
	contact.birthMonth="July";
	contact.birthYear="1988";
	contact.groupAssign = "name 1";
	contact.secAddr="sAddr";
	contact.secHomeAddr="sHAddr";
	app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContact();
    app.getContactHelper().returnToHomePage();
  }
  @Test
  public void EmptyContactAdd() throws Exception {
	app.getNavigationHelper().openMainPage();
    app.getContactHelper().initContactCreation();
	new ContactData("", "", "", "", "", "", "", "", "-", "-", "", "", "", "");
    app.getContactHelper().submitContact();
    app.getContactHelper().returnToHomePage();
  }

 
  
}
