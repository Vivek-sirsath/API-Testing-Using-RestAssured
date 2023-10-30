// Session # 03 - How Rest Assured Works  Create HTTP Request

package session03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import junit.framework.Assert;

public class Test_GetMethod {

	@Test
	public void test01() {
		Response response = RestAssured.get("https://reqres.in/api/users?page=2");
		 // To avoid mentioning of ClassName (RestAssured), We need to make it static at import statement AS (import static io.restassured.RestAssured.*;)
		System.out.println("Response Code: " + response.getStatusCode());
		System.out.println("Response Body: " + response.getBody().asPrettyString());
		System.out.println("Response Time: " + response.getTime());
		System.out.println("Response Header: " + response.getHeader("Content-Type"));

		// Validate status code
		// Expected status code = 200         

		int expectedStatusCode = 200;         //if we make 201 then Test Case will FAIL
		int actualStatusCode = response.getStatusCode();
		Assert.assertEquals(expectedStatusCode, actualStatusCode);
	}
	
	// In BDD Style - given , when , then (BDD Style)
	@Test
	public void test02() 
	{
		// given , when , then (BDD Style)
		RestAssured.baseURI="https://reqres.in/api/users";   //Here RestAssured is Class, baseURI is variable name
		RestAssured.                                         // RestAssured is Class & given() is Method
		given().queryParam("page", "2"). 
		when().get().         // when() is an action to perform get(), post(), put()                               
		then().statusCode(200);
			
	}
}
