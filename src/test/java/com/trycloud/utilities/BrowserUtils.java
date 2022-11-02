package com.trycloud.utilities;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;


public class BrowserUtils {
//    Methods are static because we do not want to create an object to call those methods. Just want to call the class name.

//    This method is used to pause the code for given seconds.
//    It is a static method we can call with class name.
//    BrowserUtils.sleep(3);
//    @param seconds
    
    public static void sleep(int seconds){
        try {
            Thread.sleep(seconds * 1000);
        }catch(InterruptedException e){
            e.printStackTrace();
            System.out.println("Exception in sleep method.");
        }
    }
    //Method info:
    //• Name: verifyTitle()
    //• Return type: void
    //• Arg1: WebDriver
    //• Arg2: String expectedTitle
    public static void verifyTitle(String expectedTitle){
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals(actualTitle, expectedTitle);
    }
    public static void waitForInvisibilityOf(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 15);
        wait.until(ExpectedConditions.invisibilityOf(element));
    }
//    This method will accept dropDown as a WebElement and return all the options text in a List<String>
//    Return type will be List<String> (List of String)
    public static List<String> dropdownOptionAsString(WebElement dropdownElement){

        Select select = new Select(dropdownElement);// Because Select tag is used on webpage, you have to use Select class

        List<WebElement> actualOptionsAsWebElement = select.getOptions();// List of all ACTUAL months as a WebElement

        List<String> actualOptionsAsString = new ArrayList<>(); // Sets up changing WebElements to String

        for (WebElement each : actualOptionsAsWebElement) { // converts WebElements to String
            actualOptionsAsString.add(each.getText());
        }
        return actualOptionsAsString;
    }

    /**
     * This method will accept a group of radio buttons as a List<WebElement>
     * it will loop through the list and click the ra
     * @param radioButton
     * @param attributeValue
     */
    public static void clickRadioButton(List<WebElement> radioButton ,String attributeValue){

        for (WebElement each : radioButton){
            if (each.getAttribute("value").equalsIgnoreCase(attributeValue)){
                each.click();
            }
        }
    }
}
