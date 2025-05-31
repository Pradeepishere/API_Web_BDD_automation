package Utilities;

import Pages.HomePage;
import Pages.PageObject_Manager;
import io.cucumber.java.Scenario;
import org.openqa.selenium.WebDriver;

public class Test_Context_Setup {

    public WebDriver driver;
    public PageObject_Manager pageObject_manager;
    public WebUtilities utility;

    public Test_Context_Setup()
    {
        utility = new WebUtilities();
        this.driver = utility.initialize_webDriver();
        pageObject_manager = new PageObject_Manager( driver);
    }
    public WebDriver getWebdriver()
    {
        return driver;
    }
    public PageObject_Manager getPageObject_manager()
    {
        return pageObject_manager;
    }

    public void tearDown() {
       // pageObject_manager.home_page.logout();
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }

}
