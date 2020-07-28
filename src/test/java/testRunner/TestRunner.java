package testRunner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;


@CucumberOptions(
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        features = {"src/test/java/features/"} ,
        glue = "stepDefinitions",
        strict = true
)

public class TestRunner extends AbstractTestNGCucumberTests{

}

