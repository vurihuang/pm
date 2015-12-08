package edu.fjnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	public StudentService stuService = new StudentService();
	
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = CommonUtils.toBean(request.getParameterMap(), Student.class);
		stuService.checkInfo(student);
		return "f:/index/test.jsp";
	}
}
