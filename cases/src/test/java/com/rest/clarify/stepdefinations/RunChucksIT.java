package com.rest.clarify.stepdefinations;

import org.junit.runner.RunWith;

import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features={"src/test/resources/features"}, tags={"@Test"})
public class RunChucksIT {

}
