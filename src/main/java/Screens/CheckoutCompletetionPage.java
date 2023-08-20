package Screens;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletetionPage {

    private     SHAFT.GUI.WebDriver  driver;
    private By backHome_button =new AppiumBy.ByAccessibilityId("test-BACK HOME");

    public CheckoutCompletetionPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }


    public void  validateSuccessPurchase(){
        driver.assertThat().element(backHome_button).
                exists().perform();
    }

}
