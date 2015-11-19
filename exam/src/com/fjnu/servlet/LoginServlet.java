package com.fjnu.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 提供测试使用
 * 测试login/test_login.jsp是否能正常工作
 * @author vengeance
 *
 */
public class LoginServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	/**
	 * 重写HttpServlet的get方法
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("使用GET方法");
		doPost(req, resp);
	}
	
	/**
	 * 重写HttpServlet的post方法
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("使用POST方法");
		String username = req.getParameter("username");		//form提交的用户名
		String password = req.getParameter("password");		//form提交的密码
		String forward = null;								//声明转发变量提供页面转发使用
		
		System.out.println("用户名：" + username);
		System.out.println("密码：" + password);
		
		if(username.equals("admin") && password.equals("admin")){
			/*
			 * 选择使用页面的重定向方式，可以重定向到别的应用
			 */
//			resp.sendRedirect(req.getContextPath() + "/login/success.jsp");
			/*
			 * 或者选择使用页面的转发方式，
			 * 请求调度器，封装转发操作，封装客户端的请求并转发到指定的资源，
			 * 转发只能在同一应用的组件下进行，不能转发给其他应用的组件
			 */
			forward = "test/test_success.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}
		else{
			/*
			 * 选择页面重定向
			 */
//			resp.sendRedirect(req.getContextPath() + "/login/error.jsp");
			/*
			 * 或者选择页面转发
			 */
			forward = "test/test_error.jsp";
			RequestDispatcher rd = req.getRequestDispatcher(forward);
			rd.forward(req, resp);
		}
	}
	
}
