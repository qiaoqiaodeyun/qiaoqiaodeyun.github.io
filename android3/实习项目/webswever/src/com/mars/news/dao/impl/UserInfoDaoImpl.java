package com.mars.news.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.mars.news.comm.SQLCommandBean;
import com.mars.news.dao.inter.UserInfoDao;
import com.mars.news.entity.UserInfo;

public class UserInfoDaoImpl extends SQLCommandBean implements UserInfoDao {

	public List<UserInfo> select() {

		List<UserInfo> list = new ArrayList<UserInfo>();

		String sql = "select * from userinfo";
		Result result = executeQuery(sql, null);

		SortedMap[] maps = result.getRows();
		int i = result.getRowCount();
		for (int j = 0; j < i; j++) {
			UserInfo user = new UserInfo();
			Map map = maps[j];
			user.setUserid((Integer) map.get("userid"));
			user.setUsername((String) map.get("username"));
			user.setUserpassword((String) map.get("userpassword"));
			user.setUserphone((String) map.get("userphone"));
			list.add(user);
		}

		return list;
	}

	public UserInfo select(String phone, String password) {
		UserInfo userinfo = new UserInfo();
		// �����ݿ�����е��ʺ� ��ݵļ���
		List values = new ArrayList();
		values.add(phone);
		values.add(password);

		// 数据库语句
		String sql = "select * from userinfo where userphone=? or userpassword=?";

		// ����result�� ����result����resultSet�����аٶ�
		Result result = executeQuery(sql, values);

		SortedMap[] maps = result.getRows();
		Map map = maps[0];
		userinfo.setUserid((Integer) map.get("userid"));
		userinfo.setUsername((String) map.get("username"));
		userinfo.setUserpassword(password);
		userinfo.setUserphone(phone);

		return userinfo;
	}



	public boolean register(String phone, String password) {

		UserInfo userinfo = select(phone, password);
		if (userinfo != null) {
			String sql = "insert into userinfo(username,userpassword,userphone) values(?,?,?)";
			List list = new ArrayList();
			list.add(userinfo.getUsername());
			list.add(userinfo.getUserpassword());
			list.add(userinfo.getUserphone());
			executeUpdate(sql, list);
			return true; // ��ʾע��ɹ�
		}

		return false;
	}
	
	public boolean select(String phone) {

		UserInfo userinfo = select(phone, null);
		if(userinfo != null){
			return true;
		}
		return false;
	}

	public boolean forgetpassword(String phone,String password) {
		
//		UserInfo userinfo = select(phone, null);
//		System.out.println("userinfo ��ϸ��Ϣ"+userinfo.toString());
		List values = new ArrayList();

		values.add(password);
		values.add(phone);

		executeUpdate("update userinfo set userpassword=? where userphone=?", values);

		
		
		return false;
	}


}
