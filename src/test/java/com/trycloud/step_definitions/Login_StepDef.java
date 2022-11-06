package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigurationReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Login_StepDef {

    LoginPage loginPage = new LoginPage();

    @Given("user on the login page of Trycloud")
    public void user_on_the_login_page_of_trycloud() {

        Driver.getDriver().get(ConfigurationReader.getProperty("env"));
    }
    @When("user use username {string} and passcode {string}")
    public void userUseUsernameAndPasscode(String username, String password) {

        loginPage.login(username, password);
    }
    @Then("verify the user should be at the dashboard page")
    public void verify_the_user_should_be_at_the_dashboard_page() {

        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Dashboard - Trycloud QA";

        Assert.assertEquals(expectedTitle, actualTitle);

    }

}
