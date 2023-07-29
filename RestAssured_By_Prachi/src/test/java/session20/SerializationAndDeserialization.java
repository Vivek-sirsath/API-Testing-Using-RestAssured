package session20;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SerializationAndDeserialization {
	
	@Test
	public void CreateJSONObjectFromClassObjectEmployee() throws JsonProcessingException  {
		
		//************ Serialization **************
		
		//To convert Class Object to JSON Object
		// Create the object of Employee Class
		Employee emp1 = new Employee();
		emp1.setFirstname("Vivek");
		emp1.setLastname("Shirsath");
		emp1.setAge(35);
		emp1.setGender("Male");
		emp1.setSalary(65000.75);
		
		// Convert Class Object to JSON payload as String using ObjectMapper
		// Create ObjectMapper Instance
	    ObjectMapper objMapper = new ObjectMapper();
	    
	    // To print emp1 class object as String JSON Object 
		String employeeJSON = objMapper
		                        .writerWithDefaultPrettyPrinter()
	                        	.writeValueAsString(emp1);
		
		System.out.println("After Serialization - Class Object to String (JSON Object)");
		System.out.println(employeeJSON);
		
		// We can post this JSON Data on a web-site also
		
		// Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		// Specify baseUri, contentType, Body of the POST request
		reqSpec.baseUri("http://httpbin.org/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(employeeJSON);
		
		// Perform POST request
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200, "Check for status code:");
		
		// ************* Deserialization **************
		
		// To convert JSON String (employeeJSON) object to Class Object (Employee)
		Employee emp2 = objMapper.readValue(employeeJSON, Employee.class);

		System.out.println("After Deserialization - String (JSON Object) to Class Object");
		// To print the Class Object
		System.out.println("firstName" + " - " + emp2.getFirstname());
		System.out.println("lastName" + " - " + emp2.getLastname());
		System.out.println("age" + " - " + emp2.getAge());
		System.out.println("gender" + " - " + emp2.getGender());
		System.out.println("salary" + " - " + emp2.getSalary());		
		
	}

}
