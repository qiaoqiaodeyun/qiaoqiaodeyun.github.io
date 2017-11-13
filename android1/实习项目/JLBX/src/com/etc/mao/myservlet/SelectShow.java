package com.etc.mao.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.util.List;

import javax.jms.Session;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.etc.mao.daoimpl.RepairImpl;
import com.etc.mao.entity.Repair;

public class SelectShow extends HttpServlet implements Serializable{

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String pot=request.getParameter("pot");
			RepairImpl re=new RepairImpl();
			List<Repair> l=null;
			if("dai".equals(pot)){
				l=re.checkinfo(null, "待修");
				System.out.println("dsahdjsahdjsha");
			}
			else if("wan".equals(pot)){
				l=re.checkinfo(null, "已完成");
			}
			else if("zhong".equals(pot)){
				l=re.checkinfo(null, "维修中");
			}
			else{
				l=re.checkinfo(null, null);
			}
			System.out.println(l.toString());
			int i=l.size();
			request.getSession().setAttribute("repair", l);
			response.sendRedirect("yemian/index.jsp");
			
	}

	

}
