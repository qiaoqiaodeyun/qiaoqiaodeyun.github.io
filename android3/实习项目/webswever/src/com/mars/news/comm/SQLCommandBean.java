package com.mars.news.comm;

import java.util.*;
import java.sql.*;
import javax.servlet.jsp.jstl.sql.*;

/*
 * 通用的JDBC数据库访问类
 */
public class SQLCommandBean {
	private Connection conn;
	private String sqlValue; // 执行的SQL语句
	private List values; // 带参的SQL语句的参数集合

	/**
	 * 设定连接类
	 */
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	/**
	 * 设定SQL语句.
	 */
	public void setSqlValue(String sqlValue) {
		this.sqlValue = sqlValue;
	}

	/**
	 * 设定SQL语句的参数
	 */
	public void setValues(List values) {
		this.values = values;
	}

	/**
	 * 执行查询
	 * 
	 * @return a javax.servlet.jsp.jstl.sql.Result object
	 * @exception SQLException
	 */
	public Result executeQuery(String sqlValue, List values) {
		Result result = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		setConnection(ConnectionManager.getConnection());
		try {
			if (values != null && values.size() > 0) {
				// Use a PreparedStatement and set all values
				pstmt = conn.prepareStatement(sqlValue);
				setValues(pstmt, values);
				rs = pstmt.executeQuery();
			} else {
				// Use a regular Statement
				stmt = conn.createStatement();
				rs = stmt.executeQuery(sqlValue);
			}
			result = ResultSupport.toResult(rs);

			// 把ResultSet对象的数据封装到Result类型对象中
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
				}
			}
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			ConnectionManager.closeConnection(conn);
		}
		return result;
	}

	/**
	 * 执行Update语句
	 * 
	 * @return the number of rows affected,返回执行操作影响的记录数
	 * @exception SQLException
	 */
	public int executeUpdate(String sqlValue, List values) {
		int noOfRows = 0;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		setConnection(ConnectionManager.getConnection());
		try {
			if (values != null && values.size() > 0) {
				// 带参的SQL
				// Use a PreparedStatement and set all values
				pstmt = conn.prepareStatement(sqlValue);
				setValues(pstmt, values);// 根据参数集合依次赋值到pstmt中
				noOfRows = pstmt.executeUpdate();
			} else {// 不带参数的SQL
					// Use a regular Statement
				stmt = conn.createStatement();
				noOfRows = stmt.executeUpdate(sqlValue);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
				}
			}
			ConnectionManager.closeConnection(conn);
		}
		return noOfRows;
	}

	/**
	 * 设定语句的参数.
	 * 
	 * @param pstmt
	 *            the PreparedStatement
	 * @param values
	 *            a List with objects
	 * @exception SQLException
	 */
	private void setValues(PreparedStatement pstmt, List values)
			throws SQLException {
		// System.out.println(sqlValue);
		for (int i = 0; i < values.size(); i++) {
			Object v = values.get(i);
			// Set the value using the method corresponding to the type.
			// Note! Set methods are indexed from 1, so we add 1 to i
			pstmt.setObject(i + 1, v);
			// System.out.println(v);
		}

	}
}
