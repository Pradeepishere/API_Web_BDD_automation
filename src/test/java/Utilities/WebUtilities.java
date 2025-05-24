package Utilities;

import org.openqa.selenium.WebDriver;

public class WebUtilities {
	
	WebDriver driver;
	public WebUtilities(WebDriver driver)
	{
		this.driver = driver;
	}

	public static String getlocator(String locator)
    {
        return Utilities.load_Resources.load_Properties(locator);
    }

	/*public void launch_different_Browsers(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{

		}
	}*/
}

