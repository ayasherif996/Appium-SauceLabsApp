package Screens;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

      SHAFT.GUI.WebDriver  driver;

    public LoginPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    private By userName = new AppiumBy.ByAccessibilityId("test-Username");
    private By Password = new AppiumBy.ByAccessibilityId("test-Password");

    private  By loginButton = new AppiumBy.ByAccessibilityId("test-LOGIN");
    //By errorMessage = new By.ByXPath("//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView");


    public LoginPage enterUserName(String UserName){
        driver.getDriver().findElement(userName).sendKeys(UserName);
        return this ;
    }
    public LoginPage enterPaaword(String password){
        driver.getDriver().findElement(Password).sendKeys(password);
        return this ;
    }


    public ProductsPage clickOnLoginButton(){
        driver.getDriver().findElement(loginButton).click();
        return new ProductsPage(driver);
    }


//    public void isErrorMessageVisable(){
//        driver.findElement(errorMessage).isDisplayed();
//    }
}
