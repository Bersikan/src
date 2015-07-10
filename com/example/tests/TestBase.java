package com.example.tests;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.example.fw.ApplicationManager;

public class TestBase {
	protected static ApplicationManager app;
	


	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	   
	  }
	@AfterTest
	public void tearDown() throws Exception {
		app.stop();
	   
	  }
	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();		
		for (int i = 0; i<5; i++){
			GroupData group = new GroupData();			
			group.groupname = generateRandomString();
			group.header = generateRandomString();
			group.footer = generateRandomString();
		list.add( new Object[]{group});			
		}
		return list.iterator();
	}
	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();		
		for (int i = 0; i<3; i++){
			ContactData contact = new ContactData();			
			contact.contactName = generateRandomString();
			contact.contactLastName = generateRandomString();
			contact.address = generateRandomString();
			contact.email_1 = generateRandomString();
			//contact.email_2 = generateRandomString();
			contact.homePhone = generateRandomString();
			contact.secAddr = generateRandomString();
			contact.secHomeAddr = generateRandomString();
			//contact.mobilePhone = generateRandomString();
			//contact.workPhone = generateRandomString();
			contact.birthYear = generateRandomYear();
		list.add( new Object[]{contact});			
		}
		return list.iterator();
	}
	
	public String generateRandomString(){
		Random rnd = new Random();			
			if (rnd.nextInt(3)== 0) {
				return "";
			} else {
				return "test" + rnd.nextInt();
			}
	}
	public String generateRandomYear(){					
		int t =((int) (Math.random()*9999+1));
		String a = Integer.toString(t);		
		return a;
	}

}
