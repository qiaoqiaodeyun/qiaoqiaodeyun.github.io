
package com.etc.mao.comm;

import java.io.InputStream;
import java.util.Properties;

/**
 * ����һ��db.properties�ļ�����
 * �ṩ.getProperty(key)��ȡ�����ļ�������
 * @author wind
 *
 */
public final class Env extends Properties {
  //Properties���ṩ load(InputStream), 
	//String getProperty("key");
	private static final long serialVersionUID = 1L;

	private static Env instance;

	/**
	 * ���еĻ�ȡʵ���ķ���
	 * @return Env ʵ��
	 */
	public static Env getInstance() {
		if (instance != null) {
			return instance;
		} else {
			makeInstance();
			return instance;
		}
	}

	/**
	 * ͬ���Ĵ���ʵ������
	 *
	 */
	private static synchronized void makeInstance() {
		if (instance == null) {
			instance = new Env();
		}
	}
	
	/**
	 * ˽�еĹ��췽����ȷ��ʵ����Ψһ��
	 *
	 */
	private Env() {
		InputStream is = getClass().getResourceAsStream("/db.properties");
		try {
			load(is);
		} catch (Exception e) {
			System.err.println("����û�ж�ȡ�����ļ�����ȷ��db.property�ļ��Ƿ���ڡ�");
			return;
		}
	}
	
	public static void main(String[] args) {
		System.out.println("driver="+
		Env.getInstance().getProperty("driver"));
	}
}









