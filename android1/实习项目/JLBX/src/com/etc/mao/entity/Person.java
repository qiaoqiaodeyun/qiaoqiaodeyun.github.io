package com.etc.mao.entity;

import java.io.Serializable;

public class Person implements Serializable{
	private int id;
	private String name;
	private String phone;
	private String pass;
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public Person(int id, String name, String phone, String pass) {
		super();
		this.id = id;
		this.name = name;
		this.phone = phone;
		this.pass = pass;
	}
	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", phone=" + phone
				+ ", pass=" + pass + "]";
	}
	
	public Person() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	
}
