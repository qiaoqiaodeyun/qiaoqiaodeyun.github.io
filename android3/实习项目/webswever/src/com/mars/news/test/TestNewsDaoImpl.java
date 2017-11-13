package com.mars.news.test;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;

import com.mars.news.dao.impl.NewsDaoImpl;
import com.mars.news.dao.inter.NewsDao;
import com.mars.news.entity.News;

public class TestNewsDaoImpl {

//	@Test
//	public void test() {
//		NewsDao newsdao=new NewsDaoImpl();
//		List<News> listnews = newsdao.Select(1);
//		for (News news : listnews) {
//			System.out.println(news.toString());
//		}
//	}
	
	
	@Test
	public void keywordselect(){
		NewsDao newsdao=new NewsDaoImpl();
		List<News> list = newsdao.select("Â³ÄÜÁ½ÐÂ");
		for (News news : list) {
			System.out.println(news.toString());
		}
	}
	
	@Test
	public void cateselect(){
		NewsDao newsdao=new NewsDaoImpl();
		Set<String> set= newsdao.Select();
		System.out.println(set);
	}

}
