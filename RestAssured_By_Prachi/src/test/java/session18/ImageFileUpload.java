package session18;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ImageFileUpload {
	
	// https://petstore.swagger.io/v2/pet/01/uploadImage
	//File Path : F:\Automation Videos\Automation By Prachi Gupta (Hindi)\API Testing Rest Assured (Hindi)\demoIMG.jpg

	@Test
	public void uploadImageFile() {
		
		// Specify image file path
		File demoImageFile = new File("C:\\Users\\Admin\\Desktop\\demoIMG.jpg");
		
		// Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		reqSpec.baseUri("https://petstore.swagger.io/v2/pet/01/uploadImage");
		reqSpec.multiPart("file",demoImageFile);
		reqSpec.contentType("multipart/form-data");
		
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		Assert.assertEquals(response.getStatusCode(), 200, "Check for status code");
		System.out.println("Status Code 200 - Verified");		
	}
}
