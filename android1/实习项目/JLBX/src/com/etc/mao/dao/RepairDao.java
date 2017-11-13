package com.etc.mao.dao;

import java.util.List;

import com.etc.mao.entity.Person;
import com.etc.mao.entity.Repair;

public interface RepairDao {
	
	public List<Repair> checkinfo(String location,String status);
	
	public List<String> showReply(String phone);
	
	public void insertinto(String phone,String location,String status);
	
	public List<Repair> select(String phone);
	
	public void updateComment(int id,String comment);
	
	
}
