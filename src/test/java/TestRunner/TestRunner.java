package TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "src/test/java/Features/Pizzahut.feature" },
glue = { "StepDefinition" }, 
tags = "@Smoke")

public class TestRunner {

}
