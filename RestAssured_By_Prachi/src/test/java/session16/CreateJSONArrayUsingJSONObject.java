package session16;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJSONArrayUsingJSONObject {

	@Test
	public void createJSONArrayUsingJSONObject() {

		// Create 3 users as JSON Objects

		JSONObject user1 = new JSONObject();
		user1.put("firstName", "Vivek");
		user1.put("lastName", "Shirsath");
		user1.put("age", 28);
		user1.put("salary", 58000.56);

		JSONObject user2 = new JSONObject();
		user2.put("firstName", "Kiran");
		user2.put("lastName", "Chaudhari");
		user2.put("age", 36);
		user2.put("salary", 62500.75);

		JSONObject user3 = new JSONObject();
		user3.put("firstName", "Ganesh");
		user3.put("lastName", "Sonawane");
		user3.put("age", 39);
		user3.put("salary", 54300.25);

		// Create JSON Array to add above objects
		JSONArray usersPayload = new JSONArray();
		usersPayload.add(user1);
		usersPayload.add(user2);
		usersPayload.add(user3);

		// Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();

		// Specify baseURL
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(usersPayload);

		// Perform POST request
		Response response = reqSpec.post();

		response.prettyPrint();

		// Validate Status Code
		Assert.assertEquals(response.statusCode(), 201, "Check for status code");
		System.out.println("201 status Code Verified");

	}
}
