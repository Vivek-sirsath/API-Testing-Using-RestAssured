package session03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Test_GetUser312 {

	@Test
	public void TestUser312() {

		RequestSpecification reqSpec = RestAssured.given();
		reqSpec.header("x-api-key", "reqres-free-v1");

		Response response = reqSpec.get("https://reqres.in/api/users/312");
		System.out.println("Response Body: " + response.getBody().asPrettyString());
	}

}
