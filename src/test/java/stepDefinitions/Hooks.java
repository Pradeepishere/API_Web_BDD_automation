package stepDefinitions;

import Pages.HomePage;
import Utilities.ExtentReporter;
import Utilities.Test_Context_Setup;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Hooks {

    public Test_Context_Setup tcs;
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();
    public final Logger log = LogManager.getLogger(Hooks.class);

    public Hooks(Test_Context_Setup testContextSetup)
    {
        this.tcs = testContextSetup;
    }
    @Before(order = 0)                  // Ensure this runs first       befor All scenarios
    public void beforeAll() {
        if (extent == null) {
            extent = ExtentReporter.getExtentReport();
            log.info("ExtentReports initialized.");
        }
    }
    @Before(order = 1)        // Runs before each scenario. Initializes WebDriver and creates new test  ExtentReports
    public void beforeScenario(Scenario scenario)               // Runs after beforeAll
    {
        log.info("Starting scenario: " + scenario.getName());
        tcs.getDriver();                    // Initialize WebDriver
        ExtentTest test = extent.createTest(scenario.getName());
        extentTest.set(test);
        log.info("Extent Test created for scenario: " + scenario.getName());
    }
    @AfterStep
    public void afterStep(Scenario scenario)            // Runs after each step.
    {
        WebDriver driver = tcs.getDriver();
        if (scenario.isFailed())
        {
            log.error("Scenario failed: " + scenario.getName() + ". Taking screenshot.");
            String screenshotName = scenario.getName().replaceAll(" ", "_") + "_" + System.currentTimeMillis();
            byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", screenshotName);
            extentTest.get().fail("Step failed",
                                com.aventstack.extentreports.MediaEntityBuilder.createScreenCaptureFromBase64String(
                    ((TakesScreenshot) driver).getScreenshotAs(OutputType.BASE64)).build());
        } else {
            extentTest.get().log(Status.PASS, "Step passed");
        }
    }
    @After               //  Runs after each scenario.   Quits WebDriver and flushes ExtentReports.
    public void afterScenario(Scenario scenario)
    {
        log.info("Finishing scenario: " + scenario.getName() + " with status: " + scenario.getStatus() );
        if (scenario.isFailed()) {
            extentTest.get().fail("Scenario Failed");
            log.error("Scenario '" + scenario.getName() + "' failed.");
        }
        else
        {
            extentTest.get().pass("Scenario Passed");
            log.info("Scenario '" + scenario.getName() + "' passed.");
        }
        tcs.tearDown();             // Quit WebDriver
        extent.flush();             // Flush reports after each scenario
        log.info("ExtentReports flushed for scenario: " + scenario.getName());
    }


}
