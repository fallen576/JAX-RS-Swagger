package edu.jhu.webservices.gianni.benjamin.model;

import java.util.concurrent.ThreadLocalRandom;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Student {
	@XmlElement(name="firstName")
	private String firstName;
	
	@XmlElement(name="lastName")
	private String lastName;
	
	@XmlElement(name="id")
	private long id;
	
	public Student() {
		this.id = ThreadLocalRandom.current().nextLong(100);
	}
	
	public Student(String firstName, String lastName) {
		this.id = ThreadLocalRandom.current().nextLong(100);
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

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	
}
