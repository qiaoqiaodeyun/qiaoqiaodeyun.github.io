package com.mars.news.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mars.news.dao.impl.CategoryDaoImpl;
import com.mars.news.dao.inter.CategoryDao;
import com.mars.news.entity.Category;

public class TestCategoryDaoImpl {

	@Test
	public void test() {
		
		CategoryDao category=new CategoryDaoImpl();
		List<Category> list=category.select();
		for (Category cate : list) {
			System.out.println(cate);
		}
	}

}
