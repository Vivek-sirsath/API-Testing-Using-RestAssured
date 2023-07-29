
package session28;

// 1st

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class AddHeaderUsingHeaderMethod {
	
	@Test
	public void usingHeaderMethod() {
		
		RequestSpecification requestSpec = RestAssured.given();
		// Add header to request
		requestSpec.header("Header1","Value1");
		// To log header in console
		requestSpec.log().headers();
		// Specify base URI
		requestSpec.baseUri("https://reqres.in/api/users?page=1");
		// Perform get request
		requestSpec.get();	

	}
}
