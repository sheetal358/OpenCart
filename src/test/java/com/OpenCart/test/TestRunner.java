package com.OpenCart.test;

import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
//junit
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/com.OpenCart.Feature", glue =
{"com.OpenCart.StepDefinition"}, plugin = {"pretty",
"html:target/html-report", "json:target/json/json-report.json",
"junit: target/junit/junit-report.xml" }, monochrome = true, strict = true )
public class TestRunner { }
