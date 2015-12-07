package edu.fjnu.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.itcast.commons.CommonUtils;
import cn.itcast.servlet.BaseServlet;
import edu.fjnu.domain.User;
import edu.fjnu.service.UserService;

/**
 * Servlet implementation class UserServlet
 */
/**
 * Web层 继承BaseServlet 可根据需求调用相应的Service方法
 * 
 * @author vengeance
 *
 */
@WebServlet("/UserServlet")
public class UserServlet extends BaseServlet {
	private static final long serialVersionUID = 1L;
	private UserService userService = new UserService();

	public String add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User user = CommonUtils.toBean(request.getParameterMap(), User.class);
		userService.add(user);
		
		return "f:/index/p_chinese_t.html";
	}
	
	public String query(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setAttribute("userList", userService.queryAll());
		List<User> userList = userService.queryAll();
		for(int i=0; i<userList.size(); i++){
			System.out.println(userList.get(i));
		}
		return "f:/index/p_chinese_t.html";
	}
}
