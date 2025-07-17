// Session # 09 - Authorization  Bearer Token Authentication

package session09;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BearerTokenAuthorization {

	@Test
	public void bearerToken() {
		// https://gorest.co.in/public/v2/users

		// create request specification
		RequestSpecification requestSpec = RestAssured.given();

		// Specify baseUri and basePath
		requestSpec.baseUri("https://gorest.co.in");
		requestSpec.basePath("/public/v2/users");

		/*
		 * 
		 * { 
		 *   "name": "CodeKiller",
		 *   "email": "Codekiller1@gmail.com",
		 *   "gender": "male",
		 *   "status": "active" 
		 * }
		 * 
		 */

		// We create JSON object to store the JSON data which we want to create on server
		
		// Change the following data every time we send request, otherwise it will give client side error 422
		// Because, this will become duplicate data on server.
		
		JSONObject payload = new JSONObject();
		payload.put("name", "ishita");
		payload.put("email", "ishita@gmail.com");
		payload.put("gender", "female");
		payload.put("status", "active");

		// We will need a bearer token for authorization 
		// And we need to store it in string
		String AuthToken = "Bearer 064179c9fda7ce18a6038a50dce09e948e668e5c766571a8b899bf3ba89a614b";

		// This token will go as a part of header, hence we need to create header 
		// which will be in key-value pair.
	    
		requestSpec.header("Authorization", AuthToken).contentType(ContentType.JSON).body(payload.toJSONString());

		// Perform POST request
		Response response = requestSpec.post();
		System.out.println("Response Line:- " + response.getStatusLine());
		
		// Get the response body from the resource created
		Response getResponse = requestSpec.get();
		System.out.println("Get response string: " + getResponse.asPrettyString());
			
	}

}
