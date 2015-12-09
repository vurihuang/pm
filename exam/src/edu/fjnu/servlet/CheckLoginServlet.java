package edu.fjnu.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.itcast.servlet.BaseServlet;

/**
 * Servlet implementation class CheckLoginServlet
 */
@WebServlet("/CheckLoginServlet")
public class CheckLoginServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	
	public String checkInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String permission = (String)request.getParameter("user");
		HttpSession session = request.getSession();
		
		if(permission.equals("student")){
			
			return "f:index/s_grade_s.jsp";
		}else if(permission.equals("teacher")){
			return "f:index/s_grade_t.jsp";
		}
		
		return "f:index/error.jsp";
	}
	
}
