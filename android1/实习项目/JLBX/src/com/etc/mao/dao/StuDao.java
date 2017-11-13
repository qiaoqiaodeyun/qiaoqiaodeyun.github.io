package com.etc.mao.dao;

import com.etc.mao.entity.Person;

public interface StuDao {
	
	public Person checklogin(String phone,String pass);
	
	public void register(Person p);
	
	public void comment(String comm);
}
