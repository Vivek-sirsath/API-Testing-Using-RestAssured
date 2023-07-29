package session14;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SendXmlFormatPayload {

	@Test
	public void AddPet()
	{
		// here we are sending request data in XML format as below
		String xmlRequestBody="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n"
				+ "<Pet>\r\n"
				+ "	<id>0</id>\r\n"
				+ "	<Category>\r\n"
				+ "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n"
				+ "	</Category>\r\n"
				+ "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n"
				+ "		<photoUrl>string</photoUrl>\r\n"
				+ "	</photoUrls>\r\n"
				+ "	<tags>\r\n"
				+ "		<Tag>\r\n"
				+ "			<id>0</id>\r\n"
				+ "			<name>string</name>\r\n"
				+ "		</Tag>\r\n"
				+ "	</tags>\r\n"
				+ "	<status>available</status>\r\n"
				+ "</Pet>";
		
		//create request Specification
		RequestSpecification requestSpec = RestAssured.given();
		
		//https://petstore.swagger.io/v2/pet
		//specify url
		requestSpec.baseUri("https://petstore.swagger.io");
		requestSpec.basePath("/v2/pet");
		
		//specify header
		requestSpec.header("accept","application/xml"); // we can receive response in JSON format by "application/json"
		requestSpec.header("Content-Type","application/xml"); // Type "application/json" for JSON request format
		requestSpec.body(xmlRequestBody); // here instead of 'xmlRequestBody' use variable 'jsonData' for JSON request
		//perform post request 
		Response response = requestSpec.post();
		
		response.prettyPrint();
		
		//verify status code
		Assert.assertEquals(response.statusCode()/*actual status code*/,/*expected status code*/200,"Check for status code");
		
		response.then().body("Pet.name", Matchers.equalTo("doggie"));
		
		
	}
}
