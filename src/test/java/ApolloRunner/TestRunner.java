package ApolloRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features="resources\\Features",glue="ApolloStepDefinition",
tags="@Services1",
//tags="@Share")
//tags="@Appointments")
//tags="@ProHealth")
//tags="@Invalid")
//tags="@Search")
plugin= {("pretty"),
		"html:target/HTMLReports/Apollo.html", 
		"json:target/JSONReports/Apollo.json",
		"junit:target/JUNITReports/Apollo.xml",
		"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
})
public class TestRunner extends AbstractTestNGCucumberTests {

}
