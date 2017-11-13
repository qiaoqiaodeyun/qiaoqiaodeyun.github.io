package com.mars.news.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJDBC {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
	
		String driver="org.gjt.mm.mysql.Driver";
		String url="jdbc:mysql://localhost:3306/pengge";
		String user="root";
		String password="117528";
		
	
			try {
				Class.forName(driver);
			  Connection  conn= 	DriverManager.getConnection(url, user, password);
				
				if(conn!=null){
					System.out.println(conn);
					
				}else{
					System.out.println("err");
				}
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
	
		
		
		

	}

}
