package Screens;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OverviewCheckoutPage {

    private  SHAFT.GUI.WebDriver  driver;
    private By finish_Button = new AppiumBy.ByAccessibilityId("test-FINISH");

    public OverviewCheckoutPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public void scrollToFinishButton(){
        driver.element().scrollToElement(finish_Button);
    }
    public CheckoutCompletetionPage clickOnFinishButton(){
        driver.getDriver().findElement(finish_Button).click();
        return new CheckoutCompletetionPage(driver);
    }

}
