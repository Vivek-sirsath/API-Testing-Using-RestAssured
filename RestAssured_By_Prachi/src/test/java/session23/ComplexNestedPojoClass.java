// Session # 23 - How To Create POJO Class of Complex Nested JSON Object

package session23;

import java.util.List;

import session22.EmployeePojoClass;

public class ComplexNestedPojoClass {
	
/*
"companyName" : "XYZ Ltd",
"Street" : "SB Street",
"City" : "Pune",
"State" : "Maharashtra",
"Pin code" : "349225",
"Bank Accounts" : ["HDFC","SBI","AXIS"],
*/
	
	// Create private variables
	private String companyName;
	private String street;
	private String city;
	private String state;
	private int pincode;
	private List< String > bankAccount;
	
	private List<EmployeePojoClass> employeeList;
	
	
	// Create getters and setters methods for private variables

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	public List<String> getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(List<String> bankAccount) {
		this.bankAccount = bankAccount;
	}

	public List<EmployeePojoClass> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeePojoClass> employeeList) {
		this.employeeList = employeeList;
	}
	
}
