package com.etc.mao.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.etc.mao.daoimpl.StuImpl;
import com.etc.mao.entity.Person;

public class StuLogin extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			StuImpl stu=new StuImpl();
			String username=request.getParameter("username");
			String pass=request.getParameter("pass");
			Person p=stu.checklogin(username, pass);
			String newsjson=	JSON.toJSONString(p);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			if(p==null){
				System.out.println(newsjson);
				out.println("err");
				out.flush();
				out.close();
			}else{	
				System.out.println(newsjson);
				out.println(newsjson);
				out.flush();
				out.close();
				
			}
			
		
	}

}
