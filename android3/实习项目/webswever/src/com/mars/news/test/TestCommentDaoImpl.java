package com.mars.news.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import com.mars.news.dao.impl.CommentDaoImpl;
import com.mars.news.dao.inter.CommentDao;
import com.mars.news.entity.Comment;

public class TestCommentDaoImpl {

	CommentDao commentdao = new CommentDaoImpl();
	@Test
	public void search() {
		
		List<Comment> list=commentdao.select();
		for (Comment comment : list) {
			System.out.println("comment:"+comment.toString());
		}
		
	}
	
	@Test
	public void AddComment(){
		
		Comment comment=new Comment();
		comment.setCommentcontent("commentdaocommentdaocommentdaocommentdaocommentdao");
		comment.setNewsid(1);
		comment.setUserid(1);
		
		commentdao.Add(comment);
	}
	
	

}
