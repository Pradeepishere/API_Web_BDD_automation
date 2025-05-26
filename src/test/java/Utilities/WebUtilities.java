package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Map;

public class WebUtilities {
	
	WebDriver driver;
	WebDriverWait wait;

	public WebDriver initialize_webDriver()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		return driver;
	}
	public static String getlocator(String locator)
    {
        return Utilities.load_Resources.load_Locator_Properties(locator);
    }
	public WebDriverWait explicitwait()
	{
		wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		return wait;
	}

	public Map<String, String> access_Excel_Data()
	{
		String filepath = load_Resources.get_Excel_Property_name("filepath");
		String sheetName = load_Resources.get_Excel_Property_name("sheet_Name");
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



}

