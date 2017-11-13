package com.mars.news.dao.inter;

import java.util.List;

import com.mars.news.entity.Comment;

public interface CommentDao {

	/**
	 * 添加评论
	 */
	public boolean Add(Comment comment);
	
	/**
	 * 查看所有评论
	 */
	public List<Comment> select();
	
}
