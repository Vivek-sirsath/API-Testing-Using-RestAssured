package session22;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SimpleNestedJSONPayload {
	
	
/*
	   {
         "firstname" : "Vivek",
         "lastname" : "Shirsath",
         "gender" : "Male",
         "age" : 35,
         "salary" : 58000.72,
         "address" : {
             "street" : "Ring Road",
             "city" : "Jalgaon",
             "state" : "Maharashtra",
             "pin" : 425003
            }
        }
*/
	
	@Test
	public void createUser() throws JsonProcessingException {		
		
		// Create object of Nested POJO class
		EmployeePojoClass emp1 = new EmployeePojoClass();
		
		// Call the setters methods to add the values to keys
		emp1.setFirstname("Vivek");
		emp1.setLastname("Shirsath");
		emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(58000.72);
		
		EmployeeAddress emp1Address = new EmployeeAddress();
		emp1Address.setStreet("Ring Road");
		emp1Address.setCity("Jalgaon");
		emp1Address.setState("Maharashtra");
		emp1Address.setPin(425003);
		
		// add this address object to POJO class object to create nested object of POJO class
		emp1.setAddress(emp1Address);
		
		
		// Convert class object to JSON object as string
		ObjectMapper objMapper = new ObjectMapper();
		
		String jsonPayload = objMapper                    // JsonProcessingException
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(emp1); 
		
		System.out.println("JsonPayload is:- " + jsonPayload);
		
		// Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		// Specify Base URI, contentType, body
		reqSpec.baseUri("https://httpbin.org/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonPayload);
		
		// Perform POST request
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		System.out.println("Status Line:- " + response.getStatusLine());
		
		// Validate status code
		Assert.assertEquals(response.getStatusCode(), 200, "Check for status code:");
		System.out.println("Assertion Verified for Staus Code");		
		
	}

}
