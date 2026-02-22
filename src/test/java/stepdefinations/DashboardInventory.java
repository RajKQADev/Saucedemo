package stepdefinations;

import hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.CheckoutPage;
import pages.DashboardInventoryPage;
import pages.OrderConfirmationPage;
import utilities.ConfigReader;
import utilities.DriverFactory;

import java.io.IOException;

public class DashboardInventory {

    DashboardInventoryPage dashboardInventoryPage;
    ConfigReader configReader;
    CheckoutPage checkoutPage;
    OrderConfirmationPage orderConfirmationPage;
    WebDriver driver;

    public DashboardInventory() throws IOException{
        driver = DriverFactory.getDriver();
        configReader = new ConfigReader();
        dashboardInventoryPage = new DashboardInventoryPage(driver);
        checkoutPage = new CheckoutPage(driver);
        orderConfirmationPage = new OrderConfirmationPage(driver);
        Hooks.getTest().info("Dashboard Inventory Initialized");
    }

    @When("User select product")
    public void user_select_product() throws IOException {
        String act_product = dashboardInventoryPage.inventory_item_name();
        //System.out.println("Product Name: " + act_product);
        String exp_product = configReader.getProperty("product");
        //System.out.println("product: " + exp_product);
        Assert.assertEquals(exp_product, act_product );
        Hooks.getTest().info("User selected product");
    }

    @And("User clicks on Add to Cart button")
    public void user_clicks_on_add_to_cart_button() throws IOException {
        String value = dashboardInventoryPage.inventory_item_price_and_add_to_cart();
        Double price = Double.parseDouble(value.replace("$",""));
        //System.out.println(value+" "+price);
        Hooks.getTest().info("user clicks on Add to cart button");
    }
    String act_url = "";
    @And("User clicks on cart icon")
    public void user_clicks_on_cart_icon() throws IOException {
        act_url = dashboardInventoryPage.cart_verify_cart_url();
        Hooks.getTest().info("User clicks on cart icon");
    }

    @Then("Verify cart page URL contains")
    public void verify_cart_page_url() throws IOException {
        String exp_url = configReader.getProperty("cart_url");
        Assert.assertEquals(exp_url, act_url);
        Hooks.getTest().pass("Verify cart page URL contains");
    }

    @When("User clicks on checkout button and filled all the details")
    public void verify_checkout_button_and_filled_all_the_details() throws IOException {
        checkoutPage.fillDetails();
        Hooks.getTest().info("User clicks on checkout button and filled all the details");
    }

    @Then("User should see order confirmation message")
    public void user_should_see_order_confirmation_message() throws IOException{
        checkoutPage.finishbtn();
        String act_value = orderConfirmationPage.order_confirmation();
        String exp_value = configReader.getProperty("order_confirmation");
        Assert.assertEquals(exp_value,act_value);
        Hooks.getTest().pass("User should see order confirmation message");
    }

}
