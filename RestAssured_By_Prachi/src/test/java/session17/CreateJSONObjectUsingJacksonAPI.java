// Session # 17 - How To Create A JSON Object Using Jackson API

package session17;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Map.Entry;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateJSONObjectUsingJacksonAPI {

	@Test
	public void createUser() throws JsonProcessingException {
		
		// Create ObjectMapper Instance
		ObjectMapper objectMapper = new ObjectMapper();
		
		// Create Object Node i.e. json node 
		ObjectNode userDetails = objectMapper.createObjectNode();
		userDetails.put("firstName", "Vivek");
		userDetails.put("lastName", "Shirsath");
		userDetails.put("age", 28);
		userDetails.put("salary", 58700);
		userDetails.put("IsMarried", true);
		userDetails.set
		("Hobbies", objectMapper.convertValue(Arrays.asList("Music","Games"),JsonNode.class));
		
		// Create Nested Object Node using ObjectNode class
		ObjectNode keySkill = objectMapper.createObjectNode();
		keySkill.put("Programming Skill", "Java");
		keySkill.put("WebAutomation", "Selenium");
		keySkill.put("API Testing", "Rest Assured");
		
		userDetails.set("TechSkills", keySkill);
		
		// To Print JSON object - 'userDetails' as String 
		// (Exception to be handled - 'JsonProcessingException')
		String userDetailsAsString = objectMapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(userDetails);
		System.out.println("Created JSON node is:- " + userDetailsAsString);
		
		// To Retrieve the Field Values
		String firstName = userDetails.get("firstName").asText();
		System.out.println("Value of the firstName field is:- " + firstName);
		
		int sal = userDetails.get("salary").asInt();
		System.out.println("Value of the salary field is:- " + sal);
		
		Boolean maritalstatus = userDetails.get("IsMarried").asBoolean();
		System.out.println("Is married?:- " + maritalstatus);
		
		// To retrieve the value of 'Programming Skill'
		String programmingSkillsValue = userDetails.get("TechSkills").get("Programming Skills").asText();
		System.out.println("Value of Programming Skills:- " + programmingSkillsValue);
		
		// To retrieve the value of 'WebAutomation' 
		String webAutomationValue = userDetails.get("TechSkills").get("WebAutomation").asText();
		System.out.println("Value of the WebAutomation:- " + webAutomationValue);
		
		// To print all the field names/ keys using Iterator Interface and fieldNames() method
		// We've used fieldNames() method to get the names.
		System.out.println(" ");
		System.out.println("********   All Keys   ********");
		Iterator <String> allFieldNames = userDetails.fieldNames();		
		while(allFieldNames.hasNext()) 
		{
			System.out.println(allFieldNames.next());			
		}
		
		// To print all the values using Iterator Interface and elements() method
		// Here for values we need to use DataType as <JsonNode>
		// We've used the elements() method to get the values.
		System.out.println(" ");
		System.out.println("********   All Values   ********");
		Iterator<JsonNode> allValues = userDetails.elements();	
		while(allValues.hasNext()) 
		{
			System.out.println(allValues.next());			
		}
		
		// If we wish to print all Keys and Values together
		// using Iterator Interface, Entry Interface and fields() method
		System.out.println(" ");
		System.out.println("********   Key-Value Pairs   ********");
		Iterator<Entry<String,JsonNode>> allkeyValues = userDetails.fields();
		while(allkeyValues.hasNext()) 
		{
			Entry<String, JsonNode> entry = allkeyValues.next();
			System.out.println(entry.getKey() + " --- " + entry.getValue());
		}
		
		// To remove the node/entry 'firstName'
		String firstNameValue = userDetails.remove("firstName").asText();
		System.out.println("Removed firstname value is:- " + firstNameValue);
		
		// After Removing - Print userDetails JSON object as String		
		String afterRemovingFirstNameValue = objectMapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(userDetails);
		System.out.println("JSON Object Node after removing first name value:- " + afterRemovingFirstNameValue);
		
		// To update the node/entry 'lastName'		
		userDetails.put("lastName", "Malhotra");
		// To update Nested Object node 'Programming Skill' by 'C#'
		keySkill.put("Programming Skill", "C#");
		
		// After Updating - Print userDetails JSON object as String	
		String afterUpdatingLastNameValue = objectMapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(userDetails);
		System.out.println("JSON Object Node after updating last name value:- " + afterUpdatingLastNameValue);
		
		// Create Request Specification
		RequestSpecification reqSpec = RestAssured.given();
		
		// Specify what the request is consists of like baseURI, Content-Type, Body
		reqSpec.baseUri("https://reqres.in/api/users");
		reqSpec.contentType(ContentType.JSON);
		reqSpec.body(userDetails);
		
		// Perform POST request
		Response response = reqSpec.post();
		
		response.prettyPrint();
		
		// Validate Status Code
		Assert.assertEquals(response.statusCode(), 201, "Check for status code:");
		System.out.println("Status Code - 201 Verified");		
		
	}	
}
