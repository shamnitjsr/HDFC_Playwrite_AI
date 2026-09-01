package com.hdfc.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests

@CucumberOptions(
		features = "src/test/java/features/Login.feature",
		glue = {"com.stepDefinitions","com.config"},
		plugin = {"pretty", "html:target/cucumber-reports.html"})

public class TestRunner extends AbstractTestNGCucumberTests{
	
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}

}
