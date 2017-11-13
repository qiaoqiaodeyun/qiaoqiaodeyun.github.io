package com.mars.news.test;

import java.util.List;

import org.junit.Test;

import com.mars.news.dao.impl.UserInfoDaoImpl;
import com.mars.news.dao.inter.UserInfoDao;
import com.mars.news.entity.UserInfo;


public class TestUserInfoDaoImpl {

	UserInfoDao user = new UserInfoDaoImpl();
	
//	@Test
//	public void testselect(){
//		List<UserInfo> list = user.select();
//		System.out.println("++++++++++");
//		for(UserInfo user1 : list){
//			System.out.println(user1.toString());
//		}
//		System.out.println("++++++++++");
//		
//	}
	
	@Test
	public void login(){
		UserInfo userinfo=user.select("18799423386", "123");
		System.out.println(userinfo.toString());
		
	}
//	@Test
//	public void register(){
//		
//		boolean item= user.register("18799423386", "123");
//		System.out.println(item==true?"ע��ɹ���":"ע��ʧ�ܣ�");
//	}
//	
//	@Test
//	public void forgetpassword(){
//		user.forgetpassword("18799423386","123456");
////		System.out.println("�޸ĺ�");
//		testselect();
//	}
}
