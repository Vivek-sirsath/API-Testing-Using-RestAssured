package session06;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JsonPathClassExample {

	@Test
	public void DisplayAllNodesInWeatherAPI() {

		RestAssured.baseURI = "https://api.openweathermap.org/data/2.5/weather";

		// Create request specification
		RequestSpecification httpRequest = RestAssured.given();
		httpRequest.queryParam("q", "Pune").queryParam("appid", "4a96e8b45772a63050ec646c7c89e59a");

		// Perform Get request
		Response response = httpRequest.get();

		// First get the JsonPath object instance from the Response interface
		JsonPath jsonPathEvaluator = response.jsonPath();

		// Let us print the city variable to see what we got
		System.out.println("City: " + jsonPathEvaluator.get("name"));

		// Print the temperature node

		// Temperature in Kelvin
		String tempStr = jsonPathEvaluator.get("main.temp").toString();
		// Convert String temperature to Kelvin
		double tempK = Double.parseDouble(tempStr);
		// Convert to celsius
		double tempC = (tempK - 273.15); // 24.730000000000018
		// Roundup the temprature
		double tempRounded = Math.round(tempC * 100.0) / 100.0;
		System.out.println("Temperature: " + tempRounded + "˚ C");

		// Print the humidity node
		System.out.println("Humidity: " + jsonPathEvaluator.get("main.humidity"));

		// Print weather description
		System.out.println("Pressure: " + jsonPathEvaluator.get("main.pressure"));

		// Print Wind Speed
		System.out.println("Wind Speed: " + jsonPathEvaluator.get("wind.speed"));

	}

}
