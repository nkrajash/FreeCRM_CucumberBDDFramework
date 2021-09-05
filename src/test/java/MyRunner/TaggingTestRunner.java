package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Annotations
@RunWith(Cucumber.class)
@CucumberOptions(
			features = "E:\\Data\\Selenium-workspace\\FreeCRM_BDDFramework\\src\\main\\java\\Features\\tagging.feature",
			//path of the feature file
			
			glue= {"stepDefinitions5"}, 
			// path of the glue code(stepDefinition,hooks,plugins)
			
			plugin= {"pretty","html:test-output","json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
			//generate different types of reporting
			
			dryRun= false, 
			//to check the mapping is proper between feature file and step def file
			
			monochrome = true,
			//true,if terminal output should be without colours.
			
			//tags = "@SmokeTest or @RegressionTest or @End2EndTest"
			tags= "@RegressionTest"
)
public class TaggingTestRunner {

}

//ORed : tags = "@SmokeTest or @RegressionTest" -- execute all tests tagged as @SmokeTest OR @RegressionTest
//ANDed : tags = "@SmokeTest and @RegressionTest" -- execute all tests tagged as @SmokeTest AND @RegressionTest
//~ : tags = ~@SmokeTest and ~@RegressionTest" -- execute all tests  except those tagged as @SmokeTest AND @RegressionTest
//~ before @ say ~@SmokeTest under tags = "~@SmokeTest" will ignore the Smoke tests.
