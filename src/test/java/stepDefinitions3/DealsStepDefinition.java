package stepDefinitions3;

import java.util.List;
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

public class DealsStepDefinition {
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
		 List<List<String>> data = credentials.asLists();
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys(data.get(0).get(0));
		driver.findElement(By.name("password")).sendKeys(data.get(0).get(1));
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
		 List<List<String>> dealValues =  dealData.asLists();
		 driver.findElement(By.id("title")).sendKeys(dealValues.get(0).get(0));
		 driver.findElement(By.id("amount")).sendKeys(dealValues.get(0).get(1));
		 driver.findElement(By.id("probability")).sendKeys(dealValues.get(0).get(2));
		 driver.findElement(By.id("commission")).sendKeys(dealValues.get(0).get(3));
		 driver.findElement(By.xpath("//input[@type='submit' and @value='Save']")).click(); //save button

	 }

	
	@Then("^close the browser$")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

}
