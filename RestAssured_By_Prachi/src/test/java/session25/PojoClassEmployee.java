// Session # 25 - Ignore Fields from POJO Class From Serialization&Deserialization

package session25;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

// @JsonInclude(JsonInclude.Include.NON_DEFAULT)
// @JsonInclude(JsonInclude.Include.NON_NULL)
// @JsonInclude(JsonInclude.Include.NON_EMPTY)

//@JsonIgnoreProperties(value = { "gender", "fullname" }, allowGetters = false) // Used to ignore multiple properties/variables
public class PojoClassEmployee {

	private String firstname;
	private String lastname;
	private int age;
	private String gender;
	private double salary;
	private boolean isMarried;
	
//	@JsonIgnore
//	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	 @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String fullname;

/*	
   ---------------- [WE CAN USE ANY ONE OF THESE 3 ANNOTATION] --------------------
  
1) @JsonIgnore 
                 This annotation excludes single property/variable (full name) in O/P
				 @JsonIgnore is more power full than below annotation (@JsonProperty).
				  
2)	@JsonProperty(access = JsonProperty.Access.READ_ONLY) 
	 'fullname' will be present in Serialization(Json Data) BUT not in Deserialization(Class Object) in O/P
	
3) @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)	
	 'fullname' will not present in Serialization(Json Data) BUT present in Deserialization(Class Object) in O/P
	 
*/
	
	 
	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public boolean isMarried() {
		return isMarried;
	}

	public void setMarried(boolean isMarried) {
		this.isMarried = isMarried;
	}

	public String getFullname() {
		return fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

}
