package com.mars.news.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;
import com.mars.news.dao.impl.NewsDaoImpl;
import com.mars.news.dao.inter.NewsDao;
import com.mars.news.entity.News;

public class NewsServlet extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public NewsServlet() {
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
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String METHOD=request.getParameter("todo");
		String cate=request.getParameter("category");//类别的id
		String keyword=request.getParameter("keyword");
		
		System.out.println("keyword"+keyword);
		
//		System.out.println("cate:"+cate);
		
		response.setCharacterEncoding("utf-8");
		request.setCharacterEncoding("utf-8");
		
		//通过类别id的信息进行查询数据相对应的新闻信息
		if("select".equals(METHOD)){
			NewsDao newsdao=new NewsDaoImpl();
			List<News> listnews = newsdao.Select(cate);
			for (News news : listnews) {
				System.out.println(news.toString());
			}
			
			String list=JSON.toJSONString(listnews);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println(list);
			out.flush();
			out.close();
		}else if("keywordselect".equals(METHOD)){
			
			System.out.println("11111111");
			
			NewsDao newsdao=new NewsDaoImpl();
			List<News> list = newsdao.select(keyword);
			if(list != null){
				for (News news : list) {
					System.out.println(news.toString());
				}
			}
			
			String onenew=JSON.toJSONString(list);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println(onenew);
			out.flush();
			out.close();
			
			System.out.println("++++++++++++++++++!!!!!!!!!!!!!!!!!!!!!");
		}else if("categoryselect".equals(METHOD)){
			NewsDao newsdao=new NewsDaoImpl();
			Set<String> set=newsdao.Select();
		
			
			
			String onenew=JSON.toJSONString(set);
			response.setContentType("text/html");
			response.setCharacterEncoding("utf-8");
			PrintWriter out = response.getWriter();
			out.println(onenew);
			out.flush();
			out.close();
		}
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
