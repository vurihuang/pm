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
import edu.fjnu.service.TeacherService;

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
		
		request.getSession().setAttribute("sID", student.getStudentID());
		request.getSession().setAttribute("sname", student.getSname());
		request.getSession().setAttribute("sclass", student.getSclass());
		
		return "f:/index/jsp/index-stu.jsp";
	}
	
	public void allInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String studentID = (String)request.getSession().getAttribute("sID");
		chooseCourseByName(request, response, studentID);
	
	}
	/**
	 * 响应学生端的成绩分析模块
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	public void courseInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String course = (String)request.getParameter("courseName");
		String url = "";
		if ("chinese".equals(course)) {
			url = "/index/jsp/s-chinese-s.jsp";
		}else if ("math".equals(course)) {
			url = "/index/jsp/s-math-s.jsp";
		}else if ("english".equals(course)) {
			url = "/index/jsp/s-english-s.jsp";
		}else {
		    url = "/index/jsp/s-grade-s.jsp";
		}
		request.getRequestDispatcher(url).forward(request, response);
	}
	
	
	/**
	 * 判断学科得到语数英走势图
	 */
	private void chooseCourseByName(HttpServletRequest request, HttpServletResponse response, 
			String studentID)
					throws ServletException, IOException {
			String course = request.getParameter("courseName");
			String courseID = "";
			
			if("chinese".equals(course)){
				courseID = (String) request.getSession().getAttribute("chineseID");
			
				
				if(studentID == null){
					//设置历次最高分、最低分、平均分、缺少个人分设为0
					request.setAttribute("maxScoreList", studentService.maxScores(courseID));
					request.setAttribute("minScoreList", studentService.minScores(courseID));
					request.setAttribute("avgScoreList", studentService.avgScores(courseID));
					
//					return "f:/index/jsp/s-chinese-s.jsp";
				}
			
				//设置历次最高分、最低分、平均分、个人分
				//防止查不到学生成绩导致图显示失败
				if(studentService.stuScores(courseID, studentID).size() > 1){
					request.setAttribute("stuScoreList", studentService.stuScores(courseID, studentID));
				}
//				else{
//					request.setAttribute("stuScoreList", studentService.lackOfStudent());
//				}
				
				request.setAttribute("maxScoreList", studentService.maxScores(courseID));
				request.setAttribute("minScoreList", studentService.minScores(courseID));
				request.setAttribute("avgScoreList", studentService.avgScores(courseID));
				
//				return "f:/index/jsp/s-chinese-s.jsp";
			}else if("math".equals(course)){
				courseID = (String)request.getSession().getAttribute("mathID");
				if(studentID == null){
					//设置历次最高分、最低分、平均分、缺少个人分设为0
					request.setAttribute("maxScoreList", studentService.maxScores(courseID));
					request.setAttribute("minScoreList", studentService.minScores(courseID));
					request.setAttribute("avgScoreList", studentService.avgScores(courseID));				
					
//					return "f:/index/jsp/s-math-s.jsp";}

				//设置历次最高分、最低分、平均分、个人分
				//防止查不到学生成绩导致图显示失败
				if(studentService.stuScores(courseID, studentID).size() > 1){
					request.setAttribute("stuScoreList", studentService.stuScores(courseID, studentID));
				}
//				else{
//					request.setAttribute("stuScoreList", teacherService.lackOfStudent());
//				}
				request.setAttribute("maxScoreList", studentService.maxScores(courseID));
				request.setAttribute("minScoreList", studentService.minScores(courseID));
				request.setAttribute("avgScoreList", studentService.avgScores(courseID));
				
//				return "f:/index/jsp/s-math-s.jsp";
			}else if("english".equals(course)){
				courseID = (String)request.getSession().getAttribute("englishID");

				if(studentID ==  null){

					//设置历次最高分、最低分、平均分、缺少个人设为0
					request.setAttribute("maxScoreList", studentService.maxScores(courseID));
					request.setAttribute("minScoreList", studentService.minScores(courseID));
					request.setAttribute("avgScoreList", studentService.avgScores(courseID));	
					
//					return "f:/index/jsp/s-english-s.jsp";
				}

				//设置历次最高分、最低分、平均分、个人
				//防止查不到学生成绩导致图显示失败
				if(studentService.stuScores(courseID, studentID).size() > 1){
					request.setAttribute("stuScoreList", studentService.stuScores(courseID, studentID));
				}
//				else{
//					request.setAttribute("stuScoreList", teacherService.lackOfStudent());
//				}
				request.setAttribute("maxScoreList", studentService.maxScores(courseID));
				request.setAttribute("minScoreList", studentService.minScores(courseID));
				request.setAttribute("avgScoreList", studentService.avgScores(courseID));
				
//				return "f:/index/jsp/s-english-s.jsp";
			}
			else{
/**
 * 综合
 */
				//这里是综合第一张图
				

				// 这里是综合第二张图 直接get scoresList的score 
//				if(studentService.stuthreeScores(studentID).size() > 1){
//					request.setAttribute("StuAllList", studentService.stuthreeScores(studentID));
				}	
//				return "f:/index/jsp/s-grade-s.jsp";
			}
		}
		
//}
	/**
	 * 点击语数英栏时设置courseID
	 * @param request
	 * @param response
	 * @param courseID
	 * @throws ServletException
	 * @throws IOException
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
}
