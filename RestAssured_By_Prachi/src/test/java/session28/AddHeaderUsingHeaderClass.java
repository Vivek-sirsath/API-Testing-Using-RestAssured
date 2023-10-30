// Session # 28 - How To Add Header In Request

// Here, We'll use 'Header' Class to add single header to the Request

// 3rd 

package session28;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeaderUsingHeaderClass {
	
	@Test
	public void usingHeaderClass() {
		
		Header headerClassObject = new Header("Header3", "Value3");
		
		RequestSpecification requestSpec = RestAssured.given();
		// Specify base URI
		requestSpec.baseUri("https://reqres.in/api/users?page=1");
		// Add header to request using Header Class Object
		requestSpec.header(headerClassObject);
		// To log headers in console
		requestSpec.log().headers();
		
		// Perform get request
		Response response = requestSpec.get();
		
		// Validate Status Code
		Assert.assertEquals(response.statusCode(), 200, "Status code check:");
		System.out.println("Assertion Verified");
		
	}
}
