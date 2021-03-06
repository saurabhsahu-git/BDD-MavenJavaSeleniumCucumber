package SeleniumGlueCode;


import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import Cucumber_Selenium.Cucumber_Selenium.ReadPropertiesData;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
public class StepDefinition {
	
	public static WebDriver driver;
		
	@Before ("@UI")
	public void SeleniumSetup()
	{
		System.setProperty("webdriver.chrome.driver", "./DriverExecutable/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Given("^User is in Home Page$")
	public void user_is_in_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get(ReadPropertiesData.readProperties("AUT"));
		System.out.println("Current URL : "+driver.getCurrentUrl());
		System.out.println("Title : "+driver.getTitle());
		System.out.println("Window Handle : "+driver.getWindowHandle());
		System.out.println("HashCode : "+driver.hashCode());
		System.out.println("Object toString : "+driver.toString());
	}

	@When("^User Navigates to login page$")
	public void user_Navigates_to_login_page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//span[text()='Log In']")).click();
	}
	
	@When("^User Enters password \"([^\"]*)\"$")
	public void user_Enters_password(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions		
		driver.findElement(By.name("password")).sendKeys(arg1);
	}

	@Then("^Validate Login Error message displayed$")
	public void validate_Login_Error_message_displayed() throws InterruptedException {
	    // Write code here that turns the phrase above into concrete actions
		org.junit.Assert.assertTrue("Login Error Message not displayed.", driver.findElement(By.xpath("//div[text()='Something went wrong...']")).isDisplayed());
	}
	
	@When("^User Enters username \"([^\"]*)\"$")
	public void user_Enters_username(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.name("email")).sendKeys(arg1);
	}
	
	@When("^Click on Login Button$")
	public void click_on_Login_Button() {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//div[text()='Login']")).click();
	}
	
	@When("^User Click on Forgot Password Link$")
	public void user_Click_on_Forgot_Password_Link() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.linkText("Forgot your password?")).click();
	}

	@Then("^Validate Forgot Password page is loaded$")
	public void validate_Forgot_Password_page_is_loaded() {
	    // Write code here that turns the phrase above into concrete actions
	    org.junit.Assert.assertTrue("Forgot Password Page Not Displayed.", driver.findElement(By.xpath("//h2[text()='Forgot my password']")).isDisplayed());
	}

	@When("^User Click on Reset password Button$")
	public void user_Click_on_Reset_password_Button() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.findElement(By.name("action")).submit();
	}

	@Then("^Validate Password reset link is sent to registered email address$")
	public void validate_Password_reset_link_is_sent_to_registered_email_address() {
	    // Write code here that turns the phrase above into concrete actions
	    org.junit.Assert.assertTrue("Password Reset Link sent to registered email Validation failed.", driver.findElement(By.xpath("//div[contains(text(),'will receive an email')]")).isDisplayed());
	}
	
	@Given("^DB is connected$")
	public void db_is_connected() throws Throwable {
	    Driver myDriver = new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver( myDriver );
		Properties Info = new Properties();
		Info.put( "user", ReadPropertiesData.readProperties("DB_username") );
		Info.put( "password", ReadPropertiesData.readProperties("DB_username") );
		Connection conn = DriverManager.getConnection(ReadPropertiesData.readProperties("JDBC_URL"),Info);
		System.out.println("DB Schema : "+conn.getSchema());
		conn.close();
	}
	
	@After ("@UI")
	public void ExecuteAfterScenario()
	{
		driver.quit();
	}

}
