package org.dev;

import java.io.Serializable;
import org.springframework.data.annotation.Id;

public class Person implements Serializable {	
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private String phone;
	private String company;
	private String project;
	
	private static final long serialVersionUID = -9164506877214769460L;
	
	public String getId() {
		return id;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getCompany() {
		return company;
	}
	public String getProject() {
		return project;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public void setProject(String project) {
		this.project = project;
	}	
}
