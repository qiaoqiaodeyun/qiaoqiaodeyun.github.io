package com.mars.news.entity;

import java.sql.Date;

public class Comment {
	private Integer commentid;
	private String commentcontent;
	private Date createtime;
	private Integer userid;
	private Integer newsid;
	
	public Comment(){
		
	}

	public Comment(Integer commentid, String commentcontent, Date createtime,
			Integer userid, Integer newsid) {
		super();
		this.commentid = commentid;
		this.commentcontent = commentcontent;
		this.createtime = createtime;
		this.userid = userid;
		this.newsid = newsid;
	}

	public Integer getCommentid() {
		return commentid;
	}

	public void setCommentid(Integer commentid) {
		this.commentid = commentid;
	}

	public String getCommentcontent() {
		return commentcontent;
	}

	public void setCommentcontent(String commentcontent) {
		this.commentcontent = commentcontent;
	}

	public Date getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Date createtime) {
		this.createtime = createtime;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public Integer getNewsid() {
		return newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	@Override
	public String toString() {
		return "Comment [commentid=" + commentid + ", commentcontent="
				+ commentcontent + ", createtime=" + createtime + ", userid="
				+ userid + ", newsid=" + newsid + "]";
	}
	
	
	
	
}
