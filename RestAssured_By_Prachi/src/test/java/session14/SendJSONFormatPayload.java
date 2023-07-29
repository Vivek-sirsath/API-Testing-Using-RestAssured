package session14;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendJSONFormatPayload {

	@Test
	public void AddPet()
	{
				
		// here we are sending request data in json format as below
		String jsonData = "{\r\n"
				+ "  \"id\": 0,\r\n"
				+ "  \"category\": {\r\n"
				+ "    \"id\": 0,\r\n"
				+ "    \"name\": \"string\"\r\n"
				+ "  },\r\n"
				+ "  \"name\": \"doggie\",\r\n"
				+ "  \"photoUrls\": [\r\n"
				+ "    \"string\"\r\n"
				+ "  ],\r\n"
				+ "  \"tags\": [\r\n"
				+ "    {\r\n"
				+ "      \"id\": 0,\r\n"
				+ "      \"name\": \"string\"\r\n"
				+ "    }\r\n"
				+ "  ],\r\n"
				+ "  \"status\": \"available\"\r\n"
				+ "}";
		//create request Specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//https://petstore.swagger.io/v2/pet
		//specify url
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");
		
		//specify header
		requestSpec.header("accept","application/json"); // we can receive response in XML format by "application/xml"
		requestSpec.header("Content-Type","application/json"); // Type "application/xml" for xml request format
		requestSpec.body(jsonData); // here instead of 'jsonData' use variable 'xmlRequestBody' for xml format request
		
		 //perform POST request 
		Response response = requestSpec.post();
		
		response.prettyPrint();
		
		//verify status code
		Assert.assertEquals(response.statusCode()/*actual status code*/,/*expected status code*/200,"Check for status code");
		
		response.then().body("Pet.name", Matchers.equalTo("doggie"));
		
		
	}
}
