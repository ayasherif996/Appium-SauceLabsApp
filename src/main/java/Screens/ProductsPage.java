package Screens;

import com.shaft.driver.SHAFT;
import io.appium.java_client.AppiumBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage {
    private  SHAFT.GUI.WebDriver  driver;

    public ProductsPage(SHAFT.GUI.WebDriver driver) {
        this.driver = driver;
    }

    //  By itemName = new By.ByXPath("(//android.widget.TextView[@content-desc='test-Item title'])[1]");
 // By itemPrice = new By.ByXPath("//android.widget.TextView[@text='$29.99']");
private By addToCartButton = new By.ByXPath("(//android.view.ViewGroup[@content-desc='test-ADD TO CART']/parent::*/android.view.ViewGroup/android.widget.TextView)[1]");

private By titleOfProduct = new By.ByXPath("(//android.widget.TextView[@content-desc=\"test-Item title\"])[1]");
private By priceOfProduct = new By.ByXPath("(//android.widget.TextView[@content-desc=\"test-Price\"])[1]");
private  By shoppingCart =  new By.ByXPath("//android.view.ViewGroup[@content-desc='test-Cart']/android.view.ViewGroup/android.widget.ImageView");

  public ProductsPage addItemToCart(){
      driver.getDriver().findElement(addToCartButton).click();
      return  this;
  }

  public MyCartPage showItemsInShoppingCart(){
      driver.getDriver().findElement(shoppingCart).click();
      return new MyCartPage(driver);
  }


  public void validateOnTitleAndPice(){
      driver.assertThat().element(titleOfProduct).text().isEqualTo(MyCartPage.title);
      driver.assertThat().element(priceOfProduct).text().isEqualTo(MyCartPage.Price);
  }



}
