package com.example.fw;

import org.openqa.selenium.By;

import com.example.tests.ContactData;

public class ContactHelper extends HelperBase {

	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public void fillContactForm(ContactData contact) {
		type(By.name("firstname"), contact.contactName);
	    type(By.name("lastname"), contact.contactLastName);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.homePhone);
	    type(By.name("mobile"), contact.mobilePhone);
	    type(By.name("work"), contact.workPhone);
	    type(By.name("email"), contact.email_1);
	    type(By.name("email2"), contact.email_2);
	    selectByText(By.name("bday"), contact.birhDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    selectByText(By.name("new_group"), contact.groupAssign);
	    type(By.name("address2"), contact.secAddr);
	    type(By.name("phone2"), contact.secHomeAddr);
	}
	public void updateContactForm(ContactData contact) {
		type(By.name("firstname"), contact.contactName);
	    type(By.name("lastname"), contact.contactLastName);
	    type(By.name("address"), contact.address);
	    type(By.name("home"), contact.homePhone);
	    type(By.name("mobile"), contact.mobilePhone);
	    type(By.name("work"), contact.workPhone);
	    type(By.name("email"), contact.email_1);
	    type(By.name("email2"), contact.email_2);
	    selectByText(By.name("bday"), contact.birhDay);
	    selectByText(By.name("bmonth"), contact.birthMonth);
	    type(By.name("byear"), contact.birthYear);
	    type(By.name("address2"), contact.secAddr);
	    type(By.name("phone2"), contact.secHomeAddr);
	}
	
	

	public void initContactCreation() {
		click(By.linkText("add new"));
	}

	public void submitContact() {
		click(By.name("submit"));
	}

	public void returnToHomePage() {
		click(By.linkText("home page"));
	}

	public void selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][@value="+ index +"]"));
	}
	
	public void deleteContact() {		
		click(By.xpath("//input[@value='Delete']"));
	}

	public void clickEditButtonByIndex(int index) {
		click(By.xpath("(//img[@title='Edit'])["+ index +"]"));
		
	}

	public void submitUpdate() {
		click(By.xpath("//input[@value='Update']"));
	}

}
