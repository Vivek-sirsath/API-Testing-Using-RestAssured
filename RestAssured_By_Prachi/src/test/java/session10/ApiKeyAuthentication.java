// Session # 10 - Authorization  API Key Authentication

package session10;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiKeyAuthentication {
	// https://api.openweathermap.org/data/2.5/weather?q={city name}&appid={API key}

	@Test
	public void GetWeatherDataByCity() {

		// create request specification
		RequestSpecification requestSpec = RestAssured.given();

		// specify baseUri and basePath
		requestSpec.baseUri("https://api.openweathermap.org");
		requestSpec.basePath("/data/2.5/weather");
		requestSpec.queryParam("q", "mumbai").queryParam("appid", "4a96e8b45772a63050ec646c7c89e59a");

		// perform the get request
		Response response = requestSpec.get();

		// print the Status Line and Response Body
		System.out.println("Status Line:-  " + response.getStatusLine());
		System.out.println("Response Body:- " + response.getBody().asPrettyString());

		// validate status code
		Assert.assertEquals(response.getStatusCode(), 200);
		System.out.println("^^^ Status Code Verified ^^^");

	}

}
