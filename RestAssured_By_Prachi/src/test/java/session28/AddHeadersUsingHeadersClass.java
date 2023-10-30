// Session # 28 - How To Add Header In Request

// 4th

/* Here, We'll create multiple header objects by using 'Header' Class.
 * Then we'll create list of headers and add them to the Request using headers() method 
*/

package session28;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class AddHeadersUsingHeadersClass {

	@Test
	public void usingHeadersClass() {
		
		Header header1 = new Header("Header1", "Value1");
		Header header2 = new Header("Header2", "Value2");
		Header header3 = new Header("Header3", "Value3");
		
		// Create list of headers using List Interface and ArrayList
		List<Header> headerList = new ArrayList<Header>();
		headerList.add(header1);
		headerList.add(header2);
		headerList.add(header3);
		
		// Create Headers Class object and add headerList in it as an argument to its constructor
		Headers headersClassObj = new Headers(headerList);
		
		// Create Request Specification
		RequestSpecification requestSpec = RestAssured.given();
		// Specify base URI
		requestSpec.baseUri("https://reqres.in/api/users?page=1");
		// Add headers to request using Headers Class Object
		requestSpec.headers(headersClassObj);
		// To log headers in console
		requestSpec.log().headers();
		// Perform get request
		Response response = requestSpec.get();
		
		// Validate Status Code
		Assert.assertEquals(response.statusCode(), 200, "Status code check:");
		System.out.println("Assertion Verified");
		
	}
}
