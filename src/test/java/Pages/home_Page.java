package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.WebUtilities;

public class home_Page extends WebUtilities{
	WebDriver driver;

    public home_Page(WebDriver driver)
    {
        super(driver);
        this.driver = driver;
    }
	
	public void homePage_visible(WebDriver driver, String text)
    {
        System.out.println(text+" icon is Displayed : "+ driver.findElement(By.xpath(getlocator("homeIcon"))).isDisplayed());
        System.out.println("Home icon Text : "+ driver.findElement(By.xpath(getlocator("homeIcon"))).getText());
    }

}
