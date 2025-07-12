// Session # 03 - How Rest Assured Works  Create HTTP Request

package session03;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class Test_DeleteMethod {
	@Test
	public void test06() 
	{
		RestAssured.baseURI="https://reqres.in/api/users/312";
		RestAssured.given().header("x-api-key", "reqres-free-v1").
		when().delete().
		then().statusCode(204).log().all();
		
	}

}
