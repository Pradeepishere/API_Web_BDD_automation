package Utilities;

import Pages.PageObject_Manager;
import org.openqa.selenium.WebDriver;

public class Test_Context_Setup {

    public WebDriver driver;
    public PageObject_Manager pageObject_manager;
    public WebUtilities utility;

    public Test_Context_Setup()
    {
        utility = new WebUtilities();
        pageObject_manager = new PageObject_Manager( utility.initialize_webDriver());

    }
}
