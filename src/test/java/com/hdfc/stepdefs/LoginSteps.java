package com.hdfc.stepdefs;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.Assert;

import com.hdfc.config.PlaywrightConfig;
import com.hdfc.pages.LoginPage;
import com.microsoft.playwright.Page;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	@Autowired
	private LoginPage loginPage;

	@Autowired
	private Page page;

	@Given("User navigates to login page {string}")
	public void user_navigates_to_login_page(String url) {
		loginPage.navigateTo(url);
	}

	@When("User enters valid {string} and {string}")
	public void user_enters_valid_and(String username, String password) {
		loginPage.login(username, password);
	}

	@Then("User should be redirected to the dashboard page")
	public void user_should_be_redirected_to_the_dashboard_page() {
		Assert.assertTrue(page.url().contains("dashboard"));
	}

	@After
	public void tearDown() {
		PlaywrightConfig.closeBrowser();
	}

}
