package com.icss.bk.control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icss.bk.biz.UserBiz;
import com.icss.bk.entity.User;

public class LoginSvl extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public LoginSvl() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/main/login.jsp").forward(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String uname = request.getParameter("uname");
		String pwd = request.getParameter("pwd");
		UserBiz biz = new UserBiz();
		try {
			User u = biz.login(uname, pwd);
	        if(u == null){	        	
	        	request.setAttribute("msg", "用户名或密码错误，请重新输入");
	        	request.getRequestDispatcher("/main/login.jsp").forward(request, response);
	        }else{
	        	request.getSession().setAttribute("user",u);       //使用session对象可以跨页面传递数据
	        	request.getRequestDispatcher("/main/main.jsp").forward(request, response);	        	
	        }	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("网络异常，请和管理员联系");
		}				
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
