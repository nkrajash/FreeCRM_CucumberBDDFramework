package stepDefinitions7;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class TaggedHooksStepDefinition {
	//Global Hooks  ~ like BeforeClass in TestNG
	@Before(order=0)
	public void setUP(){
		System.out.println("launch FF");
		System.out.println("Enter URL for Free CRM APP");
	}

	//Global Hooks ~ like AfterClass in TestNG
	@After(order=0)
	public void tearDown(){
		System.out.println("close the browser");
	}
	
	//Global Hooks ~ like BeforeClass in TestNG
	@Before(order=1)
	public void setUP1(){
		System.out.println("launch FF");
		System.out.println("Enter URL for Free CRM APP");
	}
	
	//Global Hooks ~ like AfterClass in TestNG

	@After(order=1)
	public void tearDown1(){
		System.out.println("close the browser");
	}
	
	//Local Hooks - only for First Scenario
	@Before("@First")
	public void beforeFirst(){
		System.out.println("before only first scenario");
	}
	
	//Local Hooks - only for First Scenario
	@After("@First")
	public void afterFirst(){
		System.out.println("after only first sceanrio");
	}
	
	//Local Hooks - only for Second Scenario
	@Before("@Second")
	public void beforeSecond(){
		System.out.println("before only second scenario");
	}
	
	//Local Hooks - only for Second Scenario
	@After("@Second")
	public void afterSecond(){
		System.out.println("after only second sceanrio");
	}
	
	//Local Hooks - only for Third Scenario
	@Before("@Third")
	public void beforeThird(){
		System.out.println("before only third scenario");
	}
	
	//Local Hooks - only for Third Scenario
	@After("@Third")
	public void afterThird(){
		System.out.println("after only third sceanrio");
	}
	
	
	@Given("^this is the first step$")
	public void this_is_the_first_step() throws Throwable {
		System.out.println("1st step");
	}

	@When("^this is the second step$")
	public void this_is_the_second_step() throws Throwable {
		System.out.println("2nd step");
	}

	@Then("^this is the third step$")
	public void this_is_the_third_step() throws Throwable {
		System.out.println("3rd step");
	}

}
