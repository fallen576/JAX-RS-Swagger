package edu.jhu.webservices.gianni.benjamin.dao;

import java.util.ArrayList;

import com.sun.jersey.spi.resource.Singleton;

import edu.jhu.webservices.gianni.benjamin.model.Student;

@Singleton
public class DBHelper {
	
	private ArrayList<Student> students  = new ArrayList<Student>();
	
	public DBHelper() {
		
	}
	
	public void addStudent(Student student) {
		students.add(student);
	}
	
	public ArrayList<Student> getAllStudents() {
		return students;
	}
	
	public Student findStudentById(long id) {
		Student s = students
			.stream()
			.filter(stud -> stud.getId() == id)
			.findAny()
			.orElse(null);
		
		return s;
	}
}
