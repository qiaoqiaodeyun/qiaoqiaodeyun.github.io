package com.mars.news.dao.inter;

import java.util.List;
import java.util.Set;

import com.mars.news.entity.News;

public interface NewsDao {
	public List<News> Select(String Categoryname);
	
	public List<News> select(String keyword);
	
	/**
	 * ��ѯnew�����еĹؼ��֣�ȥ�ظ�
	 * @return
	 */
	public Set<String> Select();
}
