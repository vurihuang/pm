package com.fjnu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjnu.dto.User;

public class CheckLoginServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public CheckUser cu = new CheckUser();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doGet(req, resp);
		doPost(req, resp);
		resp.getWriter().append("服务对象").append(req.getContextPath());
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//		super.doPost(req, resp);
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String forward = null;
		RequestDispatcher rd = null;
		
		if(username == null && password == null){
			req.setAttribute("msg", "用户名或密码不能为空！");
			rd = req.getRequestDispatcher("login/error.jsp");
			rd.forward(req, resp);
		}
		else{
			User user = new User();
			user.setName(username);
			user.setPassword(password);

			boolean isUserRight = cu.check(user);
			if(isUserRight){
				forward = "login/success.jsp";
			}
			else{
				req.setAttribute("msg", "用户名或密码不正确！");
				forward = "login/error.jsp";
			}
			rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}
	}

}
