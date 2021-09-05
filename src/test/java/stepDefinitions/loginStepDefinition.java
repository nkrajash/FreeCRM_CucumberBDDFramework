package stepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class loginStepDefinition {
	WebDriver driver;

	@Given("^user is already on Login Page$")
	public void user_LoginPage(){
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
	public void verify_loginPageTitle() {
	    // Write code here that turns the phrase above into concrete actions
		String Title  = driver.getTitle();
		System.out.println(Title);
		Assert.assertEquals("CRMPRO - CRM software for customer relationship management, sales, and support.",Title);
	}
	
	//1.\"([^\"].*)\"
	//2. \"(.*)\"
	
	@Then("^user enters \"(.*)\" as username$")
	public void verify_loginUsername() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("username")).sendKeys("groupautomation");
	}
	
	@Then("^user enters \"(.*)\" as password$")
	public void verify_loginPassword() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("password")).sendKeys("Test@12345");
	}
	
	@And("^user clicks on login button$")
	public void user_clicksOnLoginButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement loginBtn = driver.findElement(By.xpath("//input[@type='submit']"));
	    // Write code here that turns the phrase above into concrete actions
		js.executeScript("arguments[0].click();", loginBtn);
	}
	
	@Then("^user is on home page$")
	public void user_HomePage() {
	    // Write code here that turns the phrase above into concrete actions
		String expectedTitle = "CRMPRO";
		String actualTitle = driver.getTitle();
		Assert.assertEquals(expectedTitle,actualTitle);
		System.out.println("Login to CRMPRO Home Page successful.");
	}
	
	
	@Then("^user clicks on logout button$")
	public void user_clicksLogout() {
	    // Write code here that turns the phrase above into concrete actions
		driver.switchTo().frame("mainpanel");
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
	}
	
	@Then("^close the browser$")
	public void close_browser() {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}
}
