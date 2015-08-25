package com.example.fw;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.example.tests.GroupData;
import com.example.utils.SortedListOf;

public class GroupHelper extends HelperBase {

	public GroupHelper(ApplicationManager manager) {
		super(manager);
	}

	public GroupHelper initNewGroupCreation() {
		manager.navigateTo().groupsPage();
		click(By.name("new"));
		return this;
	}

	public GroupHelper feelGroupForm(GroupData group) {
		type(By.name("group_name"), group.getGroupname());
		type(By.name("group_header"), group.getHeader());
		type(By.name("group_footer"), group.getFooter());
		return this;
	}

	public GroupHelper returnToGroupPage() {
		click(By.linkText("group page"));
		return this;
	}

	private GroupHelper selectGroupByIndex(int index) {
		click(By.xpath("//input[@name='selected[]'][" + (index+1) + "]"));
		return this;
	}

	public GroupHelper initGroupModification(int index) {
		selectGroupByIndex(index);
		click(By.name("edit"));
		return this;
	}

	public GroupHelper submitGroupCreation() {
		click(By.name("submit"));

		return this;
	}

	public GroupHelper submitGroupModification() {
		click(By.name("update"));

		return this;
	}

	private void submitGroupDeletion() {
		click(By.name("delete"));

	}

	private SortedListOf<GroupData>	cashedGroups;

	public SortedListOf<GroupData> getGroups() {
		if (cashedGroups == null) {
			rebuildCahe();
		}
		return cashedGroups;
	}

	private void rebuildCahe() {
		manager.navigateTo().groupsPage();
		cashedGroups = new SortedListOf<GroupData>();
		List<WebElement> checkboxes = driver.findElements(By.name("selected[]"));
		for (WebElement checkbox : checkboxes) {
			String title = checkbox.getAttribute("title");
			String groupname = title.substring("select (".length(), title.length() - ")".length());
			cashedGroups.add(new GroupData().withGroupName(groupname));
		}
	}

	public GroupHelper createGroup(GroupData group) {
		manager.navigateTo().groupsPage();
		initNewGroupCreation();
		feelGroupForm(group);
		submitGroupCreation();
		returnToGroupPage();
		rebuildCahe();
		return this;
	}

	public GroupHelper modifyGroup(int index, GroupData group) {
		manager.navigateTo().groupsPage();
		initGroupModification(index);
		feelGroupForm(group);
		submitGroupModification();
		returnToGroupPage();
		rebuildCahe();
		return this;
	}

	public GroupHelper deleteGroup(int index) {
		manager.navigateTo().groupsPage();
		selectGroupByIndex(index);
		submitGroupDeletion();
		returnToGroupPage();
		rebuildCahe();
		return this;
	}

}