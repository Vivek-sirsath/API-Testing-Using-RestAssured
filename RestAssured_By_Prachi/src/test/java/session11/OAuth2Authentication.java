package session11;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OAuth2Authentication {
	// https://api-m.sandbox.paypal.com/v1/oauth2/token

	static String accessToken;

	@Test
	public void getAccessToken() {

		// Store the Client ID and Client Secret in string variables which are same as
		// user name and password
		String ClientID = "AUKEtLwzuTSVNyujt2vnR49FsjboEmpbrlcMaqa-mtTJCCukSmwHANO_vs8yw2UC4bc4x1WkgtVUiK9z";
		String ClientSecret = "EKUJRN4mMpvGkU_WXUQKOYfKLFAH9PmC5DTYnNEQT8ozg4C70m6Onjny_sHCGEDRnVR5qIWoyUuHbFQN";

		// Create request specification
		RequestSpecification requestSpec = RestAssured.given();

		// specify the URL = baseUri + basePath
		requestSpec.baseUri("https://api-m.sandbox.paypal.com");
		requestSpec.basePath("/v1/oauth2/token");

		// perform basic authentication of preemptive type, using RequestSpecification reference (requestSpec)
		Response response = requestSpec.auth().preemptive()
				.basic(ClientID, ClientSecret)
				.param("grant_type", "client_credentials").post();

		// Print the Response Body
		System.out.println("Response Body:- " + response.asPrettyString());

		// Print Status Line
		System.out.println("Status Line:- " + response.getStatusLine());

		// Validate Status Code
		Assert.assertEquals(response.getStatusCode(), 200, "Check for status code:");
		System.out.println("Assertion Verified");

		// get and print access token from response body and store in a static variable
		// at class level using path(). 
		// The key it will take inside 'path()' parenthesis is 'access_token'.
		//This will be an attribute or key which will return a value as string.
		accessToken = response.getBody().path("access_token");
		System.out.println("access token:- " + accessToken);

	}

	@Test(dependsOnMethods = "getAccessToken")
	public void listInvoice() {
		// page=3&page_size=4&total_count_required=true

		Response res = RestAssured.given().auth().oauth2(accessToken)
				.queryParam("total_count_required", "true")
				.queryParam("page", 3).queryParam("page_size", 4)
				.get("https://api-m.sandbox.paypal.com/v1/invoicing/invoices");

		System.out.println("----------------------------------List Invoices------------------------------------");
		
		// Print listInvoice response
		res.prettyPrint();

		// Print Status Line
		System.out.println("Status Line:- " + res.getStatusLine());
	}

}
