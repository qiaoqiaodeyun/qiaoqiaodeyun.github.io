package com.mars.news.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.mars.news.dao.impl.UserInfoDaoImpl;
import com.mars.news.dao.inter.UserInfoDao;
import com.mars.news.entity.UserInfo;

public class UserInfoServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserInfoServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String msg="";
		String phone= request.getParameter("phone");
		String password = request.getParameter("password");
		
		String METHOD = request.getParameter("todo");
		
		if("login".equals(METHOD)){
			UserInfoDao user=new UserInfoDaoImpl();
			UserInfo userinfo=user.select(phone, password);
			if(userinfo != null){
				msg = JSON.toJSONString(userinfo);
			}else{
				msg="";
			}
			
			
			System.out.println("msg"+msg);
			
			
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println(msg);
			out.flush();
			out.close();
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
