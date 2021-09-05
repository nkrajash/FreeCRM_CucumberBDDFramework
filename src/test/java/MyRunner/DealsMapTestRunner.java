package MyRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

//Annotations
@RunWith(Cucumber.class)
@CucumberOptions(
			features = "E:\\Data\\Selenium-workspace\\FreeCRM_BDDFramework\\src\\main\\java\\Features\\dealsmap.feature",
			//path of the feature file
			
			glue= {"stepDefinitions4"}, 
			// path of the glue code(stepDefinition,hooks,plugins)
			
			plugin= {"pretty","html:test-output","json:json_output/cucumber.json", "junit:junit_xml/cucumber.xml"},
			//generate different types of reporting
			
			dryRun= false, 
			//to check the mapping is proper between feature file and step def file
			
			monochrome = true
			//true,if terminal output should be without colours.
			
			//tags = {"~@SmokeTest" , "~@RegressionTest", "~@End2End"}			

)
public class DealsMapTestRunner {

}
