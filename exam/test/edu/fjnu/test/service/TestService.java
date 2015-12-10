package edu.fjnu.test.service;

import org.junit.Test;

import edu.fjnu.dao.impl.TeacherDaoImpl;
import edu.fjnu.domain.Student;
import edu.fjnu.domain.Teacher;
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
		stu.setStudentID("2");
		stu.setSpassword("student");
//		StudentDaoImpl stuImpl = new StudentDaoImpl();
//		System.out.println(stuImpl.checkInfo(stu));
		StudentService stuService = new StudentService();
		if(stuService.checkInfo(stu)){
			System.out.println("成功");
		}else{
			System.out.println("失败");
		}
//		if(stuImpl.checkInfo(stu) == null){
//			System.out.println("登录失败");
//		}else{
//			System.out.println("登录成功");
//		}
	}
	
	@Test
	public void searchTeaInfo(){
		Teacher teacher = new Teacher();
		teacher.setTeacherID("01");
		teacher.setTpassword("123");
		
		TeacherDaoImpl teaImpl = new TeacherDaoImpl();
		teacher = teaImpl.teacherInfo(teacher);
		String tname = teacher.getTname();
		String course = teacher.getCourse();
		String tsex = teacher.getTsex();
		System.out.println(tname + course + tsex);
	}
}
