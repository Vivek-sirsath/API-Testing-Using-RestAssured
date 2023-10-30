// Session # 24 - Ignore Empty, Null & Default Values In Payload (@JsonInclude)

package session24;

import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonInclude;

 @JsonInclude(JsonInclude.Include.NON_DEFAULT)
// @JsonInclude(JsonInclude.Include.NON_NULL)
// @JsonInclude(JsonInclude.Include.NON_EMPTY)
public class employeePojoClass { 

	private String firstname;
	private String lastname;
	private int age;
	private String gender;
	private double salary;
	private boolean isMarried;
	private String[] hobbies;
	private List<String> qualifications;
	private Map<String,String> familyMembers; 
	
		
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
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public List<String> getQualifications() {
		return qualifications;
	}
	public void setQualifications(List<String> qualifications) {
		this.qualifications = qualifications;
	}
	public Map<String, String> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Map<String, String> familyMembers) {
		this.familyMembers = familyMembers;
	}
			
}
