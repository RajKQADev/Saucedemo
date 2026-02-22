package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class DashboardInventoryPage {

    WebDriver driver;
    public static By swaglabstext = By.cssSelector("div.app_logo");
    public static By inventoryitemName = By.cssSelector("div.inventory_item_name");
    public static By inventoryitemprice = By.xpath("(//div[@class=\"inventory_item_price\"])[1]");
    public static By add_to_cart_btn = By.xpath("(//button[contains(@id,\"add-to-cart\")])[1]");
    public static By cart = By.cssSelector(".shopping_cart_link");

    public void verifytext(String text){
        Assert.assertEquals(driver.findElement(swaglabstext).getText(), text);
    }

    public DashboardInventoryPage(WebDriver driver) {
        this.driver = driver;
    }

    public String inventory_item_name(){
        String value = driver.findElement(inventoryitemName).getText();
        return value;
    }

    public String inventory_item_price_and_add_to_cart(){
        String value = driver.findElement(inventoryitemprice).getText();
        driver.findElement(add_to_cart_btn).click();
        return value;
    }

    public String cart_verify_cart_url(){
        driver.findElement(cart).click();
        String url = driver.getCurrentUrl();
        return url;
    }


}
