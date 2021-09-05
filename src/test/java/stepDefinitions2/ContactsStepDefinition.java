package stepDefinitions2;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import io.cucumber.java.After;
//import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactsStepDefinition {

	WebDriver driver;
	
	@Given("^user is already on Login Page$")
	public void user_already_on_login_page(){
		System.setProperty("webdriver.chrome.driver",
				"C:\\Data\\Selenium\\Softwares\\chromedriver_win32\\chromedriver.exe");
		driver = new ChromeDriver(); // launch chrome browser
		driver.get("https://classic.crmpro.com");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	}
	
	@When("^title of login page is Free CRM$")
	public void verify_theloginPageTitle() {
	    // Write code here that turns the phrase above into concrete actions
		String Title  = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.",Title);
	}
	
	@Then("^user enters \"(.*)\" as uname$")
	public void verify_theloginUsername(String username) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys(username);
	}
	
	@Then("^user enters \"(.*)\" as pwd$")
	public void verify_theloginPassword(String password) {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("password")).sendKeys(password);
	}
	
	@And("^user clicks on login button$")
	public void user_clicksOnTheLoginButton() {
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	    // Write code here that turns the phrase above into concrete actions
		js.executeScript("arguments[0].click();", loginBtn);
	}
	

	@Then("^user is on Home Page$")
	public void user_onHomePage() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedTitle = "CRMPRO";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle,actualTitle);
		System.out.println("Login to CRMPRO Home Page successful.");
	}
	
	@When("user mouse over and clicks on New Contact link under Contacts$")
	public void user_mouseover_contactsLink_clickNewContact() {
		driver.switchTo().frame("mainpanel");
		WebElement newContactLink = driver.findElement(By.xpath("//a[@title='New Contact']"));
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'Contacts')]"))).build().perform();
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(newContactLink));
		newContactLink.click();
	}
	
	
	@Then("user enters the (.*),(.*),(.*),(.*)$")
	public void user_entersFirst_LastName(String fname,String lname,String company,String position) {
		WebElement first_name = driver.findElement(By.id("first_name"));
		WebElement last_name = driver.findElement(By.id("surname"));
		WebElement company_name = driver.findElement(By.name("client_lookup"));
		WebElement company_position = driver.findElement(By.id("company_position"));
		first_name.sendKeys(fname);
		last_name.sendKeys(lname);
		company_name.sendKeys(company);
		company_position.sendKeys(position);
	}
	
	@And("^user clicks on save button$")
	public void user_clicks_save_button() {
		WebElement savebtn = driver.findElement(By.xpath("//input[@value='Load From Company']/following-sibling::input[@value='Save']"));
		savebtn.click();
		driver.findElement(By.xpath("//a[contains(text(),'Contacts')]")).click();
	}
	
	@And("^verify the new contact created (.*) and (.*) and (.*) and (.*)$")
	public void user_verifies_contact_created(String fname,String lname,String company,String position) {
		  String name = fname + " " + lname;
		  String search_fname = name.split(" ")[0];
    	  driver.findElement(By.xpath("//td[@class='a2z' and text()='All']")).click();
    	  driver.findElement(By.name("cs_name")).sendKeys("%"+ search_fname + "%");
    	  driver.findElement(By.xpath("//input[@value='Search']")).click();
    	  
    	  List <WebElement> names = driver.findElements(By.xpath("//td[@class='datalistrow']//a[starts-with(text(),'" + name + "')]"));
	      for(WebElement cont_name : names) {
	    	  if (cont_name.getText().equals(name)) {
	    		  Assert.assertEquals(name, cont_name.getText());
	    		  System.out.println(cont_name.getText());
	    		  
	    	      WebElement cont_company = driver.findElement(By.xpath("//a[text()='" + name + "']" 
	                      + "//parent::td[@class='datalistrow']"
	    	    		  + "//following-sibling::td[@class='datalistrow']" 
	                      + "//a[contains(text(),'" + company + "')]"));
		    	  if (cont_company.getText().equals(company)) {
		    		  Assert.assertEquals(company, cont_company.getText());
		    		  System.out.println(cont_company.getText());
		    		  break;
		    	  }
	    	  }
	      }

	}
	
	@Then("^user clicks on logout button$")
	public void user_clicksOnLogout() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	

	@Then("^close the browser$")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

}
