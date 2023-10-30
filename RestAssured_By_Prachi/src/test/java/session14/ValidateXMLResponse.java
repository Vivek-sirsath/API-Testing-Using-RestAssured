// Session # 14 - Send XML Data As Payload In Request and Validate XML response

package session14;

import java.util.List;

import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ValidateXMLResponse {

	@Test
	public void GetTravellersData() {
		// create request Specification
		RequestSpecification requestSpec = RestAssured.given();

		// http://restapi.adequateshop.com/api/Traveler?page=1
		// specify url
		requestSpec.baseUri("http://restapi.adequateshop.com");
		requestSpec.basePath("/api/Traveler");

		// add query parameter
		requestSpec.queryParam("page", "1");

		// specify header
		requestSpec.header("accept", "application/xml");

		// perform get request
		Response response = requestSpec.get();

		response.prettyPrint();

//	    Approach 1 - Validation of XML response
//	    response.then().body("TravelerinformationResponse.travelers.Travelerinformation[2].name", Matchers.equalTo("Vano"));
//		here, we're separating each node by using dot (.)
//		2 is the index of Vano in xml body
		

//      In session06, we have used JsonPath class to get the json path from
//		jsonPathFinder if our response is in JSON format
//      Similarly, XmlPath Class is use to get the xmlPath or XPath if our response
//      is in XML Format

		// Approach 2
		XmlPath objXmlPath = new XmlPath(response.asString());

		String travelerName = objXmlPath.get("TravelerinformationResponse.travelers.Travelerinformation[0].name").toString();
		System.out.println("Traveler Name:- " + travelerName);  //  Developer
		Assert.assertEquals(travelerName, "Developer", "check for traveler name.");
		System.out.println("Presence of 'Developer' in travelers list verified");

		// Verify total travelers to be 10

		List<String> listOfTravelers = objXmlPath
				.getList("TravelerinformationResponse.travelers.Travelerinformation");

		int totalTravelerCount = listOfTravelers.size();
		System.out.println("Total Travellers:- " + totalTravelerCount);

		Assert.assertEquals(totalTravelerCount, 10, "check for total no. of traveller on page-1");
		System.out.println("traveler Count 10 Verified");

		// Create the list of all travelers 
		// (By appending a tag name - 'name' to xmlPath )
		List<String> listOfTravelersName = objXmlPath
				.getList("TravelerinformationResponse.travelers.Travelerinformation.name");

		// Print all the names in the travelers list
		// This will return the name of each traveler
		for(String list : listOfTravelersName) 
		{
			System.out.println("Name of Traveler:- " + list);
		}

		// Verify for name Vano in travelers list
		boolean found = false;
		for (String traveler : listOfTravelersName) {
			System.out.println("Name of traveler:- " + traveler);

			if (traveler.equals("vano")) {
				found = true;
				break;
			}

		}

		Assert.assertEquals(found, true);
		System.out.println("Presence of 'Vano' at 2nd index is verified");

	}

}
