package com.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AdminPage {

	WebDriver driver;

	private By adminSections = By.xpath("//nav[@aria-label='Topbar Menu']//ul//li");
	private By linkAdmin = By.xpath("//span[text()='Admin']");

	public AdminPage(WebDriver driver) {
		this.driver = driver;
	}

	public int getAccountSectionsSize() {
		return driver.findElements(adminSections).size();
	}

	public List<String> getAdminHeaderList() {
		List<String> adminList = new ArrayList<String>();
		List<WebElement> adminHeaderList = driver.findElements(adminSections);
		for (WebElement element : adminHeaderList) {
			String txt = element.getText();
			adminList.add(txt);
		}
		return adminList;
	}

	public void clickAdminTab() {
		driver.findElement(linkAdmin).click();
	}

	public String getAdminTabURL() {
		String adminTabURL = driver.getCurrentUrl();
		return adminTabURL;
	}

}
