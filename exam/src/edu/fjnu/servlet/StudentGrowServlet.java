package edu.fjnu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cn.itcast.servlet.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.fjnu.domain.StudentPr;
import edu.fjnu.service.GrowService;

/**
 *处理学生端成长轨迹图的业务
 */
@WebServlet("/StudentGrowServlet")
public class StudentGrowServlet extends BaseServlet {
	public GrowService gs=new GrowService(); //实例化GrowService
	
	private static final long serialVersionUID = 1L;
	public String loadPr(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String stuName=(String)request.getSession().getAttribute("sname");//得到学生的名字
		
		List<StudentPr> chineseList=new ArrayList<StudentPr>(); //语文的StudentPr值列表
		List<StudentPr> mathList=new ArrayList<StudentPr>();   //数学的StudentPr值列表
		List<StudentPr> englishList=new ArrayList<StudentPr>();   //英语的StudentPr值列表
		
		chineseList=gs.getStudentPrs(stuName, "语文");
		mathList=gs.getStudentPrs(stuName, "数学");
		englishList=gs.getStudentPrs(stuName, "英文");
		
		
		 //测试
		 /*for (StudentPr studentPr : englishList) {
			System.out.println(studentPr.getClassyear()+"  "+studentPr.getAvgPR());
		}*/
		request.setAttribute("chineseList", chineseList);//把语文的StudentPr值列表传到jsp界面
		request.setAttribute("mathList", mathList);//把数学的StudentPr值列表传到jsp界面
		request.setAttribute("englishList", englishList);  //把英文的StudentPr值列表传到jsp界面
		return "f:/index/jsp/grade/grow-s.jsp";
	}

}
