package com.mars.news.dao.impl;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.mars.news.comm.SQLCommandBean;
import com.mars.news.dao.inter.CommentDao;
import com.mars.news.entity.Comment;
import com.mars.news.entity.UserInfo;

public class CommentDaoImpl extends SQLCommandBean implements CommentDao {

	public boolean Add(Comment comment) {

		String sql = "insert into comment(commentcontent,createtime,userid,newsid) values(?,now(),?,?)";
		List list = new ArrayList();
		list.add(comment.getCommentcontent());
		list.add(comment.getUserid());
		
		System.out.println("newid"+comment.getNewsid());
		
		list.add(comment.getNewsid());
		executeUpdate(sql, list);
		
		System.out.println("爱护局添加成功！");
		
		return true;
	}

	public List<Comment> select() {

		List<Comment> list = new ArrayList<Comment>();

		String sql = "select * from comment";
		Result result = executeQuery(sql, null);

		SortedMap[] maps = result.getRows();
		int i = result.getRowCount();
		for (int j = 0; j < i; j++) {
			Comment comment = new Comment();
			Map map = maps[j];
			comment.setCommentid((Integer) map.get("commentid"));
			comment.setCommentcontent((String)map.get("commentcontent"));
			comment.setCreatetime((Date)map.get("createtime"));
			comment.setUserid((Integer)map.get("userid"));
			list.add(comment);
		}
		
		return list;
	}

}
