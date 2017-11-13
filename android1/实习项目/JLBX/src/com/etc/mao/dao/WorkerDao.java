package com.etc.mao.dao;


import com.etc.mao.entity.Person;

public interface WorkerDao {
	public Person checklogin(String phone,String pass);
	
}
