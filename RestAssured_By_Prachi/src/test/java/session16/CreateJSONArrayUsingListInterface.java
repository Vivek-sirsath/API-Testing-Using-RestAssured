// Session # 16 - Create JSON Array Using JSON Object and List Interface

package session16;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJSONArrayUsingListInterface {

	@Test
	public void createJSONArrayUsingListAndHashMap() {

		// Create 3 users as HashMap objects using Map Interface
		
		Map<String, Object> user1 = new HashMap<String, Object>();
		user1.put("firstName", "Anil");
		user1.put("lastName", "Patil");
		user1.put("age", 35);
		user1.put("salary", 54500.56);

		Map<String, Object> user2 = new HashMap<String, Object>();
		user2.put("firstName", "Pankaj");
		user2.put("lastName", "Chaudhari");
		user2.put("age", 42);
		user2.put("salary", 62700.75);

		Map<String, Object> user3 = new HashMap<String, Object>();
		user3.put("firstName", "Nilesh");
		user3.put("lastName", "Mahajan");
		user3.put("age", 43);
		user3.put("salary", 58300.25);

		// Create ArrayList to add above objects using List Interface
		List<Map<String, Object>> jsonArrayListPayload = new ArrayList<>();

		// Add above 3 users to the List/Collection
		jsonArrayListPayload.add(user1);
		jsonArrayListPayload.add(user2);
		jsonArrayListPayload.add(user3);

		// Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();

		// Specify baseURL
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonArrayListPayload);

		// Perform POST request
		Response response = reqSpec.post();

		response.prettyPrint();

		// Validate Status Code
		Assert.assertEquals(response.statusCode(), 201, "Check for status code");

	}
}
