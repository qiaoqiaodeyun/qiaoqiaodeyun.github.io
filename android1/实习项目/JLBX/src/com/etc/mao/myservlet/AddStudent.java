package com.etc.mao.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.etc.mao.daoimpl.StuImpl;
import com.etc.mao.entity.Person;

public class AddStudent extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			StuImpl stu = new StuImpl();
			String name = request.getParameter("name");
			String phone = request.getParameter("phone");
			String pass = request.getParameter("pass");
			Person p=new Person();
			p.setName(name);
			p.setPass(pass);
			p.setPhone(phone);
			stu.register(p);
			String newsjson = JSON.toJSONString(p);
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			System.out.println(newsjson);
			out.println("ÒÑ³É¹¦×¢²á");
			out.flush();
			out.close();
	}

}
