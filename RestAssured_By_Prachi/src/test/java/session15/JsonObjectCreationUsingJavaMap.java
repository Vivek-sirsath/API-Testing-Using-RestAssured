// Session # 15 - What is JSON _ Create JSON Object Using Java Map Interface

package session15;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonObjectCreationUsingJavaMap {

	
	@Test (enabled = false)
	public void createAuthToken() {
		

/*		 * {
		 *   "username" : "admin",
		 *   "password" : "password123"
		 * }
*/		 

// *****************    Basic Example using data in JSON format    *************************
  		
		Map<String,String> jsonData =  new HashMap<String, String>();
		jsonData.put("username", "admin");
		jsonData.put("password", "password");
		
		// Create POST request
		Response response = RestAssured.given()
				.baseUri("https://restful-booker.herokuapp.com/auth")
				.contentType(ContentType.JSON)
				.body(jsonData)
				.post();
		
		response.prettyPrint();
		
		// Verify Status Code
		Assert.assertEquals(response.statusCode(), 201, "Check for status code:");
		System.out.println("Status code verified");

	}

 		
// *****************   Java Map Example using data in HashMap format    *********************
	
	 @Test
	public void createUser() {
		
		// To put the data of different data types as values in HashMap	
		HashMap<String,Object> userData = new HashMap<String, Object>();
		userData.put("firstName", "Vivek");
		userData.put("lastName", "Shirsath");
		userData.put("age", 28);
		userData.put("salary", 10000.56);
		userData.put("isMarried", true);
		userData.put("interests", null);
		
		// Create ArrayList because Hobbies are in the form of Array
		ArrayList<String> hobbies = new ArrayList<String>();
		hobbies.add("Music");
		hobbies.add("Computers");
		hobbies.add("Games");
		userData.put("Hobbies", hobbies);
		
		// Create the Hash Map to add skills
		HashMap<String,String> skills = new HashMap<String,String>();
		skills.put("Programming Skill", "Java");
		skills.put("Front End Skill", "Selenium");
		skills.put("Back End Skill", "Rest Assured");
		userData.put("TechSkills", skills);
		
		// Create request specification and add 'API-Key' as header
		RequestSpecification reqSpec = RestAssured.given();
				 reqSpec.header("x-api-key", "reqres-free-v1");
		// Create POST request
		Response resp = reqSpec
				.baseUri("https://reqres.in/api/users")
				.contentType(ContentType.JSON)
				.body(userData)
				.post();
		
		resp.prettyPrint();
		
		Assert.assertEquals(resp.statusCode(), 201, "Check for status code");
		System.out.println("201 Status code verified");
		
	}	
}
