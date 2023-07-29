package session19;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class OwnAPITesting {

	@BeforeClass
	public void setupDefault()
	{
		//create request specification
		RequestSpecification requestSpec = RestAssured.given();

		//specify url
		requestSpec.baseUri("http://localhost:3000");
		requestSpec.basePath("/posts");

		RestAssured.requestSpecification = requestSpec;
	}

	@Test
	public void readBookStock()
	{
		//perform GET request
		Response response = RestAssured.get();

		//print response body
		System.out.println("Response Body of Book Stock");
		response.prettyPrint();

		//validate status code
		Assert.assertEquals(response.statusCode(), 200,"Check for status code.");
	}

	@Test(enabled=true)
	public void addBook()
	{
		// Create JSON Object
		JSONObject jsonData = new JSONObject();
		jsonData.put("id", 2);
		jsonData.put("title", "Mrugjal");
		jsonData.put("author", "XYZ");

		//perform POST request
		Response response=	RestAssured.given()
				.header("Content-type","application/json")
				.contentType(ContentType.JSON)
				.body(jsonData.toJSONString())
				.post();

		//print response body
		System.out.println("Response Body of addBook");
		response.prettyPrint();

		//validate status code
		Assert.assertEquals(response.statusCode(), 201,"Check for status code.");
	}

	@Test(enabled=true)
	public void updateBook()
	{
		// Create JSON Object reference to Update Book

		JSONObject jsonData = new JSONObject();
		jsonData.put("title", "The Secret");
		jsonData.put("author", "Rhonda Byrne");

		//perform PUT request
		Response response=	RestAssured.given()
				.header("Content-type","application/json")
				.contentType(ContentType.JSON)
				.body(jsonData.toJSONString())
				.put("/2");

		//print response body
		System.out.println("Response Body of updateBook");
		response.prettyPrint();

		//validate status code
		Assert.assertEquals(response.statusCode(), 200,"Check for status code.");

	}

	@Test(enabled=false)
	public void deleteBook()
	{
		
		//perform delete request
		Response response=	RestAssured.delete("/2");

		//print response body
		System.out.println("Response Body of deleteBook");
		response.prettyPrint();

		//validate status code
		Assert.assertEquals(response.statusCode(), 200,"Check for status code.");
	}
}