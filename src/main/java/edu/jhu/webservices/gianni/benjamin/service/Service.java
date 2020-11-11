package edu.jhu.webservices.gianni.benjamin.service;

import java.util.HashMap;
import java.util.Map;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import com.wordnik.swagger.annotations.Api;
import com.wordnik.swagger.annotations.ApiOperation;
import com.wordnik.swagger.annotations.ApiParam;
import edu.jhu.webservices.gianni.benjamin.model.*;

@Path("/studentservice")
@Consumes(MediaType.APPLICATION_JSON)
@Api(value="studentservice", description="Sample hello world application - for 605.785 class ")
public class Service {
	
	private static Map<Long, Student> DB = new HashMap<>(); 	
	
	@POST
	@ApiOperation(value="Insert a student")
	@Path("/insert")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response addStudent(@ApiParam(value = "Takes two paramaters firstName and lastName. Click Model Schema for an example", required = true) InsertStudent student) {
		Student s = new Student(student.getFirstName(), student.getFirstName());
		DB.put(s.getId(), s);
		System.out.println("student added " + DB.size());
		return Response
				.status(200)
				.entity(s)
				.build();
		
	}
	
	@POST
	@ApiOperation(value="Retrieve a student")
	@Path("/get")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response addStudent(@ApiParam(value = "Takes one paramater id. Click Model Schema for an example", required = true) GetStudent student) {
		try {
		System.out.println("id is " + student.getId() + " student size is " + DB.size());
		Student tmp = DB.get(student.getId());
		
		if (tmp == null) {
			return Response
					.status(400)
					.entity("Invalid ID")
					.build();
		}
		return Response
				.status(200)
				.entity(tmp)
				.build();
		} catch (Exception e) {
			return Response
					.status(400)
					.entity("Invalid operands. Please provide an ID")
					.build();
		}
	}
	
	@GET
	@ApiOperation(value="Retrieves all students")
	@Path("/getAll")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response addStudent() {
		return Response
				.status(Status.OK)
				.entity(DB)
				.build();
		
	}
	
	@POST
	@ApiOperation(value="Removes a student")
	@Path("/delete")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response delStudent(@ApiParam(value = "Takes one paramater id. Click Model Schema for an example", required = true) GetStudent student) {
		DB.remove(student.getId());
		return Response
				.status(Status.OK)
				.build();
		
	}
	
	@POST
	@ApiOperation(value="Updates a student")
	@Path("/update")
	@Produces({ MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })
	public Response updateStudent(@ApiParam(value = "Takes 3 paramaters id, firstName and lastName. You cannot change the id of an existing user. Click Model Schema for an example", required = true) Student student) {
		Student s = DB.get(student.getId());
		if (s == null) {
			return Response
					.status(400)
					.entity("Invalid ID")
					.build();
		}
		s.setFirstName(student.getFirstName());
		s.setLastName(student.getLastName());
		return Response
				.status(Status.OK)
				.entity(s)
				.build();
		
	}
	
	
	
}
	