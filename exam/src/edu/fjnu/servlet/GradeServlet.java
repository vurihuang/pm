package edu.fjnu.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.Student;
import edu.fjnu.domain.Teacher;
import edu.fjnu.service.GradeService;

/**
 * 处理老师成绩分析模块的信息
 * @author vengeance
 *
 */
@WebServlet("/GradeServlet")
public class GradeServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private GradeService gradeService = new GradeService();//获取数据对象
	
	/**
	 * 处理老师端语文成绩查询请求
	 */
	public String chineseInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "f:/index/jsp/s-chinese-t.jsp";
	}
	/**
	 * 处理老师端数学成绩查询请求
	 */
	public String mathInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "f:/index/jsp/s-chinese-t.jsp";
	}
	/**
	 * 处理老师端英语成绩查询请求
	 */
	public String englishInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "f:/index/jsp/s-chinese-t.jsp";
	}
	
	/**
	 * 处理老师端综合成绩查询请求
	 */
	public String allInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		return "f:/index/jsp/s-grade-t.jsp";
	}
}
