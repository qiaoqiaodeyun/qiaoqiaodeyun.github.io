package com.etc.mao.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String driver="org.gjt.mm.mysql.Driver";
		String url="jdbc:mysql://localhost:3306/jiangli";
		String user="root";
		String password="123456";
		
	
			try {
				Class.forName(driver);
			  Connection  conn= 	DriverManager.getConnection(url, user, password);
				
				if(conn!=null){
					System.out.println("连接成功");
					
				}else{
					System.out.println("err");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	
		
		
		

	}

}
