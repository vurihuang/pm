package edu.fjnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.Scourse;
import edu.fjnu.domain.Teacher;
import edu.fjnu.service.TeacherService;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService = new TeacherService();
	
	public String teaInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Teacher teacher = new Teacher();
		Scourse scourse = new Scourse();
		
		teacher.setTeacherID((String)session.getAttribute("userID"));
		teacher = teacherService.teacherInfo(teacher);
		
		String teacherName = teacher.getTname();
		String course = teacher.getCourse();
		String tclass = teacher.getTclass();
		scourse = teacher.getScourse();
		String classyear = scourse.getClassyear();
		
		request.setAttribute("teachername", teacherName);
		request.setAttribute("classyear", classyear);
		request.setAttribute("course", course);
		request.setAttribute("tclass", tclass);
		
		return "f:/s_grade_t.jsp";
	}
}
