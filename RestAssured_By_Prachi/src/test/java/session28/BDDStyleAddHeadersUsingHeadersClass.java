// Session # 28 - How To Add Header In Request

// 5th

// Here We'll use 'Headers' Class to add multiple headers to the Request

package session28;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;

public class BDDStyleAddHeadersUsingHeadersClass {

	@Test
	public void usingHeadersClass() {
		
		Header header1 = new Header("Header1", "Value1");
		Header header2 = new Header("Header2", "Value2");
		Header header3 = new Header("Header3", "Value3");
		
		
		List<Header> headersList = new ArrayList<Header>();
		headersList.add(header1);
		headersList.add(header2);
		headersList.add(header3);
		
		Headers headersClassObj = new Headers(headersList);
		
		// BDD (Given, When, Then)
		RestAssured
		.given()
		        .headers(headersClassObj)
		        .log().headers()
		.when()
		        .get("https://reqres.in/api/users?page=1")
		 .then()
		        .log()
		        .body();
		
	}
}
