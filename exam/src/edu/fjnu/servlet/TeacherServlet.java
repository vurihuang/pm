package edu.fjnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.Teacher;
import edu.fjnu.service.TeacherService;

/**
 * 教师端处理
 * @author vengeance
 *
 */
@WebServlet("/TeacherServlet")
public class TeacherServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private TeacherService teacherService = new TeacherService();
	
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
		
		teacher.setTeacherID((String)session.getAttribute("userID"));//设置ID
		String courseID = teacherService.getCourseIDByTeacherID(teacher.getTeacherID());//通过teacherID得到courseID
		teacherInfo(request, response, teacher);
		setCourseID(request, response, courseID);//通过一个courseID将其他学科courseID都设置到session域，供调用传入值
		
		request.getRequestDispatcher("/index/jsp/index-tea.jsp").forward(request, response);
	}
	
	/**
	 * 响应老师端的成绩分析模块综合信息
	 * @param request
	 * @param response
	 * @return 加载综合信息
	 * @throws ServletException
	 * @throws IOException
	 */
	public void allInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacherID  = (String) request.getSession().getAttribute("userID");
		String studentID = request.getParameter("studentID");
		loadStuList(request, response, teacherID);
		
		request.setAttribute("sumcounts", teacherService.sumcountByteacherID(teacherID));//得到柱状图数据
		
		chooseCourseByName(request, response, studentID, teacherID);
		request.getRequestDispatcher("/index/jsp/s-grade-t.jsp").forward(request, response);
	}
	
	/**
	 * 响应老师端的成绩分析模块信息
	 * @param request
	 * @param response
	 * @return 成绩分析模块信息
	 * @throws ServletException
	 * @throws IOException
	 */
	public void courseInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		scoreTrend(request, response);
		String course = (String)request.getParameter("courseName");
		String url = "";
		if("chinese".equals(course)){
			url = "/index/jsp/s-chinese-t.jsp";
		}else if("math".equals(course)){
			url = "/index/jsp/s-math-t.jsp";
		}else if("english".equals(course)){
			url = "/index/jsp/s-english-t.jsp";
		}else{
			url = "/index/jsp/s-grade-t.jsp";
		}
		
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	/**
	 * 得到教师信息
	 * @param teacherID 
	 */
	private void teacherInfo(HttpServletRequest request, HttpServletResponse response, Teacher teacher) throws ServletException, IOException {
		teacher = teacherService.teacherInfo(teacher);
		
		request.getSession().setAttribute("name", teacher.getTname());
		request.getSession().setAttribute("course", teacher.getCourse());
		request.getSession().setAttribute("tclass", teacher.getTclass());
	}
	
	/**
	 * 通过教师ID得到所教学生列表
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void loadStuList(HttpServletRequest request, HttpServletResponse response, String teacherID) throws ServletException, IOException {
		request.setAttribute("studentList", teacherService.getStuList(teacherID));
	}

	/**
	 * 通过一个courseID得出本学期其他学科的courseID并设置到session域
	 * 以供在点击语文时将该courseID准确传入到数据库查询所需数据
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 * 
	 */
	private void setCourseID(HttpServletRequest request, HttpServletResponse response, String courseID) throws ServletException, IOException {
		int firstNum = Integer.parseInt(courseID.substring(0, 1));
		int lastNum = Integer.parseInt(courseID.substring(4, 5));
		
		int chineseID = firstNum * 10000 + lastNum + 100;//语文ID
		int mathID = firstNum * 10000 + lastNum + 200;//数学ID
		int englishID = firstNum * 10000 + lastNum + 300;//英语ID
		
		request.getSession().setAttribute("chineseID", Integer.toString(chineseID));
		request.getSession().setAttribute("mathID", Integer.toString(mathID));
		request.getSession().setAttribute("englishID", Integer.toString(englishID));
	}
	
	/**
	 * 得到学生的成绩走势图
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	private void scoreTrend(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String teacherID  = (String) request.getSession().getAttribute("userID");
		String studentID = request.getParameter("studentID");
		loadStuList(request, response, teacherID);
		
		request.setAttribute("studentID", studentID);//选择完下拉框返回的值给走势图使用
		request.setAttribute("studentName", request.getParameter("studentName"));//选择完下拉框返回的值供下拉框显示当前选中显示
		chooseCourseByName(request, response, studentID, teacherID);
	}
	
	/**
	 * 判断学科得到及格率、优秀率、走势图
	 * @param request
	 * @param response
	 * @param studentID
	 * @param teacherID
	 * @return
	 */
	private void chooseCourseByName(HttpServletRequest request, HttpServletResponse response, 
		String studentID, String teacherID)
				throws ServletException, IOException {
		String course = request.getParameter("courseName");
		String courseID = "";
		
		if("chinese".equals(course)){
			courseID = (String) request.getSession().getAttribute("chineseID");
			
			int passRate = (int) (teacherService.getPassRate(courseID) * 100);
			int excellentRate = (int) (teacherService.getExcellentRate(courseID) * 100);
			
			if(studentID == null){
				//设置及格率、优秀率（如0.2以20传到页面）
				request.setAttribute("passRate", passRate);
				request.setAttribute("excellentRate", excellentRate);
				//设置历次最高分、最低分、平均分、缺少个人分设为0
				request.setAttribute("stuScoreList", teacherService.lackOfStudent());
				request.setAttribute("maxScoreList", teacherService.maxScores(courseID));
				request.setAttribute("minScoreList", teacherService.minScores(courseID));
				request.setAttribute("avgScoreList", teacherService.avgScores(courseID));
				
//				return "f:/index/jsp/s-chinese-t.jsp";
			}
			
			//设置及格率、优秀率（如0.2以20传到页面）
			request.setAttribute("passRate",passRate );
			request.setAttribute("excellentRate", excellentRate);
			//设置历次最高分、最低分、平均分、个人分
			//防止查不到学生成绩导致图显示失败
			if(teacherService.stuScores(courseID, studentID).size() > 1){
				request.setAttribute("stuScoreList", teacherService.stuScores(courseID, studentID));
			}else{
				request.setAttribute("stuScoreList", teacherService.lackOfStudent());
			}
			
			request.setAttribute("maxScoreList", teacherService.maxScores(courseID));
			request.setAttribute("minScoreList", teacherService.minScores(courseID));
			request.setAttribute("avgScoreList", teacherService.avgScores(courseID));
			
//			return "f:/index/jsp/s-chinese-t.jsp";
		}else if("math".equals(course)){
			courseID = (String)request.getSession().getAttribute("mathID");
			
			//获得及格率、优秀率
			int passRate = (int)(teacherService.getPassRate(courseID) * 100);
			int excellentRate = (int)(teacherService.getExcellentRate(courseID) * 100);
			if(studentID == null){
				//设置及格率、优秀率（如0.2以20传到页面）
				request.setAttribute("passRate",passRate );
				request.setAttribute("excellentRate", excellentRate);
				//设置历次最高分、最低分、平均分、缺少个人分设为0
				request.setAttribute("stuScoreList", teacherService.lackOfStudent());
				request.setAttribute("maxScoreList", teacherService.maxScores(courseID));
				request.setAttribute("minScoreList", teacherService.minScores(courseID));
				request.setAttribute("avgScoreList", teacherService.avgScores(courseID));				
				
//				return "f:/index/jsp/s-math-t.jsp";
			}
			//设置及格率、优秀率（如0.2以20传到页面）
			request.setAttribute("passRate",passRate );
			request.setAttribute("excellentRate", excellentRate);
			//设置历次最高分、最低分、平均分、个人分
			//防止查不到学生成绩导致图显示失败
			if(teacherService.stuScores(courseID, studentID).size() > 1){
				request.setAttribute("stuScoreList", teacherService.stuScores(courseID, studentID));
			}else{
				request.setAttribute("stuScoreList", teacherService.lackOfStudent());
			}
			request.setAttribute("maxScoreList", teacherService.maxScores(courseID));
			request.setAttribute("minScoreList", teacherService.minScores(courseID));
			request.setAttribute("avgScoreList", teacherService.avgScores(courseID));
			
//			return "f:/index/jsp/s-math-t.jsp";
		}else if("english".equals(course)){
			courseID = (String)request.getSession().getAttribute("englishID");
			
			//获得及格率、优秀率
			int passRate = (int)(teacherService.getPassRate(courseID) * 100);
			int excellentRate = (int)(teacherService.getExcellentRate(courseID) * 100);
			if(studentID ==  null){
				//设置及格率、优秀率（如0.2以20传到页面）
				request.setAttribute("passRate",passRate );
				request.setAttribute("excellentRate", excellentRate);
				//设置历次最高分、最低分、平均分、缺少个人分设为0
				request.setAttribute("stuScoreList", teacherService.lackOfStudent());
				request.setAttribute("maxScoreList", teacherService.maxScores(courseID));
				request.setAttribute("minScoreList", teacherService.minScores(courseID));
				request.setAttribute("avgScoreList", teacherService.avgScores(courseID));	
				
//				return "f:/index/jsp/s-english-t.jsp";
			}
			//设置及格率、优秀率（如0.2以20传到页面）
			request.setAttribute("passRate",passRate );
			request.setAttribute("excellentRate", excellentRate);
			//设置历次最高分、最低分、平均分、个人分
			//防止查不到学生成绩导致图显示失败
			if(teacherService.stuScores(courseID, studentID).size() > 1){
				request.setAttribute("stuScoreList", teacherService.stuScores(courseID, studentID));
			}else{
				request.setAttribute("stuScoreList", teacherService.lackOfStudent());
			}
			request.setAttribute("maxScoreList", teacherService.maxScores(courseID));
			request.setAttribute("minScoreList", teacherService.minScores(courseID));
			request.setAttribute("avgScoreList", teacherService.avgScores(courseID));
			
//			return "f:/index/jsp/s-english-t.jsp";
		}else{
			String cCourseID = (String)request.getSession().getAttribute("chineseID");
			String mCourseID = (String)request.getSession().getAttribute("mathID");
			String eCourseID = (String)request.getSession().getAttribute("englishID");
			
			if(studentID ==  null){
				//设置历次最高分、最低分、平均分、缺少个人分设为0
				request.setAttribute("sumStuScoreList", teacherService.lackOfStudent());
				request.setAttribute("sumMaxScoreList", teacherService.sumMaxScores(cCourseID, mCourseID, eCourseID));
				request.setAttribute("sumMinScoreList", teacherService.sumMinScores(cCourseID, mCourseID, eCourseID));
				request.setAttribute("sumAvgScoreList", teacherService.sumAvgScores(cCourseID, mCourseID, eCourseID));
				
//				return "f:/index/jsp/s-grade-t.jsp";
			}
			//设置历次最高分、最低分、平均分、个人分
			//防止查不到学生成绩导致图显示失败
			if(teacherService.sumStuScores(cCourseID, mCourseID, eCourseID, studentID).size() > 1){
				request.setAttribute("sumStuScoreList", teacherService.sumStuScores(cCourseID, mCourseID, eCourseID, studentID));
			}else{
				request.setAttribute("sumStuScoreList", teacherService.lackOfStudent());
			}
			request.setAttribute("sumMaxScoreList", teacherService.sumMaxScores(cCourseID, mCourseID, eCourseID));
			request.setAttribute("sumMinScoreList", teacherService.sumMinScores(cCourseID, mCourseID, eCourseID));
			request.setAttribute("sumAvgScoreList", teacherService.sumAvgScores(cCourseID, mCourseID, eCourseID));
		
//			return "f:/index/jsp/s-grade-t.jsp";
		}
	}
}
