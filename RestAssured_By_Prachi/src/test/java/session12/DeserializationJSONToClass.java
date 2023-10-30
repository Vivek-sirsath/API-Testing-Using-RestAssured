// Session # 12 - Deserialize the JSON Response

package session12;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class DeserializationJSONToClass {
	// https://reqres.in/api/users

	@Test
	public void createUser() {

		// create request specification
		RequestSpecification requestSpec = RestAssured.given();

		// specify baseUri and basePath
		requestSpec.baseUri("https://reqres.in");
		requestSpec.basePath("/api/users");

		// create request body using JSONObject class
		JSONObject jsonData = new JSONObject();
		jsonData.put("name", "Vivek"); // This data is in Hashmap Format
		jsonData.put("job", "QA"); // This data is in Hashmap Format , we need to sent it in JSON format

		// create post request
		Response response = requestSpec.contentType(ContentType.JSON).body(jsonData.toJSONString()).post();

		// store the response body received from getBody() method in a variable using
		// ResponseBody Interface
		ResponseBody responseBody = response.getBody();

		// Now we have to convert the JSON data into class object which stored in
		// responseBody variable
		// Deserialize responseBody i.e. Conversion of JSON response body to class 
		// object (respClass) of class (JSONPostResponse)

		// Statement for deserialization
		JSONPostResponse respClass = responseBody.as(JSONPostResponse.class);

		// - Class<T> is a generic form of any class of type T which is also referred to
		//   as template class.
		//   Here T stands for Template
		// - as() method performs two important tasks
		//   First it will create instance of JSONPostResponse class.
		//   Second it will fill the values in all nodes(members) in response of post
		//   method which stored in responseBody variable of JSONPostResponse class.
		// - Will assign all the values to all the String members present in
		//   JSONPostResponse class.

		// Validate "name","job" from response stored in JSONPostResponse class members
		Assert.assertEquals(respClass.name, "Vivek", "Check for name:");
		Assert.assertEquals(respClass.job, "QA", "Check for job:");
		System.out.println("Assertions Verified");

		// Print name, job ,id stored in JSONPostResponse class members
		System.out.println(respClass.name);
		System.out.println(respClass.job);
		System.out.println(respClass.id);

	}

}
