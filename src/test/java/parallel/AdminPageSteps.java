package parallel;

import java.util.List;
import java.util.Map;

import org.testng.Assert;

import com.pages.AdminPage;
import com.pages.LogInPage;
import com.qa.factory.DriverFactory;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AdminPageSteps {
	LogInPage loginPage = new LogInPage(DriverFactory.getDriver());
	AdminPage adminPage = new AdminPage(DriverFactory.getDriver());
	private static String adminTabURL;

	@Given("user has already logged in to the application")
	public void user_has_already_logged_in_to_the_application(DataTable dataTable) {
		List<Map<String, String>> credList = dataTable.asMaps();
		String username = credList.get(0).get("username");
		String password = credList.get(0).get("password");
		DriverFactory.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		adminPage = loginPage.doLogin(username, password);
	}

	@Given("user is on Admin page")
	public void user_is_on_admin_page() {
		adminPage.clickAdminTab();

	}

	@When("user gets the URL of the page")
	public void user_gets_the_url_of_the_page() {
		adminTabURL = adminPage.getAdminTabURL();
	}

	@Then("URL should be {string}")
	public void url_should_be(String adminTabUrl) {
		Assert.assertTrue(adminTabUrl.contains(adminTabURL));
	}

	@Then("user gets the Admin sections")
	public void user_gets_the_admin_sections(DataTable dataTable) {
		List<String> expectedAdminSections = dataTable.asList();
		List<String> actualAdminSections = adminPage.getAdminHeaderList();
		Assert.assertEquals(actualAdminSections, expectedAdminSections);
	}

	@Then("Admin sections count should be {int}")
	public void admin_sections_count_should_be(int adminHeaderSize) {
		Assert.assertEquals(adminHeaderSize, adminPage.getAccountSectionsSize());
	}
}
