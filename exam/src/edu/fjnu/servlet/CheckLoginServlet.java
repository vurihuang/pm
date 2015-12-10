package edu.fjnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
	
	public void checkInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String permission = (String)request.getParameter("user");
		HttpSession session = request.getSession();
		String userID = request.getParameter("username");
		String password = request.getParameter("password");
		
		if(permission.equals("student")){
			Student student = new Student();
			StudentService stuService = new StudentService();
			
			student.setStudentID(userID);
			student.setSpassword(password);
			
			if(stuService.checkInfo(student)){
				session.setAttribute("userID", student.getStudentID());
				session.setAttribute("password", student.getSpassword());
				
			}
				
//			return "f:/s_grade_s.jsp";
		}else if(permission.equals("teacher")){
			Teacher teacher = new Teacher();
			TeacherService teaService = new TeacherService();
			
			teacher.setTeacherID(userID);
			teacher.setTpassword(password);
			
			if(teaService.checkInfo(teacher)){
//				teacher = teaService.teacherInfo(teacher);
//				
//				String teacherName = teacher.getTname();
//				String tCourese = teacher.getCourse();
//				String tSex = teacher.getTsex();
//				
//				request.setAttribute("name", teacherName);
//				request.setAttribute("course", tCourese);
//				request.setAttribute("sex", tSex);
				session.setAttribute("userID", userID);
				session.setAttribute("password", password);
				request.getRequestDispatcher("/TeacherServlet?method=teaInfo")
				.forward(request, response);
			}else{
				request.getRequestDispatcher("/index/error.jsp").forward(request, response);;
			}
		}
	}
}
