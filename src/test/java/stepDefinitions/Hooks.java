package stepDefinitions;

import Pages.HomePage;
import Utilities.Test_Context_Setup;
import io.cucumber.java.After;

public class Hooks {

    Test_Context_Setup testContextSetup;

    public Hooks(Test_Context_Setup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }

  //  @After
    public void close_browser()
    {
        testContextSetup.utility.initialize_webDriver().quit();
    }
}
