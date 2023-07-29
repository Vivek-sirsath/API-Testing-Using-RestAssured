package session04;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CheckForValidResponse {
	
	//******* FIRST WAY ********//
	
	@Test (enabled = false)
	public void GetSingleUser() 
	{
		// Specify baseURL
		RestAssured.baseURI="https://reqres.in/api/users/2"; // Try 19 instead of 2 [Status Code - 404]
		
		// Get request Specification of the request , Allows you to specify how the request will look like.
		RequestSpecification reqSpec = RestAssured.given();
		
		// Calling Get method
		Response resp =  reqSpec.get();
		
		// gets response/status code
		int statusCode = resp.getStatusCode();
		
		// Validate actual status code & expected status code
		//Assert.assertEquals(statusCode, 200, "correct status code received");
		//Assert.assertEquals(statusCode, 201, "incorrect status code received");
		
		
		// Get StatusLine
		String statusLine = resp.getStatusLine();
		// Validate the Status Line
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK", "Correct status line received");
		//Assert.assertEquals(statusLine, "HTTP/1.1 201 OK", "Incorrect status line received");
		
	}
	
	//******* SECOND WAY ********// 
	
	// Using 'ValidatableResponse()' method
	
	@Test (enabled = false)
	public void GetSingleUserUsingValidatableResponse() 
	{
		// Specify the  baseURL
		RestAssured.baseURI = "https://reqres.in/api/users/2"; // Try 19 instead of 2 [Status Code - 404]
		
		// Specify request using given() method
		RequestSpecification reqSpec = RestAssured.given();
		
		// Calling get method
		Response resp = reqSpec.get();
		
	    ValidatableResponse validateRes = resp.then();
	    
	    // Status Code Validation
	   // validateRes.statusCode(200); // Try 201
	    
	    // Validate Status Line
	    validateRes.statusLine("HTTP/1.1 200 OK");
	}

	//******* THIRD WAY ********// 
	// BDD Style
	
	@Test
	public void GetSingleUser_BDD_Style() 
	{
		RestAssured.given() // Precondition
		
		.when() // Action
		    .get("https://reqres.in/api/users/2")
		.then() // Validation
		    .statusCode(200)
		    .statusLine("HTTP/1.1 200 OK");
	}
}
