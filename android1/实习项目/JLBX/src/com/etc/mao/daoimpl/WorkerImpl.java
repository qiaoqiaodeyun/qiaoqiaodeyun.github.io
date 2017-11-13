package com.etc.mao.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.jsp.jstl.sql.Result;

import com.etc.mao.comm.SQLCommandBean;
import com.etc.mao.dao.WorkerDao;
import com.etc.mao.entity.Person;
import com.etc.mao.entity.Repair;
import com.mysql.jdbc.ResultSet;

public class WorkerImpl extends SQLCommandBean implements WorkerDao {

	@Override
	public Person checklogin(String phone, String pass) {
		String sql = "select * from worker";
		List<Person> p = new ArrayList<Person>();
		Result rs = executeQuery(sql, p);
		Person person = null;
		if (rs != null && rs.getRowCount() != 0) {
			for (int i = 0; i < rs.getRowCount(); i++) {
				if (phone.equals(rs.getRows()[0].get("phone").toString())
						&& pass.equals(rs.getRows()[0].get("password")
								.toString())) {
					person = new Person();
					person.setId(Integer.valueOf(rs.getRows()[0].get("id")
							.toString()));
					person.setName(rs.getRows()[0].get("name").toString());
					person.setPhone(rs.getRows()[0].get("phone").toString());
					person.setPass(rs.getRows()[0].get("password").toString());
				}
				// System.out.println(person.toString());
			}
		}
		return person;

	}

}
