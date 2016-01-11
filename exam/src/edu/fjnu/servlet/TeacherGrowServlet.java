package edu.fjnu.servlet;

import cn.itcast.servlet.BaseServlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.fjnu.domain.StudentPr;
import edu.fjnu.service.GrowService;
import edu.fjnu.service.TeacherGrowService;

/**
 * 老师得到学生成长轨迹图的servlet
 */
@WebServlet("/TeacherGrowServlet")
public class TeacherGrowServlet extends BaseServlet {
	public TeacherGrowService tgs=new TeacherGrowService();
	public GrowService gs=new GrowService();
	private static final long serialVersionUID = 1L;
	/**
	 * 加载学生给下拉框
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loadStu(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String teacherId=(String)request.getSession().getAttribute("userID"); //得到 教师id
		List<String> stuList=tgs.getStudent(teacherId);  //调用dao得到学生名字的list
		request.getSession().setAttribute("stuList", stuList);  //把这个list返回给jsp的下拉框
		return "f:/index/jsp/grade/grow-t.jsp";
	}
	/**
	 * 加载学生成长轨迹图的数据
	 * @param request
	 * @param response
	 * @return
	 * @throws ServletException
	 * @throws IOException
	 */
	public String loadStuPr(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String stuName=request.getParameter("stuName");
		
		List<StudentPr> chineseList=new ArrayList<StudentPr>(); //语文的StudentPr值列表
		List<StudentPr> mathList=new ArrayList<StudentPr>();   //数学的StudentPr值列表
		List<StudentPr> englishList=new ArrayList<StudentPr>();   //英语的StudentPr值列表
		
		chineseList=gs.getStudentPrs(stuName, "语文");
		mathList=gs.getStudentPrs(stuName, "数学");
		englishList=gs.getStudentPrs(stuName, "英文");
		
		request.setAttribute("selectStu", stuName);
		request.setAttribute("chineseList", chineseList);//把语文的StudentPr值列表传到jsp界面
		request.setAttribute("mathList", mathList);//把数学的StudentPr值列表传到jsp界面
		request.setAttribute("englishList", englishList);  //把英文的StudentPr值列表传到jsp界面
		
		
		
		return "f:/index/jsp/grade/grow-t.jsp";
	}
   
	

}
