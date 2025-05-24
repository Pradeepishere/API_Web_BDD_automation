package stepDefinitions;
import io.cucumber.java.After;
import io.restassured.RestAssured;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Pages.home_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import static Utilities.WebUtilities.getlocator;

public class WebStepDefinitions {
	WebDriver driver;
	home_Page homepage;
	
	@Given("launch chrome browser")
	public void launch_browser()
	{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	@When("Navigate to {string}")
	public void navigate_to_URL(String url)
	{
		driver.get(url);
	}
	@Then("Verify that {string} is visible")
	public void verirfy_if_Text_is_Visible(String text)
	{
		System.out.println(text+" icon is Displayed : "+ driver.findElement(By.xpath(getlocator("homeIcon"))).isDisplayed());
		System.out.println("Home icon Text : "+ driver.findElement(By.xpath(getlocator("homeIcon"))).getText());
	}
	@After
	public void close_browser()
	{
		driver.close();
	}
}
