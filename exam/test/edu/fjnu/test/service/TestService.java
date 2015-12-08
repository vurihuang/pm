package edu.fjnu.test.service;

import org.junit.Test;

import edu.fjnu.dao.impl.StudentDaoImpl;
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
	
	@Test
	public void fun(){
		String abc = "223";
		
		if(abc.substring(0 ,1).equals("1")){
			System.out.println("ok");
		} else if (abc.substring(0,1).equals("2")){
			System.out.println("error");
		}else{
			System.out.println("none");
		}
//		System.out.println(abc.substring(0,2));
	}
	
	@Test
	public void checkInfo(){
		Student stu = new Student();
		stu.setStudentID("1");
		stu.setSpassword("student");
		StudentDaoImpl stuImpl = new StudentDaoImpl();
		System.out.println(stuImpl.checkInfo(stu));
		
//		if(stuImpl.checkInfo(stu) == null){
//			System.out.println("登录失败");
//		}else{
//			System.out.println("登录成功");
//		}
	}
}
