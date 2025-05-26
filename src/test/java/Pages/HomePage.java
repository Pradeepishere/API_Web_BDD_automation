package Pages;

import org.openqa.selenium.WebDriver;

import Utilities.WebUtilities;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class HomePage extends WebUtilities{
	WebDriver driver;
    @FindBy(xpath = "//a[normalize-space()='Home']")
    WebElement homeIcon;
    @FindBy(xpath = "//a[starts-with(normalize-space(),'Logged in as')]")
    WebElement loggedinas;
    @FindBy(xpath = "//a[.=' Delete Account']")
    WebElement deleteaccount;

    public HomePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void launch_max_browser()
    {
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    public void go_to_URL(String url)
    {
        driver.get(url);
    }
	public void homePage_visible()
    {
        System.out.println("Home icon is Displayed : "+ homeIcon.isDisplayed());

        Assert.assertTrue(driver.getTitle().contains("Automation Exercise"), "Home page title is as expected");
        explicitwait().until(ExpectedConditions.visibilityOf(homeIcon));

        System.out.println("Home icon Text : "+ homeIcon.getText());
    }
    //  *********************************

    public void LoggedInAs_UserName_visible()
    {
        System.out.println("Logged in as User is Displayed : "+ loggedinas.isDisplayed());
        System.out.println("Logged in as User Text : "+ loggedinas.getText());
    }
    public void delete_Account()
    {
        deleteaccount.click();
    }

    public void close_browser()
    {
        driver.quit();
    }
}
