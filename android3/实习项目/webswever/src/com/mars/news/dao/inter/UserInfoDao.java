package com.mars.news.dao.inter;

import java.util.List;

import com.mars.news.entity.UserInfo;

public interface UserInfoDao {
	/**
	 * 查找数据库中所有用户
	 */
	public List<UserInfo> select();
	/**
	 * 查询数据库中的某个用户 
	 */
	

	/**
	 * 增加单个用户 用于注册
	 * 
	 * 1、用户输入手机号，点击获取验证码，
	 * 2、服务端 查询该手机时候已经注册
	 * 		如果注册，返回信息表示改手机号已经注册，并告知可以找回密码的方式
	 * 		如果没有注册，则象用户发送将要注册的手机号发送验证码
	 * 3、用户输入注册码，然后验证注册码的正确性，用户输入密码和用户昵称，然后点击确认注册
	 * 4、服务端进行添加数据项
	 */
	public boolean register(String phone, String password);

	
	
	
	/**
	 * 登录 用户输入电话号码和密码进行登录
	 * 
	 * 1、用户输入自己使用的账号和密码，点击登录，post方式提交数据
	 * 2、服务器拿到数据进行确认用户信息的正确性
	 * 3、返回用户的信息
	 * 4、服务端进行进行解析
	 */
	
	public UserInfo select(String phone, String password);
	
	
	
	
	/**
	 * 找回密码 
	 * 1、用户输入手机号，输入获取的验证码
	 * 2、如果验证码输如正确，进入重置密码的界面
	 */
	public boolean select(String phone);
	public boolean forgetpassword(String phone,String password);
}
