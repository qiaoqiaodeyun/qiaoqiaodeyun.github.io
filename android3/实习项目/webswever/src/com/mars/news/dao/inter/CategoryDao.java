package com.mars.news.dao.inter;

import java.util.List;

import com.mars.news.entity.Category;

public interface CategoryDao {
	
	/**
	 * 用于返回Category中所有的类别
	 * @return
	 */
	public List<Category> select();
	
}
