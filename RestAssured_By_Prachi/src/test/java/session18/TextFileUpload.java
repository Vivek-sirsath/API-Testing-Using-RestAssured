// Session # 18 - How To Upload File In Rest Assured

package session18;

import java.io.File;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TextFileUpload {
	
	@Test
	public void uploadTextFile() {
		
		// Create File Class object & store the path of text file
		File demoFileUpload = new File("C:\\Users\\Admin\\Desktop\\demoFile.txt");
		File demoFileUpload2 = new File("C:\\Users\\Admin\\Desktop\\demoFile2.txt");
		
		// Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		// Specify URL
		reqSpec.baseUri("https://httpbin.org/post");
		reqSpec.multiPart("file", demoFileUpload);
		reqSpec.multiPart("file2", demoFileUpload2);
	
		// Interview que:- While we upload a file, what value we specify in content type?
		// Ans: multipart/form-data
		
		// We can also specify 'multipart/form-data' explicitly as contentType()
		reqSpec.contentType("multipart/form-data");
		
		// Perform POST request
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		// Validate the Status Code
		Assert.assertEquals(response.getStatusCode(), 200, "Check for status code:");
			
	}
}
