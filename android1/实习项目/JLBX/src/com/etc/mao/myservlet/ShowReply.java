package com.etc.mao.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.mao.daoimpl.RepairImpl;
import com.etc.mao.daoimpl.WorkerImpl;

public class ShowReply extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			String phone=request.getSession().getAttribute("phone").toString();
			RepairImpl w=new RepairImpl();
			List<String> list=w.showReply(phone);
			request.getSession().setAttribute("reply", list);
			response.sendRedirect("yemian/indexreply.jsp");
	}

}
