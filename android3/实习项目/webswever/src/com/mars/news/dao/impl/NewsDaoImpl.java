package com.mars.news.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.mars.news.comm.SQLCommandBean;
import com.mars.news.dao.inter.CategoryDao;
import com.mars.news.dao.inter.NewsDao;
import com.mars.news.entity.Category;
import com.mars.news.entity.News;

public class NewsDaoImpl extends SQLCommandBean implements NewsDao {

	public List<News> Select(String categoryname) {
		
	 	int  newsid=0;//默认为零
		
		//通过Categoryname获取Categoryid
		CategoryDao category=new CategoryDaoImpl();
		List<Category> list1=category.select();
//		for (Category cate : list1) {
//			System.out.println(cate);
////			if(list1)
//		}
		for (int i = 0; i < list1.size(); i++) {
			if(categoryname != null && categoryname.equals(list1.get(i).getCategoryname())){
				newsid=list1.get(i).getCategoryid();
			}
		}
		
		System.out.println("newsid:"+newsid);
		
		
		//通过id查询所有
		List<News> list = new ArrayList<News>();

		List li = new ArrayList();
		li.add(newsid);

		String sql = "select * from news where categoryid=?";

		Result result = executeQuery(sql, li);

		SortedMap[] maps = result.getRows();
		int i = result.getRowCount();
		for (int j = 0; j < i; j++) {
			News news = new News();
			Map map = maps[j];
			news.setNewsid((Integer) map.get("newsid"));
			news.setNewstitle((String) map.get("newstitle"));
			news.setNewscontent((String) map.get("newscontent"));
			news.setCreatedate((Date) map.get("createdate"));
			news.setKeyword((String) map.get("keyword"));
			news.setCategoryid(newsid);

			list.add(news);
		}

		return list;
	}

	
	/**
	 * 关键之查找
	 */
	public List<News> select(String keyword) {
		List<News> list = new ArrayList<News>();
		
		List li = new ArrayList();
		li.add(keyword);
		
		String sql="select * from news where keyword=?";
		Result result = executeQuery(sql, li);
		SortedMap[] maps = result.getRows();
		int i = result.getRowCount();
		for (int j = 0; j < i; j++) {
			News news = new News();
			Map map = maps[j];
			news.setNewsid((Integer) map.get("newsid"));
			news.setNewstitle((String) map.get("newstitle"));
			news.setNewscontent((String) map.get("newscontent"));
			news.setCreatedate((Date) map.get("createdate"));
			news.setKeyword(keyword);
			news.setCategoryid((Integer)map.get("categoryid"));

			list.add(news);
		}
		
		return list;
	}


	public Set<String> Select() {

		Set<String> list=new HashSet<String>();
		
		String sql="select keyword from news ";
		Result result = executeQuery(sql, null);
		SortedMap[] maps = result.getRows();
		int i = result.getRowCount();
		for (int j = 0; j < i; j++) {
			Map map = maps[j];
			list.add((String)map.get("keyword"));
			
		}
		
		return list;
	}

}
