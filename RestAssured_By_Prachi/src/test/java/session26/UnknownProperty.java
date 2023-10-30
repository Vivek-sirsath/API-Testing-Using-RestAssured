// Session # 26 - Ignore Unknown Properties During Deserialization Process

/* How to ignore Unknown Properties?
 * 1) Using @JsonIgnoreProperties annotation
 * 2) Using ObjectMapper Class object
 */

package session26;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UnknownProperty {

	@Test
	public void testUnknownProperty() throws JsonMappingException, JsonProcessingException {
		
		String jsonData = "{\r\n"
				+ "  \"firstname\" : \"Ishita\",\r\n"
				+ "  \"lastname\" : \"Shirsath\",\r\n"
				+ "  \"age\" : 20,\r\n"
				+ "  \"gender\" : \"Female\",\r\n"
				+ "  \"salary\" : 90000.0,\r\n"				
				+ "  \"married\" : false,\r\n"
				+ "  \"fullname\" : \"Ishita Shirsath\"\r\n"   // This line is added later (Unknown property to POJO class)
				+ "}";
		
		// Deserialization
		ObjectMapper objMapper = new ObjectMapper();
		// 2nd WAY to ignore unknown properties of POJO Class using ObjectMapper Class object
		objMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);   
		// Try true : (Error comes and Test Fails) : Unrecognized field "fullname" (class session26.Employee),
		//not marked as ignorable (6 known properties: "lastname", "married", "salary", "firstname", "age", "gender"])
		
		Employee emp = objMapper.readValue(jsonData, Employee.class);
		
		System.out.println("----------------- After Deserialization : Json Data >> Class Object -------------");
		System.out.println("First Name:- " + emp.getFirstname());
		System.out.println("Last Name:- " + emp.getLastname());
		System.out.println("Age:- " + emp.getAge());
		System.out.println("Gender:- " + emp.getGender());
		System.out.println("Salary:- " + emp.getSalary());
		System.out.println("Is Married? " + emp.isMarried());
		
		System.out.println("*** DESERIALIZATION SUCCESSFUL ***");
		
	}
}
