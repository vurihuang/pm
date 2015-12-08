package edu.fjnu.test.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.fjnu.domain.Student;
import edu.fjnu.domain.Teacher;
import edu.fjnu.service.StudentService;
import edu.fjnu.service.TeacherService;

/**
 * Servlet implementation class TestLoginServlet
 */
@WebServlet("/TestLoginServlet")
public class TestLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String userID = req.getParameter("userID");
			
		if(userID.substring(0, 1).equals("1")){
			StudentService stuService = new StudentService();
			Student student = new Student();
			student.setStudentID(req.getParameter("userID"));
			student.setSpassword(req.getParameter("password"));
			
//			student = CommonUtils.toBean(req.getParameterMap(), Student.class);
			System.out.println(student.getStudentID() + student.getSpassword());
			if(stuService.checkInfo(student)){
				req.getRequestDispatcher("/index/test.jsp").forward(req, resp);
			}
			
		}else if(userID.substring(0, 1).equals("2")){
			TeacherService teaService = new TeacherService();
			Teacher teacher = new Teacher();
			teacher.setTeacherID(req.getParameter("userID"));
			teacher.setTpassword(req.getParameter("password"));
			
			System.out.println(teacher.getTeacherID() + teacher.getTpassword());
			if(teaService.checkInfo(teacher)){
				req.getRequestDispatcher("/index/error.jsp").forward(req, resp);
			}
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
	}
	
	
}
