package com.example.fw;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ApplicationManager {
	public WebDriver			driver;
	public String				baseUrl;
	private NavigationHelper	navigationhelper;
	private GroupHelper			grouphelper;
	private ContactHelper		contacthelper;
	private Properties	properties;

	public ApplicationManager(Properties properties) {
		this.properties = properties;
		String browser = properties.getProperty("browser");
		if ("firefox".equals(browser)){
			driver = new FirefoxDriver();
		} else if ("ie".equals(browser)){
			driver = new InternetExplorerDriver();
		} else {
			throw new Error("Unsupported browser " +browser);		
			}
		
		baseUrl = properties.getProperty("baseUrl");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseUrl);
	}

	public void stop() {
		driver.quit();
	}

	public NavigationHelper navigateTo() {
		if (navigationhelper == null) {
			navigationhelper = new NavigationHelper(this);
		}
		return navigationhelper;
	}

	public GroupHelper getGroupHelper() {
		if (grouphelper == null) {
			grouphelper = new GroupHelper(this);
		}
		return grouphelper;
	}

	public ContactHelper getContactHelper() {
		if (contacthelper == null) {
			contacthelper = new ContactHelper(this);
		}
		return contacthelper;
	}
}
