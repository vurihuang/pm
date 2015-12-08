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
	private TeacherService teaService = new TeacherService();
	private StudentService stuService = new StudentService();
	
	public String checkInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String loginID = request.getParameter("userID");
		
		if(loginID.substring(0, 1).equals("1")){
			Student student = CommonUtils.toBean(request.getParameterMap(), Student.class);
			
			if(stuService.checkInfo(student) == true){
				return "f:index/p_chinese_t.jsp";
			}
		}else if(loginID.substring(0, 1) == "2"){
			Teacher teacher = CommonUtils.toBean(request.getParameterMap(), Teacher.class);
			if(teaService.checkInfo(teacher) == true){
				return "f:index/s_grade_t.jsp";
			}
		}
		return "f:index/test.jsp";
	}
}
