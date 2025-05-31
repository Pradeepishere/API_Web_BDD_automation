package TestRunner.Web;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//import org.junit.runner.RunWith;
//@RunWith(Cucumber.class)

@CucumberOptions( features = "src/test/java/resources/Web/features",
					glue= "stepDefinitions",
					//tags = "@login",		//"@registeruser or @existinguser",
					plugin = {	"pretty",
								"html:target/cucumber-reports/cucumber-html-report.html"},
		 					// { "pretty", "json:target/cucumber-reports/Cucumber.json" },
							//	"junit:target/cucumber-reports/Cucumber.xml"
					monochrome = true
					//dryRun = true

		// mvn clean test -Dcucumber.options = "--tags @login"
				)

public class RunnerFile extends AbstractTestNGCucumberTests
{
	
}
