package edu.fjnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.Student;
import edu.fjnu.service.StudentService;

/**
 * Servlet implementation class StudentServlet
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public StudentService studentService = new StudentService();
	
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = CommonUtils.toBean(request.getParameterMap(), Student.class);
		studentService.checkInfo(student);
		return "f:/index/test.jsp";
	}
	
	public String stuInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		HttpSession session = request.getSession();
		Student student = new Student();
		
		student.setStudentID((String)session.getAttribute("userID"));
		student.setSpassword((String)session.getAttribute("password"));
		
		student = studentService.studentInfo(student);
		
		String studentName = student.getSname();
		String sClass = student.getSclass();
		String sSex = student.getSsex();
		
		request.setAttribute("name", studentName);
		request.setAttribute("course", sClass);
		request.setAttribute("sex", sSex);
		
		return "f:/s_grade_s.jsp";
	}
}
