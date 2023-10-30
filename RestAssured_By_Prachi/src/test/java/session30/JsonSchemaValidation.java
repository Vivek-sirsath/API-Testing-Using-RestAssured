// Session # 30 - JSON Schema Validation

package session30;

import java.io.File;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;

public class JsonSchemaValidation {

	@Test
	public void validatePayloadWithSchema() {
		
		// Create a string variable and store request pay-load in it
		
		String requestPayload = "{\r\n"
				+ "  \"username\" : \"admin\",\r\n"
				+ "  \"password\" : \"password123\"\r\n"
				+ "}";
		
		// Perform the request in Given, When, Then format
		
		RestAssured
		.given()
		     .baseUri("https://restful-booker.herokuapp.com/auth")
		     .contentType(ContentType.JSON)
		     .body(requestPayload)
		.when()
		     .post()
		.then()
		     .assertThat()
		     .statusCode(200)
		     .body("token", Matchers.notNullValue())
		     .body(JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Admin\\Desktop\\session30_schema.json")));
		     
		     
              // Try edit the schema.json file: change string word by integer to fail the test case
		     
		      /* instead of method - '.matchesJsonSchema(FILE_PATH_From_Desktop)' , we can paste the schema file in our project
		       * in a folder 'src/test/resource' at project level.
		       * // Right click on project > New > Source Folder > name that folder as 'src/test/resource'
		       * 
		       * So that, we can use the method- .matchesJsonSchemaInClasspath().
		       * Here we just need to pass the file name as an argument to the method. */
//		     .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("session30_schema.json"));
		
	}
}
