package com.mars.news.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.mars.news.comm.SQLCommandBean;
import com.mars.news.dao.inter.CategoryDao;
import com.mars.news.entity.Category;
import com.mars.news.entity.UserInfo;

public class CategoryDaoImpl extends SQLCommandBean implements CategoryDao {

	public List<Category> select() {

		List<Category> list = new ArrayList<Category>();

		String sql = "select * from category";
		Result result = executeQuery(sql, null);

		SortedMap[] maps = result.getRows();
		int i = result.getRowCount();
		for (int j = 0; j < i; j++) {
			Map map = maps[j];
			Category cate=new Category();
			cate.setCategoryid((Integer)map.get("categoryid"));
			cate.setCategoryname((String) map.get("categoryname"));
			list.add(cate);
		}

		return list;
	}

}
