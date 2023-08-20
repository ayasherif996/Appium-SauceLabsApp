package Tests;

import Screens.*;
import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Test_MobileActions {
    SHAFT.TestData.JSON TestData , userInformationData;

    SHAFT.GUI.WebDriver  driver;
    ProductsPage product = new ProductsPage(driver);

    @BeforeMethod
    public void setupDevice() {
        SHAFT.Properties.platform.set().executionAddress("localhost:4723");
        SHAFT.Properties.platform.set().targetPlatform("Android");
        SHAFT.Properties.mobile.set().app(SHAFT.Properties.paths.testData()+"Android.SauceLabs.Mobile.Sample.app.2.2.0.apk");
        SHAFT.Properties.mobile.set().deviceName("Demo");
        SHAFT.Properties.mobile.set().platformVersion("14.0");
        SHAFT.Properties.mobile.set().automationName("UiAutomator2");
        driver= new SHAFT.GUI.WebDriver();

    }


    @BeforeClass
    public void initializeJsonFileManager()  {
        TestData =new SHAFT.TestData.JSON("TestData.json");
        userInformationData= new SHAFT.TestData.JSON("UserInformation.json");

    }

    //TC#1 Login with Valid Email and password and validate that login is performed successfully
    @Test
    public void testValidCredentials() {
        new LoginPage(driver).enterUserName(TestData.getTestData("UserName"));
        new LoginPage(driver).enterPaaword(TestData.getTestData("Password"));
        new LoginPage(driver).clickOnLoginButton();
        Assert.assertEquals((driver.getDriver().findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Toggle']/android.widget.ImageView")).getAttribute("enabled")), "true");

    }

    //TC#2 Login with invalid email or password
    @Test
    public void testInValidCredentials() {
        new LoginPage(driver).enterUserName(TestData.getTestData("UserName"));
        new LoginPage(driver).enterPaaword(TestData.getTestData("FakePassword"));
        new LoginPage(driver).clickOnLoginButton();
        Assert.assertEquals(driver.getDriver().findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Error message']/android.widget.TextView")).getText(), "Username and password do not match any user in this service.");
    }


    // TC#3 Add Any Item to the cart and validate that Title and price of the Item at Home page equals the item and price at the cart
    @Test
    public void testAddTocart() {
        testValidCredentials();
        new ProductsPage(driver).addItemToCart();
        new  ProductsPage(driver).validateOnTitleAndPice();
        new ProductsPage(driver).showItemsInShoppingCart();
     // driver.assertThat().IsEqual("");
       // Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Description']/android.widget.TextView[1]")).getText(), "Sauce Labs Backpack");
        //Assert.assertEquals(driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='test-Price']/android.widget.TextView")).getText(),"$29.99");
    }

    // TC#4 Validate Removing Items from the cart and validate that the cart is empty
    @Test
    public void removeAnItem() {
        testAddTocart();
        new MyCartPage(driver).clickOnRemoveButton();
     driver.assertThat().element(AppiumBy.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]")).doesNotExist();

    }

// TC#5 Online Ordering and complete the flow from adding element to cart till the checkout, Also Validate the price and success purchase.
    @Test
    public void completeOrder() {
          testAddTocart();
        new MyCartPage(driver).SrollToCheckoutButton();
        new MyCartPage(driver).clickOnCheckoutButton();
        new InformationInCheckoutPage(driver).typeFirstName(userInformationData.getTestData("FirstName"));
        new InformationInCheckoutPage(driver).typeLastName(userInformationData.getTestData("LastName"));
        new InformationInCheckoutPage(driver).typePostalCode(userInformationData.getTestData("PostalCode"));
        new InformationInCheckoutPage(driver).scrollDownToContinueButton();
        new InformationInCheckoutPage(driver).clickOnContinueButton();
        new OverviewCheckoutPage(driver).scrollToFinishButton();
        new OverviewCheckoutPage(driver).clickOnFinishButton();
        new CheckoutCompletetionPage(driver).validateSuccessPurchase();
   }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
