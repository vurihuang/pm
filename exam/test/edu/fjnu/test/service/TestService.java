package edu.fjnu.test.service;

import org.junit.Test;

import edu.fjnu.domain.Student;
import edu.fjnu.service.StudentService;

public class TestService {
	
	@Test
	public void testStudentService(){
		Student student = new Student();
		student.setSname("admin");
		student.setSpassword("admin");
		StudentService stuService = new StudentService();
		stuService.checkInfo(student);
	}
	
}
