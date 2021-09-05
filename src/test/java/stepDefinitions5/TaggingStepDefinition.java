package stepDefinitions5;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;

public class TaggingStepDefinition {
	
	WebDriver driver;
	@Before
	public void beforeScenario(){
	      System.out.println("This will run before the Scenario");
			System.setProperty("webdriver.chrome.driver",
					"C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver(); // launch chrome browser
			driver.get("https://classic.crmpro.com");
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}	
		
	@After
	public void afterScenario(){
	     System.out.println("This will run after the Scenario");
		 driver.close();
	}
	
	@Given("^This is a valid login test$")
	public void this_is_a_valid_login_test() {
		driver.findElement(By.name("username")).sendKeys("groupautomation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	    // Write code here that turns the phrase above into concrete actions
		js.executeScript("arguments[0].click();", loginBtn);		
		String expectedTitle = "CRMPRO";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle,actualTitle);
		System.out.println("Login to CRMPRO Home Page successful.");
	}

	@Given("^This is a invalid login test$")
	public void this_is_a_invalid_login_test() {
		driver.findElement(By.name("username")).sendKeys("automation");
		driver.findElement(By.name("password")).sendKeys("Test@12345");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	    // Write code here that turns the phrase above into concrete actions
		js.executeScript("arguments[0].click();", loginBtn);		
		String expectedTitle = "CRMPRO";
		String actualTitle = driver.getTitle();
		Assert.assertNotEquals(expectedTitle,actualTitle);
		System.out.println("Login to CRMPRO Home Page un-successful.");
	}

	@Given("^This is a contact test case$")
	public void this_is_a_contact_test_case(){
		this_is_a_valid_login_test();
		
		driver.switchTo().frame("mainpanel");
		WebElement newContactLink = driver.findElement(By.xpath("//a[@title='New Contact']"));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(newContactLink));
		newContactLink.click();
		WebElement first_name = driver.findElement(By.id("first_name"));
		WebElement last_name = driver.findElement(By.id("surname"));
		WebElement company_name = driver.findElement(By.name("client_lookup"));
		WebElement company_position = driver.findElement(By.id("company_position"));
		first_name.sendKeys("Sania");
		last_name.sendKeys("Mirza");
		company_name.sendKeys("Lawn Tennis");
		company_position.sendKeys("Captain");
		
		WebElement savebtn = driver.findElement(By.xpath("//input[@value='Load From Company']/following-sibling::input[@value='Save']"));
		savebtn.click();
	}

	@Given("^This is a deal test case$")
	public void this_is_a_deal_test_case(){
		this_is_a_valid_login_test();
		driver.switchTo().frame("mainpanel");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
		//Deal
		//Title
		 driver.findElement(By.id("title")).sendKeys("Snapdeal 10% discount");
		 //company
		 driver.findElement(By.name("client_lookup")).sendKeys("Snapdeal");
		 //Amount
		 driver.findElement(By.id("amount")).sendKeys("5000");
		 //probability
		 driver.findElement(By.id("probability")).sendKeys("50");
		 //commission
		 driver.findElement(By.id("commission")).sendKeys("10");
		 driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click(); //save button
	}

