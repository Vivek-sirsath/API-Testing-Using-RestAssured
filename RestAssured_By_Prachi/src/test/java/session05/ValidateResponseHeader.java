package session05;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateResponseHeader {

	@Test
	public void GetSingleUser() {
		// Get Request Specification
		RequestSpecification reqSpec = RestAssured.given();

		// Specify base URI
		reqSpec.baseUri("https://reqres.in");
		reqSpec.basePath("/api/users/2");

		// Form Get request
		Response resp = reqSpec.get();

		// Validate response Header
		String contentType = resp.getHeader("Content-Type");
		System.out.println("Value of content-type: " + contentType);

		String connection = resp.getHeader("connection");
		System.out.println("Value of connection: " + connection);
		System.out.println(" ");

		// Read all headers and print their respective values
		Headers headersList = resp.getHeaders();

		// Iterate over headers list
		for (Header header : headersList) {
			System.out.println(header.getName() + " : " + header.getValue());
		}
	}

}
