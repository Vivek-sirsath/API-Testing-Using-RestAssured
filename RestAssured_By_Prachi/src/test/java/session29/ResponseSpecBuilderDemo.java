/* Session # 29 - ResponseSpecification & ResponseSpecBuilder
 * 
 * What is ResponseSpecification (Interface) and ResponseSpecBuilder (Class) ?
 * 
 * ResponseSpecification (Interface) comes handy in situation where similar
 * set of assertions need to be done for several Rest Requests. 
 * We can achieve this by grouping common assertions in to a ResponseSpecBuilder (Class) instance
 * and using this instance we can validate multiple tests.
*/

package session29;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderDemo {

	ResponseSpecification responseSpec = null;
    
	@BeforeClass
	public void createResponseSpec() {

		ResponseSpecBuilder responseBuilder = new ResponseSpecBuilder();
		
		responseBuilder.expectStatusCode(200)
		               .expectStatusLine("HTTP/1.1 200 OK")
		               .expectContentType(ContentType.JSON)
		               .expectResponseTime(Matchers.lessThan(3000L));

		responseSpec = responseBuilder.build();
	}

	@Test (enabled = true)
	public void getAllBookingIds() {

		RestAssured.given()
		                   .baseUri("https://restful-booker.herokuapp.com/booking")
		            .when()
		                   .get()
		            .then()
			               .spec(responseSpec);  // using this statement we can avoid below repetitive code

//		            .statusCode(200)
//		            .statusLine("HTTP/1.1 200 OK")
//		            .contentType(ContentType.JSON)
//		            .time(Matchers.lessThan(3000L));

	}

	@Test (enabled = true)
	public void getAllBookingByName() {

		RestAssured.given()
		                   .baseUri("https://restful-booker.herokuapp.com/booking?firstname=sally")
		           .when()
		                   .get()
		           .then()
				           .spec(responseSpec);
		        
//		           .statusCode(200) 
//	               .statusLine("HTTP/1.1 200 OK")
//		           .contentType(ContentType.JSON) 
//		           .time(Matchers.lessThan(3000L));

	}
}
