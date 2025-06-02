package Utilities;

import Pages.HomePage;
import Pages.PageObject_Manager;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Test_Context_Setup {

    public WebDriver driver;
    //public PageObject_Manager pageObject_manager;
    //public WebUtilities utility;
    private final Logger log = LogManager.getLogger(Test_Context_Setup.class);

//    public Test_Context_Setup()
//    {
//        utility = new WebUtilities();
//        this.driver = utility.initialize_webDriver();
//        pageObject_manager = new PageObject_Manager( driver);
//    }
    public WebDriver getDriver()
    {
        if (driver == null) {
            String browserName = load_Resources.get_Property_name("browserName").toLowerCase();
            System.out.println("browser : " + browserName );
            Log.debug("Initializing WebDriver for browser: " + browserName);

            switch (browserName) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "edge":
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver();
                    break;
                default:
                    Log.error("Invalid browser specified in config.properties: " + browserName);
                    throw new IllegalArgumentException("Invalid browser: " + browserName);
            }

//            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(properties.getProperty("implicitWait"))));
//            driver.manage().window().maximize();
            Log.info("WebDriver initialized successfully.");
        }
        return driver;
    }

    public WebDriver getWebdriver()
    {
        return driver;
    }
//    public PageObject_Manager getPageObject_manager()
//    {
//        return pageObject_manager;
//    }

    public void tearDown() {
       // pageObject_manager.home_page.logout();
        if (driver != null) {
            driver.quit();
            driver = null;
            Log.info("WebDriver quit successfully.");
        }
    }

}
