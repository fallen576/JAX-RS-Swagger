package edu.jhu.webservices.gianni.benjamin.model;

import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.annotation.XmlElement;

public class InsertStudent {
	@XmlElement(name="firstName")
	private String firstName;
	
	@XmlElement(name="lastName")
	private String lastName;
	
	public InsertStudent() {
		
	}	

	public InsertStudent(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

}
