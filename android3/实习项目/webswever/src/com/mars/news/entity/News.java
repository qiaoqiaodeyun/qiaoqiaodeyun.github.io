package com.mars.news.entity;

import java.sql.Date;

public class News {
	private Integer newsid;
	private String newstitle;
	private String newscontent;
	private Date createdate;
	private String keyword;
	private Integer categoryid;
	
	public News(){
		
	}

	public News(Integer newsid, String newstitle, String newscontent,
			Date createdate, String keyword, Integer categoryid) {
		super();
		this.newsid = newsid;
		this.newstitle = newstitle;
		this.newscontent = newscontent;
		this.createdate = createdate;
		this.keyword = keyword;
		this.categoryid = categoryid;
	}

	public Integer getNewsid() {
		return newsid;
	}

	public void setNewsid(Integer newsid) {
		this.newsid = newsid;
	}

	public String getNewstitle() {
		return newstitle;
	}

	public void setNewstitle(String newstitle) {
		this.newstitle = newstitle;
	}

	public String getNewscontent() {
		return newscontent;
	}

	public void setNewscontent(String newscontent) {
		this.newscontent = newscontent;
	}

	public Date getCreatedate() {
		return createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public Integer getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}

	@Override
	public String toString() {
		return "News [newsid=" + newsid + ", newstitle=" + newstitle
				+ ", newscontent=" + newscontent + ", createdate=" + createdate
				+ ", keyword=" + keyword + ", categoryid=" + categoryid + "]";
	}
	
	
}
