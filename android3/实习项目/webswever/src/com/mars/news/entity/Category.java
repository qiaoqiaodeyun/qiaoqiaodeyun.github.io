package com.mars.news.entity;

public class Category {
	private Integer categoryid;
	private String categoryname;
	
	
	public Category(){
		
	}


	public Category(Integer categoryid, String categoryname) {
		super();
		this.categoryid = categoryid;
		this.categoryname = categoryname;
	}


	public Integer getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(Integer categoryid) {
		this.categoryid = categoryid;
	}


	public String getCategoryname() {
		return categoryname;
	}


	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}


	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categoryname="
				+ categoryname + "]";
	}
	
	
	
}
