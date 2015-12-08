package edu.fjnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.Student;
import edu.fjnu.domain.Teacher;
import edu.fjnu.service.StudentService;
import edu.fjnu.service.TeacherService;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String checkInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginID = request.getParameter("userID");
		
		if(loginID.startsWith("2")){
			TeacherService teaService = new TeacherService();
//			Teacher teacher = CommonUtils.toBean(request.getParameterMap(), Teacher.class);
			
			Teacher teacher = new Teacher();
			teacher.setTeacherID(request.getParameter("userID"));
			teacher.setTpassword(request.getParameter("password"));
			
			if(teaService.checkInfo(teacher) == true){
				return "f:index/s_grade_t.jsp";
			}
			
		}
		else if(loginID.startsWith("1")){
			StudentService stuService = new StudentService();
//			Student student = CommonUtils.toBean(request.getParameterMap(), Student.class);
			
			Student student = new Student();
			student.setStudentID(request.getParameter("userID"));
			student.setSpassword(request.getParameter("password"));
			
			if(stuService.checkInfo(student) == true){
				return "f:index/s_grade_t.jsp";
			}
			
		}
			return "f:index/test.jsp";
	}
}
