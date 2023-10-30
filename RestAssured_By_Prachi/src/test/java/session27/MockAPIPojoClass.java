//Session # 27 - Mock API Easily Convert JSON Response To POJO Class Object

package session27;

import java.util.Map;

public class MockAPIPojoClass {
	
	
/*
  {
    "firstname": "Vivek",
    "lastname" : "Shirsath",
    "age": 35,
    "salary": 58000.42,
    "hobbies": [
        "Reading",
        "Music"
    ],
    "familyMembers": {
        "1": "Mother",
        "2": "Father"
    },
    "married": true
  }
 
*/

	private String firstname;
	private String lastname;
	private int age;
	private double salary;
	private String[] hobbies;
	private Map<String,String> familyMembers;
	private boolean married;
	
	
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
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	public Map<String, String> getFamilyMembers() {
		return familyMembers;
	}
	public void setFamilyMembers(Map<String, String> familyMembers) {
		this.familyMembers = familyMembers;
	}
	public boolean isMarried() {
		return married;
	}
	public void setMarried(boolean married) {
		this.married = married;
	}
		
}
