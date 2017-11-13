package com.etc.mao.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.jstl.sql.Result;

import com.etc.mao.comm.SQLCommandBean;
import com.etc.mao.dao.StuDao;
import com.etc.mao.entity.Person;

public class StuImpl extends SQLCommandBean implements StuDao {

	@Override
	public Person checklogin(String phone, String pass) {
		String sql = "select * from student";
		List<Person> p = new ArrayList<Person>();
		Result rs = executeQuery(sql, p);
		Person person = null;
		if (rs != null && rs.getRowCount() != 0) {
			System.out.println("runhere");
			for (int i = 0; i < rs.getRowCount(); i++) {
				if (phone.equals(rs.getRows()[i].get("phone").toString())
						&& pass.equals(rs.getRows()[i].get("password")
								.toString())) {
					person = new Person();
					person.setId(Integer.valueOf(rs.getRows()[0].get("id")
							.toString()));
					person.setName(rs.getRows()[i].get("name").toString());
					person.setPhone(rs.getRows()[i].get("phone").toString());
					person.setPass(rs.getRows()[i].get("password").toString());
				}
			}
		}
		return person;
	}

	@Override
	public void register(Person p) {
		String sql="insert into student(name,phone,password) values(?,?,?)";
		List<String> list=new ArrayList<String>();
		list.add(p.getName());
		list.add(p.getPhone());
		list.add(p.getPass());
		executeUpdate(sql, list);
	}
		public static void main(String[] args) {
			StuImpl stu=new StuImpl();
//			Person per=new Person();
//			per.setName("dsad");
//			per.setPass("dsadsa");
//			per.setPhone("56454651");
//			stu.register(per);
			System.out.println(stu.checklogin("123456", "123456"));
		}
	@Override
	public void comment(String comm) {
		// TODO Auto-generated method stub

	}

}
