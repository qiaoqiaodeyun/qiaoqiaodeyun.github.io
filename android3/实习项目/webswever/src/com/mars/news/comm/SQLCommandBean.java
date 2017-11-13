package com.mars.news.comm;

import java.util.*;
import java.sql.*;
import javax.servlet.jsp.jstl.sql.*;

/*
 * ͨ�õ�JDBC���ݿ������
 */
public class SQLCommandBean {
	private Connection conn;
	private String sqlValue; // ִ�е�SQL���
	private List values; // ���ε�SQL���Ĳ�������

	/**
	 * �趨������
	 */
	public void setConnection(Connection conn) {
		this.conn = conn;
	}

	/**
	 * �趨SQL���.
	 */
	public void setSqlValue(String sqlValue) {
		this.sqlValue = sqlValue;
	}

	/**
	 * �趨SQL���Ĳ���
	 */
	public void setValues(List values) {
		this.values = values;
	}

	/**
	 * ִ�в�ѯ
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

			// ��ResultSet��������ݷ�װ��Result���Ͷ�����
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
	 * ִ��Update���
	 * 
	 * @return the number of rows affected,����ִ�в���Ӱ��ļ�¼��
	 * @exception SQLException
	 */
	public int executeUpdate(String sqlValue, List values) {
		int noOfRows = 0;
		PreparedStatement pstmt = null;
		Statement stmt = null;
		setConnection(ConnectionManager.getConnection());
		try {
			if (values != null && values.size() > 0) {
				// ���ε�SQL
				// Use a PreparedStatement and set all values
				pstmt = conn.prepareStatement(sqlValue);
				setValues(pstmt, values);// ���ݲ����������θ�ֵ��pstmt��
				noOfRows = pstmt.executeUpdate();
			} else {// ����������SQL
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
	 * �趨���Ĳ���.
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
