package stepDefinitions6;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HooksStepDefinition {
	
	@Before
	public void setUp() {
		System.out.println("launch FF");
		System.out.println("Enter URL for Free CRM APP");
	}

	@After
	public void tearDown() {
		System.out.println("close the browser");
	}

	@Given("^user is on deal page$")
	public void user_is_on_deal_oage() throws Throwable {
		System.out.println("user is on deal page");
	}

	@When("^user fills the deals form$")
	public void user_fills_the_deals_form() throws Throwable {
		System.out.println("create a deal");
	}

	@Then("^deal is created$")
	public void deal_is_created() throws Throwable {
		System.out.println("deal is created");
	}

	@Given("^user is on contact page$")
	public void user_is_on_contact_page() throws Throwable {
		System.out.println("user is on contact page");

	}

	@When("^user fills the contact form$")
	public void user_fills_the_contact_form() throws Throwable {
		System.out.println("create a contact");
	}

	@Then("^contact is created$")
	public void contact_is_created() throws Throwable {
		System.out.println("contact is created");
	}

	@Given("^user is on mail page$")
	public void user_is_on_mail_page() throws Throwable {
		System.out.println("user is on mail pahge");
	}

	@When("^user fills the mail form$")
	public void user_fills_the_mail_form() throws Throwable {
		System.out.println("create a mail");
	}

	@Then("^mail is created$")
	public void mail_is_created() throws Throwable {
		System.out.println("mail is created");
	}


	
}


/*Hooks:
Cucumber supports hooks, which are blocks of code that run before or after each scenario. 
You can define them anywhere in your project or step definition layers, 
using the methods @Before and @After. 

Cucumber Hooks allows us to better manage the code workflow and helps us to reduce the code redundancy.
 We can say that it is an unseen step, which allows us to perform our scenarios or tests.

Why Cucumber Hooks?
In the world of testing, you must have encountered the situations where you need to perform the 
prerequisite steps before testing any test scenario. 

This prerequisite can be anything from:
Starting a webdriver
Setting up DB connections
Setting up test data
Setting up browser cookies
Navigating to certain page
or anything before the test

In the same way there are always after steps as well of the tests like:
Killing the webdriver
Closing DB connections
Clearing the test data
Clearing browser cookies
Logging out from the application
Printing reports or logs
Taking screenshots on error
or anything after the test

To handle these kind of situations, cucumber hooks are the best choice to use. 
*/