package com.etc.mao.entity;


public class Repair{
	private int id;
	private String stuphone;
	private String stuname;
	private String worphone;
	private String worname;
	private String location;
	private String studate;
	private String wordate;
	private String grade;
	private String reply;
	private String status;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getStuphone() {
		return stuphone;
	}
	public void setStuphone(String stuphone) {
		this.stuphone = stuphone;
	}
	public String getStuname() {
		return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	public String getWorphone() {
		return worphone;
	}
	public void setWorphone(String worphone) {
		this.worphone = worphone;
	}
	public String getWorname() {
		return worname;
	}
	public void setWorname(String worname) {
		this.worname = worname;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getStudate() {
		return studate;
	}
	public void setStudate(String studate) {
		this.studate = studate;
	}
	public String getWordate() {
		return wordate;
	}
	public void setWordate(String wordate) {
		this.wordate = wordate;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getReply() {
		return reply;
	}
	public void setReply(String reply) {
		this.reply = reply;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Repair(int id, String stuphone, String stuname, String worphone,
			String worname, String location, String studate, String wordate,
			String grade, String reply, String status) {
		super();
		this.id = id;
		this.stuphone = stuphone;
		this.stuname = stuname;
		this.worphone = worphone;
		this.worname = worname;
		this.location = location;
		this.studate = studate;
		this.wordate = wordate;
		this.grade = grade;
		this.reply = reply;
		this.status = status;
	}
	public Repair() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Repair [id=" + id + ", stuphone=" + stuphone + ", stuname="
				+ stuname + ", worphone=" + worphone + ", worname=" + worname
				+ ", location=" + location + ", studate=" + studate
				+ ", wordate=" + wordate + ", grade=" + grade + ", reply="
				+ reply + ", status=" + status + "]";
	}
	
}
