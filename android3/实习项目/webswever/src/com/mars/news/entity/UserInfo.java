package com.mars.news.entity;

public class UserInfo {
	private Integer userid;
	private String username;
	private String userpassword;
	private String userphone;
	
	public UserInfo(){
		
	}

	public UserInfo(Integer userid, String username, String userpassword,
			String userphone) {
		super();
		this.userid = userid;
		this.username = username;
		this.userpassword = userpassword;
		this.userphone = userphone;
	}

	public UserInfo(String username, String userpassword) {
		super();
		this.username = username;
		this.userpassword = userpassword;
	}

	public Integer getUserid() {
		return userid;
	}

	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getUserpassword() {
		return userpassword;
	}

	public void setUserpassword(String userpassword) {
		this.userpassword = userpassword;
	}

	public String getUserphone() {
		return userphone;
	}

	public void setUserphone(String userphone) {
		this.userphone = userphone;
	}

	@Override
	public String toString() {
		return "UserInfo [userid=" + userid + ", username=" + username
				+ ", userpassword=" + userpassword + ", userphone=" + userphone
				+ "]";
	}
	
	
	
}
