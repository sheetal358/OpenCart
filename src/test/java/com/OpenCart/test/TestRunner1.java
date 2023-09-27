package com.OpenCart.test;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

//testng
@CucumberOptions(features = "src/test/resources/com.OpenCart.Feature",
glue = {"com.OpenCart.StepDefinition" },
monochrome = true, strict = true)

public class TestRunner1 extends AbstractTestNGCucumberTests {
}
