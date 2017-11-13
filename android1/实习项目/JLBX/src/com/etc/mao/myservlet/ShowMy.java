package com.etc.mao.myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.etc.mao.daoimpl.RepairImpl;
import com.etc.mao.entity.Repair;

public class ShowMy extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			String phone = request.getParameter("phone");
			System.out.println(phone+"ÎÒµÄºÅÂë");
			RepairImpl re = new RepairImpl();
			List<Repair> r=re.select(phone);
			String repair=JSON.toJSONString(r);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("UTF-8");
			PrintWriter out = response.getWriter();
			
			if(r==null){
				System.out.println(repair);
				out.println("err");
				out.flush();
				out.close();
			}else{	
				System.out.println(repair);
				out.println(repair);
				out.flush();
				out.close();
				
			}
	}

}