	@Given("^This is a case test case$")
	public void this_is_a_case_test_case() throws Throwable {
		this_is_a_valid_login_test();
		driver.switchTo().frame("mainpanel");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Cases')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Case')]")).click();
		//Title
		driver.findElement(By.xpath("//input[@id='title']")).sendKeys("NAL Enhancement");
		//Status:Awaiting input,Enquiring,Reviewing
		Select select = new Select(driver.findElement(By.xpath("//*[@name='status']")));
		select.selectByVisibleText("Awaiting input");
		//Select the Deadline Date
		driver.findElement(By.xpath("//img[@id='f_trigger_c_deadline']")).click();
		driver.findElement(By.xpath("//tr[@class='daysrow']//td[contains(text(),'22')]")).click();
		//State: Open,Closed
		driver.findElement(By.xpath("//input[@type='radio' and @value='N']")).click();//Open

		//Type:Business Support,Customer Support,Complaint,Enquiry,Technical Support,General Support
		Select select2 = new Select(driver.findElement(By.xpath("//*[@name='type']")));
		select2.selectByVisibleText("Customer Support");
		
		//Priority:High,Low,Normal
		Select select3 = new Select(driver.findElement(By.xpath("//*[@name='priority']")));
		select3.selectByVisibleText("Normal");
		
		//---------------------------------------------------------------------------------------
		//Company Lookup
		driver.findElement(By.xpath("//input[@name='client_lookup']//following::input[@value='Lookup']")).click();
		perform_Lookup(driver, "Naveen Automation Labs", "Clients");
		driver.findElement(By.xpath("//input[@value='Edit']")).click();			
		//---------------------------------------------------------------------------------------
		//Contact Lookup
		driver.findElement(By.xpath("//input[@name='contact_lookup']//following::input[@value='Lookup']")).click();
		perform_Lookup(driver, "Naveen", "Contacts");
		
	}
	
	@Given("^This is a tasks test case$")
	public void this_is_a_tasks_test_case() throws Throwable {
		this_is_a_valid_login_test();
		driver.switchTo().frame("mainpanel");
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Tasks')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Task')]")).click();
		
		//Task
		driver.findElement(By.id("title")).sendKeys("Cucumber BDD F/W Sessions with Java");
		//Auto-extend
		Select select = new Select(driver.findElement(By.xpath("//*[@name='auto_extend']")));
		select.selectByVisibleText("Extend deadline by 3 days");
		
		//Status
		Select select2 = new Select(driver.findElement(By.xpath("//*[@name='status']")));
		select2.selectByVisibleText("Open");
		
		//completion %
		driver.findElement(By.cssSelector("input#completion")).sendKeys("50");
		
		//task type:Call,Delivery,Email, Presentation, Meeting, Event, Client Visit, Training
		Select select3 = new Select(driver.findElement(By.xpath("//*[@name='task_type']")));
		select3.selectByVisibleText("Training");
		
		//Priority: High, Low, Normal
		Select select4 = new Select(driver.findElement(By.xpath("//*[@name='priority']")));
		select4.selectByVisibleText("High");
		
		//Click on deal 
		driver.findElement(By.xpath("//input[@name='prospect_id']//following-sibling::input[@class='button']")).click();
		perform_Lookup(driver, "Snapdeal", "Prospects");

	}
	

	@Given("^clicking on left panel links$")
	public void clicking_on_left_panel_links() throws Throwable {
	}

	@Given("^This is a search deal test$")
	public void this_is_a_search_deal_test() throws Throwable {
	}

	@Given("^This is a search contact test$")
	public void this_is_a_search_contact_test() throws Throwable {
	}

	@Given("^This is a search case test$")
	public void this_is_a_search_case_test() throws Throwable {
	}

	@Given("^This is a search task test$")
	public void this_is_a_search_task_test() throws Throwable {
	}

	@Given("^This is a search call test$")
	public void this_is_a_search_call_test() throws Throwable {
	}

	@Given("^This is a search email test$")
	public void this_is_a_search_email_test() throws Throwable {
	}

	@Given("^This is a search docs test$")
	public void this_is_a_search_docs_test() throws Throwable {
	}

	@Given("^This is a search forms test$")
	public void this_is_a_search_forms_test() throws Throwable {
	}

	@Given("^This is a report test$")
	public void this_is_a_report_test() throws Throwable {
	}

	@Given("^This is a logout test$")
	public void this_is_a_logout_test() throws Throwable {
		this_is_a_valid_login_test();
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	
	public static void perform_Lookup(WebDriver driver,String lookup,String strong) {
		System.out.println("This is to do Lookup");
		
		//Lookup
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> iter = windows.iterator();
		String parentId = iter.next();
		System.out.println(driver.getTitle());
		System.out.println("Parent ID = " + parentId);
		String item = lookup;
		Boolean found = false;
		while(iter.hasNext()) {
			String childId = iter.next();
			driver.switchTo().window(childId);
			System.out.println("child ID = " + childId);
			System.out.println(driver.getTitle());
			
			driver.findElement(By.xpath("//input[@type='text']")).sendKeys(item);
			driver.findElement(By.xpath("//input[@type='submit']")).click();
			
			String strongText = driver.findElement(By.xpath("//td/strong")).getText();
			if(strongText.contains(strong))
				found = true;
		}
		System.out.println(driver.getTitle());
		if(found) 
			driver.findElement(By.xpath("//a[contains(text(),'" + lookup  + "')]")).click();//success
		else 
			driver.findElement(By.xpath("//input[@value='X']")).click();
		driver.switchTo().window(parentId); //need to switch to parent
		System.out.println(driver.getTitle());
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//input[@value='Max']//following::input[@value='Save']")).click(); //save button

	}
	
	@Given("^This is a close browser test$")
	public void this_is_a_close_broswer_test() throws Throwable {
		driver.quit();
	}

}


/*Tags:
Cucumber has already provided a way to organize your scenario execution by using tags in feature file. 
We can define each scenario with a useful tag. Later, in the runner file, 
we can decide which specific tag (and so as the scenario(s)) we want Cucumber to execute. 

Tag starts with “@”. After “@” you can have any relevant text to define your tag like @SmokeTests 
just above the scenarios you like to mark. Then to target these tagged scenarios just specify the 
tags names in the CucumberOptions as tags = “@SmokeTests and @RegressionTests" in TestRunner java files.

Tagging not just specifically works with Scenarios, it also works with Features. 
Means you can also tag your features files. Any tag that exists on a Feature will be inherited by 
Scenario, Scenario Outline or Examples.
*/