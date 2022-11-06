package com.trycloud.step_definitions;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FailLogin_StepDef {

    LoginPage loginPage = new LoginPage();

    @When("user enter invalid {string} and {string}")
    public void user_enter_invalid_and(String username, String password) {

        loginPage.login(username, password);

    }
    @Then("verify {string} message should be displayed")
    public void verify_message_should_be_displayed(String string) {

        String expectedMessage = "Wrong username or password";
        String actualMessage = Driver.getDriver().findElement(By.xpath("//p[@class ='warning wrongPasswordMsg']")).getText();
        Assert.assertEquals(expectedMessage, actualMessage);

    }
}
