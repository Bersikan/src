package com.example.fw;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ApplicationManager {
	public  WebDriver driver;
	public  String baseUrl;		
	private NavigationHelper navigationhelper;
	private GroupHelper grouphelper;
	private ContactHelper contacthelper ;
	public ApplicationManager(){
		 driver = new FirefoxDriver();
		 baseUrl = "http://localhost/";
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	public void stop() {
		 driver.quit();
	}
public NavigationHelper getNavigationHelper(){
	if (navigationhelper == null) {
		navigationhelper = new NavigationHelper(this);		
	}
	return navigationhelper;
}
public GroupHelper getGroupHelper(){
	if (grouphelper == null) {
		grouphelper = new GroupHelper(this);		
	}
	return grouphelper;
}
public ContactHelper getContactHelper(){
	if (contacthelper == null) {
		contacthelper = new ContactHelper(this);		
	}
	return contacthelper;
 }
}
