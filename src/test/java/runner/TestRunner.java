package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;





@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/java/features", glue={"stepDefinition","helper"},tags="@regression", plugin="json:target/jsonReports/testreport.json")
public class TestRunner {


	
}

