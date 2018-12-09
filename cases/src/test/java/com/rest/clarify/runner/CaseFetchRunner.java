package com.rest.clarify.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(features="src/test/resources/feature/"
,glue= {"com/rest/clarify"})
public class CaseFetchRunner extends AbstractTestNGCucumberTests {

}
