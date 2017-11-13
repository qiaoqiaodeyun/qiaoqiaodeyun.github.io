package com.etc.mao.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.mao.daoimpl.RepairImpl;

public class AddRepair extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name=request.getParameter("name");
		String phone=request.getParameter("phone");
		String location=request.getParameter("location"); 
		String status=request.getParameter("status");
		RepairImpl r = new RepairImpl();
		r.insertinto(phone, location, status);
		System.out.println(name+phone+location+status);
	}

}
