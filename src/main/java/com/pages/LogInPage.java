package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogInPage {

	WebDriver driver;
	private By txtUsername = By.xpath("//input[@placeholder='Username']");
	private By txtPassword = By.xpath("//input[@placeholder='Password']");
	private By btnLogin = By.xpath("//button[@type='submit']");
	private By txtForgotPasswordLink = By.xpath("//p[text()='Forgot your password? ']");

	public LogInPage(WebDriver driver) {
		this.driver = driver;
	}

	public String getLoginPageTitle() {
		return driver.getTitle();
	}

	public boolean isForgotPwdLinkExists() {
		return driver.findElement(txtForgotPasswordLink).isDisplayed();
	}

	public void enterUsername(String username) {
		driver.findElement(txtUsername).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(txtPassword).sendKeys(password);
	}

	public void clickLoginButton() {
		driver.findElement(btnLogin).click();
	}

	public boolean validatePageURLAfterLogin(String url) {
		return driver.getCurrentUrl().equals(url);
	}
	public AdminPage doLogin(String username,String password)
	{
		driver.findElement(txtUsername).sendKeys(username);
		driver.findElement(txtPassword).sendKeys(password);
		driver.findElement(btnLogin).click();
		return new AdminPage(driver);
	}
}
