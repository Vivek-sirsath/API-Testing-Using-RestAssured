// Session # 06 - Validate JSON Response Body

package session06;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateJsonResponseBody {
	// https://reqres.in/api/users?page=2
	
	@Test
	public void UserListResponseBody() {
		
		// Build request using RequestSpecification interface using RestAssured class and store in a reference
		RequestSpecification requestSpec = RestAssured.given();
		
		// Specify base URI and base Path
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users?page=2");
		
		// Create Get Request and store the response in a variable
		Response response = requestSpec.get(); // response is local variable
		
		// Store the same response in a variable as string because contains method will be applicable on string only
		// But in console we can print the response as 'asPrettyString'
		String responseString = response.asString();
		System.out.println("Response Body:-");
		System.out.println(response.asPrettyString());
				
		// Validate response body contains "Eve" by using Assertion and contains method
		Assert.assertEquals(responseString.contains("Eve"), true, "Check for Presence of Eve");
		System.out.println("___Presence Verified___");
		
		// Verify Eve at 3rd index in response body using tool JSON PathFinder
		//x.data[3].first_name (Eve's Path) 
		
		// Store the path of Eve retrieved from JSON Path finder
		JsonPath path = response.jsonPath();
		String first_name = path.get("data[3].first_name");
		
		// Validate the path of Eve is correct or not using Assertion
		Assert.assertEquals(first_name, "Eve", "Check for correct path");
		System.out.println("___Path Verified___");
	}

}
