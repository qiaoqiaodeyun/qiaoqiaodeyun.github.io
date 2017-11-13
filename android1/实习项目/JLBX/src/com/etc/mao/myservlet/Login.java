package com.etc.mao.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.mao.dao.WorkerDao;
import com.etc.mao.daoimpl.WorkerImpl;
import com.etc.mao.entity.Person;

public class Login extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String username=request.getParameter("Username");
			String password=request.getParameter("Password");
			System.out.println(username+password);
			WorkerDao wo=new WorkerImpl();
			Person p=wo.checklogin(username, password);
			
			if(p==null){
				response.sendRedirect("./yemian/login/index.jsp?i=1");
			}
			else{
				request.getSession().setAttribute("phone", username);
				response.sendRedirect("yemian/index.jsp");
			}
			
		
	}

	

}
