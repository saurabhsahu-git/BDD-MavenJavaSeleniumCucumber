package SeleniumGlueCode;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.*;

public class StepDefinition {
	
	public static WebDriver driver;
	
	@Given("^User is in Home Page$")
	public void user_is_in_Home_Page() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.setProperty("webdriver.chrome.driver", "./DriverExecutable/chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://freecrm.com/");
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

	@When("^User Enters password q(\\d+)w(\\d+)e(\\d+)r(\\d+)t(\\d+)$")
	public void user_Enters_q_w_e_r_t(int arg1, int arg2, int arg3, int arg4, int arg5) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@When("^User Clicks on Login Button$")
	public void user_Clicks_on_Login_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    
	}

	@Then("^Validate Login Error message displayed$")
	public void validate_Login_Error_message_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   
	}
	
	@Given("^DB is connected$")
	public void db_is_connected() throws Throwable {
	    Driver myDriver = new oracle.jdbc.driver.OracleDriver();
		DriverManager.registerDriver( myDriver );
		Properties Info = new Properties();
		Info.put( "user", "xe" );
		Info.put( "password", "xe" );
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe",Info);
		System.out.println("DB Schema : "+conn.getSchema());
		conn.close();
	}

}
