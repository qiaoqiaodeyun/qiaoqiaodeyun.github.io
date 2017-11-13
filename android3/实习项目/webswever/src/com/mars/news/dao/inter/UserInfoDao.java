package com.mars.news.dao.inter;

import java.util.List;

import com.mars.news.entity.UserInfo;

public interface UserInfoDao {
	/**
	 * �������ݿ��������û�
	 */
	public List<UserInfo> select();
	/**
	 * ��ѯ���ݿ��е�ĳ���û� 
	 */
	

	/**
	 * ���ӵ����û� ����ע��
	 * 
	 * 1���û������ֻ��ţ������ȡ��֤�룬
	 * 2������� ��ѯ���ֻ�ʱ���Ѿ�ע��
	 * 		���ע�ᣬ������Ϣ��ʾ���ֻ����Ѿ�ע�ᣬ����֪�����һ�����ķ�ʽ
	 * 		���û��ע�ᣬ�����û����ͽ�Ҫע����ֻ��ŷ�����֤��
	 * 3���û�����ע���룬Ȼ����֤ע�������ȷ�ԣ��û�����������û��ǳƣ�Ȼ����ȷ��ע��
	 * 4������˽������������
	 */
	public boolean register(String phone, String password);

	
	
	
	/**
	 * ��¼ �û�����绰�����������е�¼
	 * 
	 * 1���û������Լ�ʹ�õ��˺ź����룬�����¼��post��ʽ�ύ����
	 * 2���������õ����ݽ���ȷ���û���Ϣ����ȷ��
	 * 3�������û�����Ϣ
	 * 4������˽��н��н���
	 */
	
	public UserInfo select(String phone, String password);
	
	
	
	
	/**
	 * �һ����� 
	 * 1���û������ֻ��ţ������ȡ����֤��
	 * 2�������֤��������ȷ��������������Ľ���
	 */
	public boolean select(String phone);
	public boolean forgetpassword(String phone,String password);
}
