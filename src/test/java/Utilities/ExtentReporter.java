package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ExtentReporter
{
    public static ExtentReports getExtentReport()
    {
        // Create a timestamp for the report file name
        String timestamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        String reportName = "Test-Report-" + timestamp + ".html";
        String path = System.getProperty("user.dir") + File.separator + "reports" + File.separator + reportName;
                                            //  File.separator = \ (backslash)
        // Create the directory if it doesn't exist -->>  by using mkdirs()
        File reportDir = new File(System.getProperty("user.dir") + File.separator + "reports");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }

        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        reporter.config().setReportName("Automation Exercise Test Results");
        reporter.config().setDocumentTitle("Test Automation Report");
        reporter.config().setTheme(Theme.STANDARD);

        ExtentReports extent = new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Tester", "Pradeep"); // Set system info
        extent.setSystemInfo("OS", System.getProperty("Windows 11"));
        extent.setSystemInfo("Java Version", System.getProperty("21"));
        extent.setSystemInfo("Application URL", "https://www.automationexercise.com");

        return extent;
    }

}
