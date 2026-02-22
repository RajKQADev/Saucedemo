package stepdefinations;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.DashboardInventoryPage;
import pages.LoginPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.io.IOException;

public class LoginSteps {
    WebDriver driver;
    LoginPage loginpage;
    DashboardInventoryPage dashboardinventorypage;
    ConfigReader configreader;

    @Given("User launches saucedemo website")
    public void launchBrowser() throws IOException {

        driver = DriverFactory.getDriver();

        driver.get("https://www.saucedemo.com/");
        Hooks.getTest().info("Saucedemo has been launched");
        loginpage = new LoginPage(driver);
        dashboardinventorypage = new DashboardInventoryPage(driver);
        configreader = new ConfigReader();
    }

    @When("User enters username {string} and password {string}")
    public void login(String username,String password)
    {
        loginpage.setusername(username);
        loginpage.setpassword(password);
        Hooks.getTest().info("Entered username and password");
    }

    @And("User clicks on login button")
    public void clickonloginbutton() throws InterruptedException
    {
        loginpage.setLogin_btn();
        Hooks.getTest().info("User clicks on login button");
    }

    @Then("User should see login error message")
    public void verifyLoginError()
    {
        Assert.assertTrue(driver.findElements(LoginPage.login_error).size() > 0);
        Hooks.getTest().pass("User should see login error message");
    }


    @Then("User should land on dashboard page")
    public void loginSuccessfully()
    {
        System.out.println("Login successfully");
        Hooks.getTest().pass("User should land on dashboard page");
    }

    @And("Verify dashboard title")
    public void verifyDashboardTitle() throws IOException
    {
        dashboardinventorypage.verifytext(configreader.getProperty("title"));
        Hooks.getTest().info("Verified Dashboard Title");
    }
}
