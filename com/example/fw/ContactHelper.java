package com.example.fw;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;

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
		click(By.xpath("//input[@name='selected[]'][@value="+ (index+1) +"]"));
	}
	
	public void deleteContact() {		
		click(By.xpath("//input[@value='Delete']"));
	}

	public void clickEditButtonByIndex(int index) {
		click(By.xpath("(//img[@title='Edit'])["+ (index+1) +"]"));
		
	}

	public void submitUpdate() {
		click(By.xpath("//input[@value='Update']"));
	}


	public List<ContactData> getContacts() {
		List<ContactData> contacts = new ArrayList<ContactData>();
		List<WebElement> contactFields = driver.findElements(By.xpath("//tr[@name='entry']"));
		for (WebElement contactField : contactFields) {
			ContactData contact = new ContactData();
			contact.contactName = contactField.findElement(By.xpath("./td[3]")).getText();
			contact.contactLastName = contactField.findElement(By.xpath("./td[2]")).getText();
			contact.email_1 = contactField.findElement(By.xpath("./td[4]")).getText();
			contact.homePhone = contactField.findElement(By.xpath("./td[5]")).getText();
			contacts.add(contact);
			}
		return contacts;
	}
	



	
	
	
	
	
	
}




