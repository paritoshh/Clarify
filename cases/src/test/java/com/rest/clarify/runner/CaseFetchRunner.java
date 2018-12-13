package com.rest.clarify.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features= {"src/test/resources/feature"},tags= {"@tag1"}, glue= {""})
public class CaseFetchRunner  {

}
