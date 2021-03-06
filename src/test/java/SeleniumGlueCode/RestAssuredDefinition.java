package SeleniumGlueCode;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.junit.Assert;
import Cucumber_Selenium.Cucumber_Selenium.ReadPropertiesData;
import cucumber.api.java.en.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestAssuredDefinition {
	
	static Response response;
	static JSONObject requestParams;
	static RequestSpecification request;
	static String CreateRequestPostBody = "{\n" +
            "  \"name\": \"Saurabh\",\n" +
            "  \"job\": \"Automation Tester\" \n}";

	public static String baseURI() throws IOException
	{
		return RestAssured.baseURI = ReadPropertiesData.readProperties("RestAssuredbaseURI");
	}
	
	@When("^Hitting GET List Users API$")
	public void hitting_GET_List_Users_API() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		response = RestAssured.get(baseURI()+"/users?page=2");
	    
	}

	@Then("^Validating Response code is \"([^\"]*)\"$")
	public void validating_Response_code_is(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	 System.out.println("HTTPS response code : "+response.getStatusCode());
	 Assert.assertTrue("Response code is not "+arg1+". Hence, failing", arg1.equals(String.valueOf(response.getStatusCode())));
	}

	@Then("^printing Response Body on console$")
	public void printing_Response_Body_on_console() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println(response.getBody());
	    System.out.println(response.asString());
	}

	@When("^Hitting POST Create API$")
	public void hitting_POST_Create_API() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		requestParams=new JSONObject();
		//requestParams.put("name","Saurabh");
		//requestParams.put("job","Automation Tester");
		request = RestAssured.given();
		request.headers("Content-Type","application/json");
		//request.body(requestParams.toJSONString());
		request.body(CreateRequestPostBody);
		response=request.post(baseURI()+"/users");
	}
	
	@Then("^printing each attribute along with its value from Create API response body$")
	public void printing_each_attribute_along_with_its_value_from_Create_API_response_body() {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Name : "+response.jsonPath().get("name"));
		System.out.println("Job : "+response.jsonPath().get("job"));
		System.out.println("ID : "+response.jsonPath().get("id"));
		System.out.println("Creation Time : "+response.jsonPath().get("createdAt"));
		
	}
	
	@When("^Hitting GET Single User API$")
	public void hitting_GET_Single_User_API() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Debug : "+baseURI()+"/users/2");
		request=RestAssured.given();
		request.headers("Content-Type","application/json");
		response=request.post(baseURI()+"/users/2");
		//response=RestAssured.post(baseURI()+"/users/2");
		System.out.println("BODY : "+response.asString());
		System.out.println("CODE : "+response.getStatusCode());
	    
	}

	@When("^Hitting POST Register API$")
	public void hitting_POST_Register_API() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		requestParams=new JSONObject();
		requestParams.put("email","eve.holt@reqres.in");
		requestParams.put("password","pistol");
		request = RestAssured.given();
		request.headers("Content-Type","application/json");
		request.body(requestParams.toJSONString());
		response=request.post(baseURI()+"/register");
	}

	@Then("^printing each attribute along with its value from Register API response body$")
	public void printing_each_attribute_along_with_its_value_from_Register_API_response_body() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("ID : "+response.jsonPath().get("id"));
		System.out.println("Token : "+response.jsonPath().get("token"));
	}

	@When("^Hitting POST Login API$")
	public void hitting_POST_Login_API() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		requestParams=new JSONObject();
		requestParams.put("email","eve.holt@reqres.in");
		requestParams.put("password","cityslicka");
		request = RestAssured.given();
		request.headers("Content-Type","application/json");
		request.body(requestParams.toJSONString());
		response=request.post(baseURI()+"/login");
	}

	@Then("^printing each attribute along with its value from Login API response body$")
	public void printing_each_attribute_along_with_its_value_from_Login_API_response_body() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		System.out.println("Token : "+response.jsonPath().get("token"));
	}
}

