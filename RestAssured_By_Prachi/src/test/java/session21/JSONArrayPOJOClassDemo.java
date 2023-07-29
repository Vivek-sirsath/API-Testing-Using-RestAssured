package session21;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;
import session20.Employee;

public class JSONArrayPOJOClassDemo {

	@Test
	public void createEmployeesJSONArray() throws JsonProcessingException {

		/*
		 * firstName - String 
		 * lastName - String 
		 * age - int 
		 * gender - String 
		 * salary - double
		 */

		// Create first employee object
		Employee emp1 = new Employee();
		emp1.setFirstname("Vivek");
		emp1.setLastname("Shirsath");
		emp1.setAge(35);
		emp1.setGender("Male");
		emp1.setSalary(65000);

		// Create second employee object
		Employee emp2 = new Employee();
		emp2.setFirstname("Ganesh");
		emp2.setLastname("Sonawane");
		emp2.setAge(42);
		emp2.setGender("Male");
		emp2.setSalary(61000);

		// Create third employee object
		Employee emp3 = new Employee();
		emp3.setFirstname("Nilesh");
		emp3.setLastname("Mahajan");
		emp3.setAge(45);
		emp3.setGender("Male");
		emp3.setSalary(62000);

		// Create List using List Interface and add objects in ArrayList
		List<Employee> listOfEmp = new ArrayList<Employee>();

		listOfEmp.add(emp1);
		listOfEmp.add(emp2);
		listOfEmp.add(emp3);

		//************ Serialization **************
		// We've to convert these Class objects to JSON array pay-load as String
		// For this we'll use ObjectMapper Class

		ObjectMapper objMapper = new ObjectMapper();

		// Create String object to convert Class object to JSON array pay-load
		String jsonArrayPayload = objMapper.writerWithDefaultPrettyPrinter().writeValueAsString(listOfEmp);

		System.out.println("Employee Class object to JSON Array Payload:-");
		System.out.println(jsonArrayPayload);

		// Create RequestSpecification
		RequestSpecification reqSpec = RestAssured.given();

		// Specify URL
		reqSpec.baseUri("http://httpbin.org/post"); 
		// ( Try - https://reqres.in/api/users)

		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(jsonArrayPayload);

		// perform POST request
		Response response = reqSpec.post();

		System.out.println("------------Response Body------------");
		response.prettyPrint();
		System.out.println(response.getStatusLine());

		// Validate Status Code
		Assert.assertEquals(response.statusCode(), 200, "Check for status code");
		// (Status Code For - https://reqres.in/api/users = 201)
		System.out.println("Assertion Verified");

		// Until now, we've converted Class object to JSON array pay-load 
		// This is Serialization
		
		// ************* Deserialization **************
		// Convert JSON Array to Employee Class Object
		
		ResponseBody responseBody = response.getBody();
		
		JsonPath jsonPathView = responseBody.jsonPath();
		
		List<Employee> allEmployees = jsonPathView.getList("json", Employee.class);
		
		System.out.println("----------------After converting JSON object to Class Object----------------");
		for(Employee emp : allEmployees) {
			
			System.out.println(emp.getFirstname() + " " + emp.getLastname());
			
		}
	}
}
