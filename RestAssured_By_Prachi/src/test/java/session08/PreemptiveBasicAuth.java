// Session # 08 - Authorization _ Basic Authentication & Digest Authentication
// This is example of Preemptive Basic Authentication.

package session08;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PreemptiveBasicAuth {

	@Test
	public void basicAuth() {

		// specify the given request
		RequestSpecification requestSpec = RestAssured.given();

		// specify the baseUri and basePath0
		requestSpec.baseUri("http://postman-echo.com");
		requestSpec.basePath("/basic-auth");

		// get request (Preemptive) Type
		// Request is provided with credentials from initially with method name
		// preemptive()
		Response response2 = requestSpec.auth().preemptive().basic("postman", "password").get();
		System.out.println("Status Line:- " + response2.getStatusLine()); // HTTP/1.1 200 OK
		System.out.println("Response Body:- " + response2.asString()); // {"authenticated": true}

	}
}
