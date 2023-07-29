package session23;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import session22.EmployeeAddress;
import session22.EmployeePojoClass;

public class ComplexNestedJSONObject {
	
/*
"companyName" : "XYZ Ltd",
"Street" : "SB Street",
"City" : "Pune",
"State" : "Maharashtra",
"Pin code" : "349225",
"Bank Accounts" : ["HDFC","SBI","AXIS"],
*/	

	@Test
	public void createUser() throws JsonProcessingException {
		
		// Create the object of POJO class
		ComplexNestedPojoClass requestPayload = new ComplexNestedPojoClass();
		
		requestPayload.setCompanyName("XYZ Ltd");
		requestPayload.setStreet("SB Street");
		requestPayload.setCity("Pune");
		requestPayload.setState("Maharashtra");
		requestPayload.setPincode(349225);
		
		List<String> banks = new ArrayList<String>();
		banks.add("HDFC");
		banks.add("SBI");
		banks.add("AXIS");
		requestPayload.setBankAccount(banks);
		
		// Create employee objects of Session22 POJO class
		EmployeePojoClass emp1 = new EmployeePojoClass();
		EmployeePojoClass emp2 = new EmployeePojoClass();
		EmployeePojoClass emp3 = new EmployeePojoClass();
		
		//1st Employee : Call the setters methods to add the values to keys
		 
				emp1.setFirstname("Vivek");
				emp1.setLastname("Shirsath");
				emp1.setGender("Male");
				emp1.setAge(35);
				emp1.setSalary(58000.42);
				
				EmployeeAddress emp1Address = new EmployeeAddress();
				emp1Address.setStreet("Ring Road");
				emp1Address.setCity("Jalgaon");
				emp1Address.setState("Maharashtra");
				emp1Address.setPin(425003);
				
				// add this address object to POJO class object to create nested object of POJO class
				emp1.setAddress(emp1Address);
				
		// 2nd Employee	: Call the setters methods to add the values to keys
		
				emp2.setFirstname("Ganesh");
				emp2.setLastname("Sonawane");
				emp2.setGender("Male");
				emp2.setAge(42);
				emp2.setSalary(45000.88);
				
				EmployeeAddress emp2Address = new EmployeeAddress();
				emp2Address.setStreet("Main Road");
				emp2Address.setCity("Amalner");
				emp2Address.setState("Maharashtra");
				emp2Address.setPin(400135);
				
				// add this address object to POJO class object to create nested object of POJO class
				emp2.setAddress(emp2Address);	
				
		// 3rd Employee : Call the setters methods to add the values to keys
		 
				emp3.setFirstname("Kiran");
				emp3.setLastname("Chaudhari");
				emp3.setGender("Male");
				emp3.setAge(44);
				emp3.setSalary(48000.12);
				
				EmployeeAddress emp3Address = new EmployeeAddress();
				emp3Address.setStreet("Rail Road");
				emp3Address.setCity("Aasoda");
				emp3Address.setState("Maharashtra");
				emp3Address.setPin(425004);
				
				// add this address object to POJO class object to create nested object of POJO class
				emp3.setAddress(emp3Address);	
				
		List <EmployeePojoClass> employees = new ArrayList<EmployeePojoClass>();
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
				
		requestPayload.setEmployeeList(employees);
		
		// Convert class object to JSON object as string
		ObjectMapper objMapper = new ObjectMapper();
		
		// Using the objectMapper reference, convert to JSON object and store in a String variable
		String finalPayload = objMapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(requestPayload);
				
		// Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		// Specify base URI
		reqSpec.baseUri("https://httpbin.org/post");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(finalPayload);
		Response response = reqSpec.post();
		
		System.out.println("Status Line:- " + response.statusLine());
		response.prettyPrint();
		
		Assert.assertEquals(response.statusCode(), 200, "Check for status code:");
	}
}
