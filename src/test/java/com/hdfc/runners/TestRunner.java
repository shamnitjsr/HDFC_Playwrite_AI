package com.hdfc.runners;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.testng.annotations.DataProvider;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = "src/test/resources/features/Login.feature",
				glue = {
				        "com.hdfc.stepdefs",
				        "com.hdfc.config"
				    },
		
		 plugin = {
	                "pretty",
	                "html:target/cucumber-report.html",
	                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
	        },
	        monochrome=true,
	        dryRun = false,
	        publish = true
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	
	@DataProvider(parallel = true)
	public Object[][] scenarios(){
		return super.scenarios();
	}
	
	
	

}
