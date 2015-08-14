package com.example.fw;

import static com.example.fw.ContactHelper.CREATION;
import static com.example.fw.ContactHelper.MODIFICATION;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.ContactData;
import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class ContactHelper extends HelperBase {
	
	public static boolean CREATION = true;
	public static boolean MODIFICATION = false;
	
	public ContactHelper(ApplicationManager manager) {
		super(manager);
	}

	public ContactHelper fillContactForm(ContactData contact, boolean formType) {
		type(By.name("firstname"), contact.getContactName());
	    type(By.name("lastname"), contact.getContactLastName());
	    type(By.name("address"), contact.getAddress());
	    type(By.name("home"), contact.getHomePhone());
	    type(By.name("mobile"), contact.getMobilePhone());
	    type(By.name("work"), contact.getWorkPhone());
	    type(By.name("email"), contact.getEmail_1());
	    type(By.name("email2"), contact.getEmail_2());
	    selectByText(By.name("bday"), contact.getBirhDay());
	    selectByText(By.name("bmonth"), contact.getBirthMonth());
	    type(By.name("byear"), contact.getBirthYear());	    
	    if (formType ==CREATION){
	    	//selectByText(By.name("new_group"), "group 1")
	    }else{
	    	if (driver.findElements(By.name("new_group")).size() !=0) {
	    		throw new Error("Grpoup selector exists on cont. mod. form");
	    	}
	    }
	    type(By.name("address2"), contact.getSecAddr());
	    type(By.name("phone2"), contact.getSecHomeAddr());
		return this;
	}
	
	
	public ContactHelper initContactCreation() {
		manager.navigateTo().mainPage();
		click(By.linkText("add new"));
		return this; 
	}

	public ContactHelper submitContact() {
		click(By.name("submit"));
		return this; 
	}

	public ContactHelper returnToHomePage() {
		click(By.linkText("home page"));
		return this; 
	}

	public ContactHelper selectContactByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][@value="+ (index+1) +"]"));
		return this; 
	}
	
	public ContactHelper deleteContact() {		
		click(By.xpath("//input[@value='Delete']"));
		cashedContacts = null;
		return this; 
	}

	public ContactHelper clickEditButtonByIndex(int index) {
		click(By.xpath("(//img[@title='Edit'])["+ (index+1) +"]"));
		return this; 
		
	}

	public ContactHelper submitUpdate() {
		click(By.xpath("//input[@value='Update']"));
		cashedContacts = null;
		return this; 
	}

	private SortedListOf<ContactData> cashedContacts;
	
	public SortedListOf<ContactData> getContacts() {
		if(cashedContacts == null){
			rebuildCahe();
		}
	return cashedContacts;
}
	
private void rebuildCahe() {
	SortedListOf<ContactData> cashedContacts = new SortedListOf<ContactData>();
	manager.navigateTo().mainPage();
	List<WebElement> contactFields = driver.findElements(By.xpath("//tr[@name='entry']"));
	for (WebElement contactField : contactFields) {
		String contactName = contactField.findElement(By.xpath("./td[3]")).getText();			
		String contactLastName = contactField.findElement(By.xpath("./td[2]")).getText();			
 		String email_1 = contactField.findElement(By.xpath("./td[4]")).getText();     		
		String homePhone = contactField.findElement(By.xpath("./td[5]")).getText();				
		cashedContacts.add(new ContactData().withContactName(contactName).withContactLastName(contactLastName).withEmail_1(email_1).withHomePhone(homePhone));	
		
			}	
	}		
	
	public ContactHelper createContact(ContactData contact) {
		manager.navigateTo().mainPage();
		initContactCreation();
		fillContactForm(contact, CREATION);
		submitContact();
		rebuildCahe();
		return this;		    	 	
	}

	public ContactHelper removeContact(int index) {
		manager.navigateTo().mainPage();
		clickEditButtonByIndex(index);	
		deleteContact();
		returnToHomePage();
		rebuildCahe();
		return this;		
	}

	public ContactHelper modifyContact(ContactData contact, int index) {
		manager.navigateTo().mainPage();   
		clickEditButtonByIndex(index);
		   fillContactForm(contact, MODIFICATION);
		   submitUpdate();
		   returnToHomePage();
		   rebuildCahe();
		   return this;
			
		
	}
	
	

	



	
	
	
	
	
	
}




