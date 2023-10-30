// Session # 24 - Ignore Empty, Null & Default Values In Payload (@JsonInclude)

package session24;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonIncludeAnnotation {

	/*
	 * firstname = Vivek,
	 * lastname = Shirsath,
	 * gender = male,
	 * age = 35,
	 * salary = 58000.42,
	 * isMarried = true
	 */

	@Test
	public void testMethod1() throws JsonProcessingException {

		// Create pay-load
		// For this we need to create the object of POJO class

		employeePojoClass emp1 = new employeePojoClass();
		emp1.setFirstname("Vivek");
//		 emp1.setLastname("Shirsath");
//		 emp1.setGender("Male");
		emp1.setAge(35);
		emp1.setSalary(58000.42);
		emp1.setMarried(true);

		// Try Empty Array
		String[] hobbies = new String[2];
		hobbies[0] = "Reading";
//		hobbies[1] = "Muzic";
		emp1.setHobbies(hobbies);

		// Try Empty List
		List<String> qualifications = new ArrayList<String>();
		qualifications.add("BCA");
//		qualifications.add("MCA");
		emp1.setQualifications(qualifications);

		// Try Empty Map
		Map<String, String> familyMembers = new HashMap<>();
		familyMembers.put("1", "Mother");
//		familyMembers.put("2", "Father");
		emp1.setFamilyMembers(familyMembers);

		// Convert employee class object to jSON string
		ObjectMapper objMapper = new ObjectMapper();
		String employeeJSON = objMapper
				.writerWithDefaultPrettyPrinter()
				.writeValueAsString(emp1);   // Exception at this line

		System.out.println(employeeJSON);

		/*
		 * If we do not set any value then at the time of conversion - Then console output
		 * will be ("gender" : "null"), ("age" : 0),("married" : false) It shows
		 * defaults values. We can ignore these default values using annotation in POJO
		 * CLASS at class level-
		 * 
		 * @JsonInclude(JsonInclude.Include.NON_DEFAULT) >>> 
		 * { 
		 *   "firstname" : "Vivek",
		 *   "salary" : 58000.42 
		 * }
		 * 
		 * @JsonInclude(JsonInclude.Include.NON_NULL) >>> 
		 * { 
		 *   "firstname" : "Vivek", 
		 *   "age" : 35, 
		 *   "salary" : 58000.42,
		 *   "married" : false 
		 * }
		 * 
		 * @JsonInclude(JsonInclude.Include.NON_EMPTY) >>> 
		 * { 
		 *   "firstname" : "Vivek",
		 *   "age" : 35, 
		 *   "salary" : 58000.42,
		 *   "married" : false 
		 * }
		 * 
		 * After adding values to Array, List, Map >>> 
		 * {
		 *  "firstname" : "Vivek",
		 *  "age" : 35,
		 *  "salary" : 58000.42, 
		 *  "hobbies" : [ "Reading", "Muzic" ],
		 *  "qualifications" : ["BCA", "MCA" ],
		 *  "familyMembers" : { "1" : "Mother", "2" : "Father" },
		 *  "married" : true 
		 * }
		 */

	}

}
