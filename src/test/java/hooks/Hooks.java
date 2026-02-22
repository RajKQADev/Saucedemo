package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;
import utilities.DriverFactory;
import utilities.ExtentManager;

import java.time.Duration;

public class Hooks {

    //WebDriver driver;
    private static ExtentReports extent = ExtentManager.getInstance();
    private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();


    @Before
    public void setup(Scenario scenario) {

        DriverFactory.initDriver();

        DriverFactory.getDriver().manage().window().maximize();

        test.set(extent.createTest(scenario.getName()));
    }

    @After
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            test.get().fail("Scenario Failed");
        } else {
            test.get().pass("Scenario Passed");
        }
        extent.flush();
        DriverFactory.quitDriver();
    }

    public static ExtentTest getTest(){
        return test.get();
    }
}
