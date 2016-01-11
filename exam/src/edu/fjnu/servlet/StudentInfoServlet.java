package edu.fjnu.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.Student;
import edu.fjnu.service.StudentInfoService;

/**
 * 学生信息请求处理
 * 
 * @author vengeance
 *
 */
@WebServlet("/StudentInfoServlet")
public class StudentInfoServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	public StudentInfoService studentService = new StudentInfoService();// 实例化学生service方法

	/**
	 * 获取学生的基本信息并显示
	 * 
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 */
	public String stuInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException {
		HttpSession session = request.getSession();
		Student student = new Student();

		// 从session中得到学生的登录信息
		student.setStudentID((String) session.getAttribute("userID"));
		student = studentService.studentInfo(student);// 调用学生的service方法查询信息

		request.getSession().setAttribute("sID", student.getStudentID());
		request.getSession().setAttribute("sname", student.getSname());

		return "f:/index/jsp/index-stu.jsp";
	}
}
