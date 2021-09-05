package stepDefinitions4;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;



public class DealsMapStepDefinition {
	WebDriver driver;
	
	@Given("^user is already on Login Page$")
	public void user_LoginPage(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // launch chrome browser
		driver.get("https://classic.crmpro.com/index.html");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	@When("^title of login page is Free CRM$")
	public void verify_loginPageTitle() {
	    // Write code here that turns the phrase above into concrete actions
		String Title  = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.",Title);
	}
	
	//1.\"([^\"].*)\"
	//2. \"(.*)\"
	
	@Then("^user enters username and password$")
	public void verify_loginUsername(DataTable credentials) {
		List<Map<String, String>> rows = credentials.asMaps(String.class, String.class);
		 for(Map<String, String> data : rows) {
			 // Write code here that turns the phrase above into concrete actions
			 driver.findElement(By.name("username")).sendKeys(data.get("username"));
			 driver.findElement(By.name("password")).sendKeys(data.get("password"));
		 }
	}
	
	 @Then("^user clicks on login button$")
	 public void user_clicks_on_login_button() {
		 WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("arguments[0].click();", loginBtn);
	 }
	 
	 @Then("^user is on home page$")
	 public void user_is_on_hopme_page(){
		 String title = driver.getTitle();
		 System.out.println("Home Page title ::"+ title);
		 Assert.assertEquals("CRMPRO", title);
	 }
	 
	 
	 @Then("^user moves to new deal page$")
	 public void user_moves_to_new_contact_page() {
		driver.switchTo().frame("mainpanel");
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
		
		}
	 
	 @Then("^user enters deal details$")
	 public void user_enters_contacts_details(DataTable dealData){
		 List<Map<String, String>> dealvalrows = dealData.asMaps(String.class, String.class);
		 for(Map<String, String> dealValues : dealvalrows) {
			 driver.findElement(By.id("title")).sendKeys(dealValues.get("title"));
			 driver.findElement(By.id("amount")).sendKeys(dealValues.get("amount"));
			 driver.findElement(By.id("probability")).sendKeys(dealValues.get("probability"));
			 driver.findElement(By.id("commission")).sendKeys(dealValues.get("commission"));
		 
			 driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click(); //save button
			//move to new deal page:
			Actions action = new Actions(driver);
			action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Deals')]"))).build().perform();
			driver.findElement(By.xpath("//a[contains(text(),'New Deal')]")).click();
		 }
	 }

	
	@Then("^close the browser$")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

}

/*Maps in Data Tables:

Maps in Data Tables can be used in different ways. 
Headers/Columns can also be defined for the test data. 
A same step definition can be executed multiple times with different set of test data using Maps.

Maps in Data Tables with Header:
In the previous tutorial video of Data Tables in Cucumber,  we pass Username & Password without Header,
due to which the test was not much readable. What if there will be many columns.
The basic concept of BDD test is to make the Test in Business readable format, 
so that business users can understand it easily.

 */
