package Screens;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.swing.*;

public class InformationInCheckoutPage {

    private  SHAFT.GUI.WebDriver  driver;
    Actions action ;

    public InformationInCheckoutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By firstName = new AppiumBy.ByAccessibilityId("test-First Name");
    private By lastName = new AppiumBy.ByAccessibilityId("test-Last Name");
    private By postalCode= new AppiumBy.ByAccessibilityId("test-Zip/Postal Code");
    private By continue_Button = new AppiumBy.ByAccessibilityId("test-CONTINUE");

    public InformationInCheckoutPage typeFirstName(String fname){
        driver.getDriver().findElement(firstName).sendKeys(fname);
        return this;
    }
    public InformationInCheckoutPage typeLastName(String lname){
        driver.getDriver().findElement(lastName).sendKeys(lname);
        return this;
    }

    public InformationInCheckoutPage typePostalCode(String code){
        driver.getDriver().findElement(postalCode).sendKeys(code);
        return this;
    }


    public void scrollDownToContinueButton(){
      driver.element().scrollToElement(continue_Button);
       // action.scrollToElement((WebElement) continue_Button);
    }
    public OverviewCheckoutPage clickOnContinueButton(){
        driver.getDriver().findElement(continue_Button).click();
        return new OverviewCheckoutPage(driver);
    }

}
