package com.mars.news.dao.inter;

import java.util.List;

import com.mars.news.entity.Category;

public interface CategoryDao {
	
	/**
	 * ���ڷ���Category�����е����
	 * @return
	 */
	public List<Category> select();
	
}
