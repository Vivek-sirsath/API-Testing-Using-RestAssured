// Session # 08 - Authorization _ Basic Authentication & Digest Authentication

package session08;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DigestAuth {

	@Test
	public void digestAuth() {
		// http://httpbin.org/digest-auth/undefined/vivek/1234

		// specify the given request
		RequestSpecification requestSpec = RestAssured.given();

		// specify the baseUri and basePath
		requestSpec.baseUri("http://httpbin.org");
		requestSpec.basePath("/digest-auth/undefined/vivek/1234");

		// Create Get request with digest authentication credentials
		Response response = requestSpec.auth().digest("vivek", "1234").get(); // If user-name or password wrong then Status Line:- // HTTP/1.1 401 UNAUTHORIZED

		// print status line
		System.out.println(" Digest Auth Status Line:- " + response.getStatusLine()); // HTTP/1.1 200 OK
		System.out.println("Digest Auth Response Body:- " + response.body().asString());
		/*
		    {
              "authenticated": true,
              "user": "vivek"
            }
		 */

		// Validate response code
		Assert.assertEquals(response.getStatusCode(), 200, "Check for status code");
		System.out.println("***Assertion Verified***");

	}

}
