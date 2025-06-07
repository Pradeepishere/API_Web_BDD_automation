package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class WebUtilities {
	
	WebDriver driver;
	WebDriverWait wait;

	public WebDriver initialize_webDriver()
	{
		if (driver == null)
		{
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			Log.info("Starting Browser");
		}
		return driver;
	}

	public static String getlocator(String locator)
    {
        return Utilities.load_Resources.load_Locator_Properties(locator);
    }
	public WebDriverWait explicitwait()
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait;
	}

	public JavascriptExecutor javaScriptExec(WebDriver driver)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		return js;
	}
	public Actions actionsMeth(WebDriver driver)
	{
		Actions action =  new Actions(driver);
		return action;
	}


	public Map<String, String> access_Excel_Data()
	{
		String filepath = load_Resources.get_Property_name("filepath");
		String sheetName = load_Resources.get_Property_name("sheet_Name");
		System.out.println(filepath +" ,,, " + sheetName );

        List<Map<String ,String>> testData = null;

        try {
            testData = Excel_read_data.getTestData(filepath,sheetName);
        }
		catch (IOException e) {
            throw new RuntimeException(e);
        }
        Map<String,String> rowdata = testData.get(0);
		return rowdata;
	}

	public void screenShot_Capture(WebDriver driver, String name)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot) driver;
			File sorceFile = ts.getScreenshotAs(OutputType.FILE);
			System.out.println(System.getProperty("user.dir")+"/ScreenShot/"+ name +".png");
			String destination_file_path = (System.getProperty("user.dir")+"/ScreenShot/"+ name +".png");
			File desFile = new File(destination_file_path);

			FileUtils.copyFile(sorceFile,desFile);
		}
		catch (IOException e) {
			System.err.println("Failed to save screenshot: " + e.getMessage());
		}
	}

}

