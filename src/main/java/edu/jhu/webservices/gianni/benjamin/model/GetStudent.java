package edu.jhu.webservices.gianni.benjamin.model;

import javax.xml.bind.annotation.XmlElement;

public class GetStudent {
	
	@XmlElement(name="id")
	private long id;

	public GetStudent() {
		
	}
	
	public GetStudent(long id) {
		super();
		this.id = id;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
}
