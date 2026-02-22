package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ConfigReader;

import java.io.IOException;
import java.time.Duration;

public class CheckoutPage {
    WebDriver driver;
    ConfigReader reader;
    public static By checkout = By.cssSelector("#checkout");
    public static By first_name = By.cssSelector("#first-name");
    public static By last_name = By.cssSelector("#last-name");
    public static By postal_code = By.cssSelector("#postal-code");
    public static By continue_button = By.cssSelector("#continue");
    public static By finish_button = By.cssSelector("#finish");
    WebDriverWait wait;
    public CheckoutPage(WebDriver driver) throws IOException {
        this.driver = driver;
        reader = new ConfigReader();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void fillDetails(){
        driver.findElement(checkout).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(first_name)).sendKeys(reader.getProperty("First_Name"));
        driver.findElement(last_name).sendKeys(reader.getProperty("Last_Name"));
        driver.findElement(postal_code).sendKeys(reader.getProperty("pincode"));
        driver.findElement(continue_button).click();
    }

    public void finishbtn(){
        driver.findElement(finish_button).click();
    }

}
