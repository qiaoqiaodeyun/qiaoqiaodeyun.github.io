package com.mars.news.dao.inter;

import java.util.List;
import java.util.Set;

import com.mars.news.entity.News;

public interface NewsDao {
	public List<News> Select(String Categoryname);
	
	public List<News> select(String keyword);
	
	/**
	 * 查询new中所有的关键字，去重复
	 * @return
	 */
	public Set<String> Select();
}
