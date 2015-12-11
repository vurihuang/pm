package edu.fjnu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.Scourse;
import edu.fjnu.domain.Sscore;
import edu.fjnu.domain.Student;
import edu.fjnu.domain.Teacher;
import edu.fjnu.service.GradeService;
import edu.fjnu.service.TeacherService;
import edu.fjnu.test.domain.Score;

/**
 * Servlet implementation class TeacherServlet
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService = new TeacherService();
	private GradeService gradeService = new GradeService();
	
	/**
	 * 老师登录后载入index页面的所有信息
	 * 包括学生成绩分布情况，总分走势，学生列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void teaLoadInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		Teacher teacher = new Teacher();
		Scourse scourse = new Scourse();
		List<Student> stuList = null;
		List<Sscore> avgList = null;
		List<Sscore> maxList = null;
		List<Sscore> minList = null;
		teacher.setTeacherID((String)session.getAttribute("userID"));//设置ID
		teacher = teacherService.teacherInfo(teacher);//得到老师信息
		stuList = teacherService.getStuList(teacher);//得到学生列表
		
		scourse.setCourseID(teacher.getScourse().getCourseID());//得到老师所教课程ID
		avgList = gradeService.getAvgScoreList(scourse);//得到平均分走势
		maxList = gradeService.getMaxScoreList(scourse);//得到最高分走势
		minList = gradeService.getMinScoreList(scourse);//得到最低分走势
		
		System.out.println("here ok3");
		session.setAttribute("tname", teacher.getTname());
		session.setAttribute("classyear", teacher.getScourse().getClassyear());
		session.setAttribute("course", teacher.getCourse());
		session.setAttribute("tclass", teacher.getTclass());
		session.setAttribute("stuList", stuList);
		session.setAttribute("avgList", avgList);
		session.setAttribute("maxList", maxList);
		session.setAttribute("minList", minList);
		
//		request.setAttribute("tname", teacher.getTname());
//		request.setAttribute("classyear", teacher.getScourse().getClassyear());
//		request.setAttribute("course", teacher.getCourse());
//		request.setAttribute("tclass", teacher.getTclass());
		System.out.println("here ok4");
		System.out.println(teacher);
		request.getRequestDispatcher("/index/jsp/index-tea.jsp").forward(request, response);
	}
	
}
