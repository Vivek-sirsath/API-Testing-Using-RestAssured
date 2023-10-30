// Session # 20 - Create POJO Class of JSON data Serialization Deserialization

package session20;

// This is a POJO class - 'Plain Old Java Object'
public class Employee {

	/*
	 * firstName - String 
	 * lastName - String 
	 * age - int 
	 * gender - String 
	 * salary - double
	 */

	private String firstname;
	private String lastname;
	private int age;
	private String gender;
	private double salary;

	// Create getters and setters mathods

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

}
