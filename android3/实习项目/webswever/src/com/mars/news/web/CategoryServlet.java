package com.mars.news.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.mars.news.dao.impl.CategoryDaoImpl;
import com.mars.news.dao.inter.CategoryDao;
import com.mars.news.entity.Category;

public class CategoryServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String METHOD=request.getParameter("todo");
		
		CategoryDao cate=new CategoryDaoImpl();  
		
		if("category".equals(METHOD)){
			List<Category> list=cate.select();
			String categorys=JSON.toJSONString(list);
			
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println(categorys);
			out.flush();
			out.close();
		}

	}


}
