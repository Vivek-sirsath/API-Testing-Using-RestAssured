// Session # 08 - Authorization _ Basic Authentication & Digest Authentication
// Default basic authentication is Non-Preemptive Authentication
// Unless and until we don't mention Preemptive word in code it is Default Basic Auth
// Base64 encoding is used to encode Username and password..


package session08;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class NonPreemptiveBasicAuth {

	@Test
	public void basicAuth() {

		// specify the given request
		RequestSpecification requestSpec = RestAssured.given();

		// specify the baseUri and basePath
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");

		// perform get request (non-preemptive) Type with valid credentials
		Response response = requestSpec.auth().basic("postman", "password").get(); // If type passwor then Status Line:-
																					// HTTP/1.1 401 Unauthorized
		// print status line
		System.out.println("Status Line:- " + response.getStatusLine()); // HTTP/1.1 200 OK
		System.out.println("Response Body:- " + response.body().asString()); // {"authenticated": true}

	}

}
