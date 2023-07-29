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
		  
		  {
			"name": "CodeKiller",
		    "email": "Codekiller1@gmail.com",
		    "gender": "male",
		    "status": "active"
		  }
		
		*/
		
		// We create JSON object to store the JSON data which we want to create on server
		JSONObject payload = new JSONObject();
		payload.put("name", "john");
		payload.put("email", "john@gmail.com");
		payload.put("gender", "male");
		payload.put("status", "active");
		
		
		// We will need token
		String AuthToken = "Bearer 064179c9fda7ce18a6038a50dce09e948e668e5c766571a8b899bf3ba89a614b";
		
		requestSpec.header("Authorization", AuthToken)
		.contentType(ContentType.JSON)
		.body(payload.toJSONString());
		
		// Perform POST request
		Response response = requestSpec.post();
		System.out.println("Response Line:- " + response.getStatusLine());
	}

}
