package com.mars.news.dao.inter;

import java.util.List;

import com.mars.news.entity.Comment;

public interface CommentDao {

	/**
	 * �������
	 */
	public boolean Add(Comment comment);
	
	/**
	 * �鿴��������
	 */
	public List<Comment> select();
	
}
