package com.trycloud.step_definitions;

import com.trycloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

//    @Before(order = 1) // from Cucumber
    public void setUpScenario(){
        System.out.println("Setting up browser using Cucumber @Before each scenario");
        Driver.getDriver().get("URL of your app");
    }
//    @Before(order = 2, value = "@login")
    public void setUpForLogin(){
//        If you want any code to run specific feature/scenario
//        You can use value = "@tagname" to determine this.
        System.out.println("Setting up browser using Cucumber @Before each scenario");
    }
//    @Before(order = 3, value = "@db")
        public void setUpDatabaseScenario(){
    }
    //@BeforeStep
    public void setupScenarioStep(){
        System.out.println("Setting up browser using cucumber @Before each scenario step");
    }

    // @BeforeStep
    public void setupScenarioStepForLogin(){
        System.out.println("Setting up browser using cucumber @Before each scenario step for login");
    }
    @After // from Cucumber
    public void tearDownScenario(Scenario scenario){ // import Scenario from cucumber.java
//        We will implement taking screenshot in this method
//        System.out.println("Used to close browser using Cucumber @After each scenario");

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }

        Driver.closeDriver();
    }


}
