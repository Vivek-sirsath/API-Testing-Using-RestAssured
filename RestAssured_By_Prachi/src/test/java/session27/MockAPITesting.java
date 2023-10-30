// Session # 27 - Mock API Easily Convert JSON Response To POJO Class Object

package session27;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class MockAPITesting {

	// 1)  How to mock API JSON response Easily and Quickly
	
	@Test (enabled = false)
	public void testMockAPI() {

		RequestSpecification reqSpec = RestAssured.given();

		reqSpec.baseUri("https://run.mocky.io/v3/ee5b4315-8442-43bc-b6ec-ddeda7cbdf3d");
		reqSpec.contentType(ContentType.JSON);
		Response resp = reqSpec.get();
		resp.prettyPrint();

		// Validate Status Code
		Assert.assertEquals(resp.statusCode(), 200, "Check for status code:");

	}
	

	// 2) How to convert JSON Object response to POJO Class Object
	
	@Test (enabled = true)
	public void testJsonObjectToPojoObject() {

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.baseUri("https://run.mocky.io/v3/ee5b4315-8442-43bc-b6ec-ddeda7cbdf3d");
		
		// JSON object to POJO object using object of POJO class
		MockAPIPojoClass pojoClassObj  = reqSpec.get().as(MockAPIPojoClass.class);
		
		System.out.println("First Name:- " + pojoClassObj.getFirstname());
		System.out.println("Last Name:- " + pojoClassObj.getLastname());
		System.out.println("Age:- " + pojoClassObj.getAge());
		System.out.println("Salary:- " + pojoClassObj.getSalary());
		System.out.println("Is Married? :- " + pojoClassObj.isMarried());
		
		System.out.println("Hobbies:-");		
		String[] objHobbies = pojoClassObj.getHobbies();
		for(int  i=0; i<objHobbies.length; i++) {
			System.out.println(objHobbies[i]);
		}		
		
		// Using for-each loop for iteration over Map.entrySet()
		for (Map.Entry<String, String> entry : pojoClassObj.getFamilyMembers().entrySet()) {
		System.out.println("Key=" + entry.getKey() + " " +  "Value=" + entry.getValue());	
		}
		
	}

}
