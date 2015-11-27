package com.fjnu.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fjnu.dao.impl.UserImpl;
import com.fjnu.entity.User;

/**
 * 将用户输入的用户名与密码通过CheckLoginServlet与数据库中的信息进行验证
 * 如果验证成功，转发到success.jsp
 * 如果验证失败，转发到error.jsp
 * @author vengeance
 *
 */
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;
	public UserImpl ud = new UserImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req, resp);
		resp.getWriter().append("服务对象").append(req.getContextPath());
	}
	/*
	 * 验证用户名与密码
	 * 如果验证成功，跳转到success.jsp
	 * 如果验证失败，跳转到error.jsp
	 */
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
			
			boolean isUserRight = false;
			try {
				isUserRight = ud.checkInfo(user);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			if(isUserRight){
				forward = "index/index.jsp";
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
