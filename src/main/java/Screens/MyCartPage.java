package Screens;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyCartPage {

    private  SHAFT.GUI.WebDriver  driver;
     static String title = "Sauce Labs Backpack";
     static String Price = "$29.99";

    public MyCartPage(SHAFT.GUI.WebDriver driver) {

        this.driver = driver;
    }

    private By titleOfProductInCart =   AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Description\"]/android.widget.TextView[1]");
    private By priceOfproductInCart = AppiumBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Price\"]/android.widget.TextView");
    private By removeButton = new AppiumBy.ByAccessibilityId("test-REMOVE");
    private By checkout_Button = new AppiumBy.ByAccessibilityId("test-CHECKOUT");


    public void  clickOnRemoveButton(){
        driver.getDriver().findElement(removeButton).click();

    }


    public void SrollToCheckoutButton(){
        driver.element().scrollToElement(checkout_Button);
    }
    public InformationInCheckoutPage clickOnCheckoutButton(){
        driver.getDriver().findElement(checkout_Button).click();
        return new InformationInCheckoutPage(driver);
    }
}
