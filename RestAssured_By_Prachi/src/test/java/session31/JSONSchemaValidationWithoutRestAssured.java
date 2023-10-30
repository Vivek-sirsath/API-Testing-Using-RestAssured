// Session # 31 - JSON Schema Validation Without Rest Assured

package session31;

import java.io.File;

import org.hamcrest.MatcherAssert;
import org.testng.annotations.Test;

import io.restassured.module.jsv.JsonSchemaValidator;

public class JSONSchemaValidationWithoutRestAssured {

	@Test
	public void testMethod(){
		
		String json = "{\r\n"
				+ "  \"id\": 2,\r\n"
				+ "  \"email\": \"janet.weaver@reqres.in\",\r\n"
				+ "  \"first_name\": \"Janet\",\r\n"
				+ "  \"last_name\": \"Weaver\"\r\n"
				+ "}";

// We use '.matchesJsonSchema() method' when our json file is saved on local location		
//        MatcherAssert.assertThat(json, JsonSchemaValidator.matchesJsonSchema(new File("C:\\Users\\Admin\\Desktop\\session31_employeeSchema.json")));
		
		
// If the json file is inside resources folder of project
// Right click on project > New > Source Folder > name that folder as 'src/test/resource'		
		
		MatcherAssert.assertThat(json, JsonSchemaValidator.matchesJsonSchemaInClasspath("session31_employeeSchema.json"));
	}
	
}
