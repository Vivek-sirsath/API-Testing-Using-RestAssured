// Session # 28 - How To Add Header In Request

// 2nd

package session28;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class AddHeadersUsingMapInterface {
	
	@Test
	public void usingMapInterface() {
		
		Map<String,String> mapHeader = new HashMap<>();
		
		mapHeader.put("Header2.1", "Value2.1");
		mapHeader.put("Header2.2", "Value2.2");
		
		RequestSpecification requestSpec = RestAssured.given();
		// Add headers to request
		requestSpec.headers(mapHeader);
		// To log headers in console
		requestSpec.log().headers();
		// Specify base URI
		requestSpec.baseUri("https://reqres.in/api/users?page=1");
		// Perform get request
		requestSpec.get();
				
	}
}
