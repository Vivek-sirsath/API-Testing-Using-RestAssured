package session26;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

// This is a POJO class - 'Plain Old Java Object'

// 1st WAY to ignore Unknown Properties using annotation
// @JsonIgnoreProperties(ignoreUnknown = true)
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
	private boolean married;

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

	public boolean isMarried() {
		return married;
	}

	public void setMarried(boolean married) {
		this.married = married;
	}

	
}
