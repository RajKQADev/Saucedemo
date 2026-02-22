package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    WebDriver driver;

    public static By username = By.id("user-name");
    public static By password = By.id("password");
    public static By login_btn = By.id("login-button");
    public static By login_error = By.xpath("//h3[contains(text(),\"not match\")]");


    public LoginPage(WebDriver driver)
    {
        this.driver = driver;
    }

    public void setusername(String Username)
    {

        driver.findElement(username).sendKeys(Username);
    }

    public WebElement login_error()
    {
        return driver.findElement(login_error);
    }
    public void setpassword(String Password)
    {
        driver.findElement(password).sendKeys(Password);
    }


    public void setLogin_btn()
    {
        driver.findElement(login_btn).click();
    }
}
