
/* We can use @JsonIgnore annotation of Jackson API Library to exclude/eliminate field of
   POJO class from Serialization and Deserialization process
*/

package session25;

import org.testng.annotations.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIgnoreSerializationDeserialization {

	@Test
	public void testMethod() throws JsonProcessingException {
		
		// Create Object of POJO Class
		PojoClassEmployee emp1 = new PojoClassEmployee(); 
		
		emp1.setFirstname("Ishita");
		emp1.setLastname("Shirsath");
		emp1.setGender("Female");
		emp1.setAge(20);
		emp1.setSalary(90000);
		emp1.setMarried(false);
		emp1.setFullname("Ishita Shirsath");  // If we wish to exclude fullname : In POJO class use @JsonIgnore annotation
		
		// To convert employee class object to JSON Pay-load 
		// Serialization : Class Object >> JSON Data
		
		ObjectMapper objMapper = new ObjectMapper();
		String jsonPayload = objMapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(emp1);          // JsonProcessingExceptio at this line
		
		System.out.println("----------------- After Serialization : Class Object >> Json Data -------------");
		System.out.println("JSON DATA:- " + jsonPayload);
		
		// To convert JSON String pay-load to employee class object
		// Deserialization : JSON Data >> Class Object
		
		String jsonData = "{\r\n"
				+ "  \"firstname\" : \"Ishita\",\r\n"
				+ "  \"lastname\" : \"Shirsath\",\r\n"
				+ "  \"age\" : 20,\r\n"
				+ "  \"gender\" : \"Female\",\r\n"
				+ "  \"salary\" : 90000.0,\r\n"
				+ "  \"fullname\" : \"Ishita Shirsath\",\r\n"
				+ "  \"married\" : false\r\n"
				+ "}";
		
		// Convert JSON String pay-load to employee class object
		PojoClassEmployee emp2 = objMapper.readValue(jsonData, PojoClassEmployee.class);
		
		System.out.println("----------------- After Deserialization : Json Data >> Class Object -------------");
		System.out.println("First Name:- " + emp2.getFirstname());
		System.out.println("Last Name:- " + emp2.getLastname());
		System.out.println("Age:- " + emp2.getAge());
		System.out.println("Gender:- " + emp2.getGender());
		System.out.println("Salary:- " + emp2.getSalary());
		System.out.println("Is Married? " + emp2.isMarried());
		System.out.println("Full Name:- " + emp2.getFullname());
				
	}
}
