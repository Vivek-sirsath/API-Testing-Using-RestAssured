// Session # 07 - How To Work With Query Parameter

package session07;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class QueryParameter {

	@Test
	public void filterData() {

		// Get request specification for given request
		RequestSpecification requestSpec = RestAssured.given();

		// Specify base URI, base Path and query parameters
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");
		requestSpec.queryParam("page", 2).queryParam("id", 8);

		// Perform get request and store response in a variable
		Response response = requestSpec.get();

		// Read Response Body
		String responseBodyString = response.getBody().asString();
		// Print response Body
		System.out.println("Response Body:- " + responseBodyString);

		// Get JSON Path view of response body using JsonPath Class
		// JsonPath class is an alternative to using XPath for easily getting values
		// from a Object document. You can regard it as an alternative to XPath for JSON
		JsonPath jsonPathView = response.jsonPath();
		System.out.println("jsonPathView:- " + jsonPathView);

		// Get email of Lindsay from jsonPathView
		String email = jsonPathView.get("data.email");
		System.out.println(email);

		// Validate response
		Assert.assertEquals(email, "lindsay.ferguson@reqres.in", "Check for email");
		System.out.println("Assertion Verified");

	}

}
