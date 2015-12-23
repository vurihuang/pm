package edu.fjnu.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 处理关联分析模块
 * @author vengeance
 *
 */
@WebServlet("/RelationServlet")
public class RelationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private String courseName = "";
    private String year = "";
	/**
	 * 处理关联分析
	 * @param arg0
	 * @param arg1
	 * @throws ServletException
	 * @throws IOException
	 */
    protected void relation(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	courseName = request.getParameter("course");
    	year = request.getParameter("year");
    	year += "%";
    	
    	//判断选择的学科、年级
    	if("chinese".equals(courseName)){
    		courseName = "语文";
    	}else if("math".equals(courseName)){
    		courseName = "数学";
    	}else if("english".equals(courseName)){
    		courseName = "英文";
    	}
    }

}
