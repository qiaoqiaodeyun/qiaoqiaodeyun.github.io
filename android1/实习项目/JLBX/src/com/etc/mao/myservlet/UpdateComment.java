package com.etc.mao.myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.mao.daoimpl.RepairImpl;

public class UpdateComment extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int id=Integer.valueOf(request.getParameter("id").toString());
		String comment=request.getParameter("reply");
		System.out.println(id+"dfshfusdjh"+comment);
		RepairImpl r = new RepairImpl();
		r.updateComment(id, comment);
		PrintWriter out = response.getWriter();
		out.println("err");
		out.flush();
		out.close();
	}

}
