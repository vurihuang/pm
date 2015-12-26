package edu.fjnu.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.rosuda.REngine.Rserve.RserveException;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.service.RelationService;
import edu.fjnu.service.RelationshipService;
import edu.fjnu.service.TeacherTestService;

/**
 * 处理关联分析模块
 * 
 * @author vengeance
 *
 */
@WebServlet("/RelationServlet")
public class RelationServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private RelationService rs = new RelationService();// 用来处理关联分析模块的d3图以及表格数据
	private RelationshipService rsh = new RelationshipService();// 用来处理R图数据及调用
	private TeacherTestService tts = new TeacherTestService();//得到老师的教学信息
	private String courseName = "";
	private String year = "";

	/**
	 * 处理关联分析
	 * 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public String relation(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String teacherID = (String) request.getSession().getAttribute("userID");//得到教师ID
		String course = (String) request.getParameter("course");//获得选择的课程
		List<String> gradeList = tts.getGradeList(Integer.parseInt(teacherID));//得到教师的学生列表
		
		courseName = request.getParameter("course");
		year = request.getParameter("grade");//得到下拉框选择的年级
		year += "%";

		System.out.println(year + courseName);
		// 判断选择的学科、年级
		if ("chinese".equals(courseName)) {
			courseName = "语文";
		} else if ("math".equals(courseName)) {
			courseName = "数学";
		} else if ("english".equals(courseName)) {
			courseName = "英文";
		}

		// 调用R画出图，然后读取
		try {
			rsh.createRForRelastion(courseName, year);
		} catch (RserveException e) {
			e.printStackTrace();
		}
		String[] keywordArr = rs.keywordArray(courseName, year);// 设置d3的点
		Object[][] stvArr = rs.stvArray();// 设置d3的连线关系

		request.setAttribute("keywordList", keywordArr);
		request.setAttribute("d3arr", stvArr);
		request.setAttribute("gradeList", gradeList);

		return "f:/index/jsp/r-" + course + "-t.jsp";
	}
	
	public String loadInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String course = (String) request.getParameter("course");//获得选择的课程
		System.out.println(course);
		String teacherID = (String) request.getSession().getAttribute("userID");//得到教师ID
		List<String> gradeList = tts.getGradeList(Integer.parseInt(teacherID));//得到教师的学生列表
		request.setAttribute("gradeList", gradeList);
		
		return "f:/index/jsp/r-" + course + "-t.jsp";
	}

}
