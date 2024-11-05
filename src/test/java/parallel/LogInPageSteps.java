package parallel;

import org.junit.Assert;

import com.pages.LogInPage;
import com.qa.factory.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LogInPageSteps {

	LogInPage loginPage = new LogInPage(DriverFactory.getDriver());
	private static String loginTitle;

	@Given("user is on logIn page")
	public void user_is_on_logIn_page() {
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	}

	@When("user gets the title of the page")
	public void user_gets_the_title_of_the_page() {
		loginTitle = loginPage.getLoginPageTitle();
		System.out.println("Login Page title: " + loginTitle);
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String expectedTitle) {
		Assert.assertTrue(loginTitle.contains(expectedTitle));
	}

	@Then("forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		boolean isForgotPwdLinkExist = loginPage.isForgotPwdLinkExists();
		Assert.assertTrue(isForgotPwdLinkExist);
	}

	@When("user enters the username {string}")
	public void user_enters_the_username(String userName) {
		loginPage.enterUsername(userName);
	}

	@When("user enters the password {string}")
	public void user_enters_the_password(String Password) {
		loginPage.enterPassword(Password);
	}

	@When("user clicks the Login button")
	public void user_clicks_the_login_button() {
		loginPage.clickLoginButton();
	}

	@Then("page url should be {string}")
	public void page_url_should_be(String string) {
		boolean isUrl = loginPage.validatePageURLAfterLogin(string);
		Assert.assertTrue(isUrl);

	}

}
