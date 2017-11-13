
package com.mars.news.comm;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConnectionManager {

	/**
	 * 返回连接
	 * 
	 * @return Connection
	 */
	public static synchronized Connection getConnection() {
		// 读出配置信息
		String driverClassName = Env.getInstance().getProperty("driver");
		String url = Env.getInstance().getProperty("url");
		String password = Env.getInstance().getProperty("password");
		String user = Env.getInstance().getProperty("user");
		Connection con = null;
		try {
			// 加载数据库驱动程序
			Class.forName(driverClassName);
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return con;
	}

	/**
	 * 关闭连接
	 * 
	 * @param con
	 */
	public static void closeConnection(Connection con) {
		try {
			if (con != null && !con.isClosed()) {
				con.close();
			}
		} catch (SQLException ex1) {
			System.err.println("Could not close connection : "
					+ ex1.getMessage());
		}
	}

	/**
	 * 关闭结果集
	 * 
	 * @param res
	 *            ResultSet
	 */
	public static void closeResultSet(ResultSet res) {
		try {
			if (res != null) {
				res.close();
				res = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 关闭语句
	 * 
	 * @param pStatement
	 *            PreparedStatement
	 */

	public static void closeStatement(PreparedStatement pStatement) {
		try {
			if (pStatement != null) {
				pStatement.close();
				pStatement = null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		
		
		ConnectionManager cm=new ConnectionManager();
		try {
			System.out.println(cm.getConnection());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}
}
