package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderConfirmationPage {
    WebDriver driver;

    public static By order_confirmation = By.xpath("//h2[@class=\"complete-header\"]");

    public OrderConfirmationPage(WebDriver driver) {
        this.driver = driver;
    }

    public String order_confirmation(){
        //Thread.sleep(10000);
        return driver.findElement(order_confirmation).getText();
    }
}
