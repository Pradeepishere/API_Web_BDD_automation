package TestRunner.Web;


//import io.cucumber.junit.Cucumber;
//import io.cucumber.junit.CucumberOptions;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

//import org.junit.runner.RunWith;
//@RunWith(Cucumber.class)

@CucumberOptions( features = "src/test/java/resources/Web/features",
					glue= "stepDefinitions",
					tags = "@registeruser",		//"@registeruser or @existinguser",
					plugin = {	"pretty",			// Prints Cucumber output to the console
								"html:target/cucumber-reports/cucumber-html-report.html",
								"html:target/cucumber-reports/cucumber-pretty",
								"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
							// { "pretty", "json:target/cucumber-reports/Cucumber.json" },
							//	"junit:target/cucumber-reports/Cucumber.xml"
							},

					monochrome = true			// Makes the console output more readable
					//dryRun = true

			// mvn clean test -Dcucumber.filter.tags="@login"   // for git bash

		//  mvn clean test -Dcucumber.options="--tags @login"
				)

public class RunnerFile extends AbstractTestNGCucumberTests
{
	// 		Provides scenarios as parallelizable data to TestNG.
	// 		running Cucumber scenarios in parallel with TestNG.

//	@Override
//	@DataProvider(parallel = true)
//	public Object[][] scenarios() {
//		return super.scenarios();
//	}
}
