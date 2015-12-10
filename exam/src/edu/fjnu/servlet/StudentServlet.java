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
 * 学生信息请求处理
 * @author vengeance
 *
 */
@WebServlet("/StudentServlet")
public class StudentServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public StudentService studentService = new StudentService();//实例化学生service方法
	
	/**
	 * 学生查询方法
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = CommonUtils.toBean(request.getParameterMap(), Student.class);
		studentService.checkInfo(student);
		return "f:/index/test.jsp";
	}
	
	/**
	 * 获取学生的基本信息并显示
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 */
	public String stuInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException{
		HttpSession session = request.getSession();
		Student student = new Student();
		
		//从session中得到学生的登录信息
		student.setStudentID((String)session.getAttribute("userID"));
		student = studentService.studentInfo(student);//调用学生的service方法查询信息
		
		String studentName = student.getSname();
		String sClass = student.getSclass();
		String sSex = student.getSsex();
		
		request.setAttribute("name", studentName);
		request.setAttribute("course", sClass);
		request.setAttribute("sex", sSex);
		
		return "f:/s_grade_s.jsp";
	}
}
