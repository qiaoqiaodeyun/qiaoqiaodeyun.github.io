package com.etc.mao.daoimpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.SortedMap;

import javax.servlet.jsp.jstl.sql.Result;

import com.etc.mao.comm.SQLCommandBean;
import com.etc.mao.dao.RepairDao;
import com.etc.mao.entity.Repair;

public class RepairImpl extends SQLCommandBean implements RepairDao {

	@SuppressWarnings("unused")
	@Override
	public List<Repair> checkinfo(String location, String status) {
		String sql = "select * from repair";
		List<Repair> p = new ArrayList<Repair>();
		Result rs = executeQuery(sql, p);
		if (rs != null && rs.getRowCount() != 0) {

			for (int i = 0; i < rs.getRowCount(); i++) {
				if (location == null && status != null) {
					if (status.equals(rs.getRows()[i].get("status"))) {
						p = addrepair(p, rs.getRows()[i]);
					}
					System.out.println("runhere 1");
				} else if (location != null && status == null) {
					if (location.equals(rs.getRows()[i].get("location"))) {
						p = addrepair(p, rs.getRows()[i]);
					}
					System.out.println("runhere 2");
				} else if (location != null && status != null) {
					if (location.equals(rs.getRows()[i].get("location"))
							&& status.equals(rs.getRows()[i].get("status"))) {
						p = addrepair(p, rs.getRows()[i]);
					}
					System.out.println("runhere 3");
				} else {
					p = addrepair(p, rs.getRows()[i]);
				}

			}
		}
		return p;
	}

	@SuppressWarnings("unused")
	private String search(Object phone, String sta) {
		String sql, res = null;
		if (phone == null) {
			res = null;
		} else {
			if (sta.equals("stu")) {
				sql = "select * from student";
			} else {
				sql = "select * from worker";
			}
			List<Repair> p = new ArrayList<Repair>();
			Result rs = executeQuery(sql, p);
			for (int i = 0; i < rs.getRowCount(); i++) {
				if (phone.equals(rs.getRows()[i].get("phone"))) {
					res = rs.getRows()[i].get("name").toString();
				}
			}
		}
		return res;

	}

	private List<Repair> addrepair(List<Repair> p, SortedMap sortedMap) {
		RepairImpl r = new RepairImpl();
		Repair repair = new Repair();
		if (sortedMap.get("id") != null) {
			repair.setId(Integer.valueOf(sortedMap.get("id").toString()));
		}
		if (sortedMap.get("miao") != null) {
			repair.setMiao(sortedMap.get("miao").toString());
		}
		if (sortedMap.get("stuphone") != null) {

			repair.setStuphone(sortedMap.get("stuphone").toString());
		}
		if (sortedMap.get("worphone") != null) {

			repair.setWorphone(sortedMap.get("worphone").toString());
		}
		if (sortedMap.get("location") != null) {

			repair.setLocation(sortedMap.get("location").toString());
		}
		if (sortedMap.get("studate") != null) {

			repair.setStudate(sortedMap.get("studate").toString());
		}
		if (sortedMap.get("wordate") != null) {

			repair.setWordate(sortedMap.get("wordate").toString());
		}
		if (sortedMap.get("grade") != null) {

			repair.setGrade(sortedMap.get("grade").toString());
		}
		if (sortedMap.get("reply") != null) {

			repair.setReply(sortedMap.get("reply").toString());
		}
		if (sortedMap.get("status") != null) {

			repair.setStatus(sortedMap.get("status").toString());
		}
		if (r.search(sortedMap.get("stuphone"), "stu") != null) {

			repair.setStuname(r.search(sortedMap.get("stuphone"), "stu"));
		}
		if (r.search(sortedMap.get("worphone"), "stu") != null) {

			repair.setWorname(r.search(sortedMap.get("worphone"), "wor"));
		}
		p.add(repair);
		System.out.println(repair.toString());
		return p;
	}

	public static void main(String[] args) {
		// List<String> l = new ArrayList<String>();
		// l = r.showReply("13672247121");
		// for (String repair : l) {
		// System.out.println("kaixin"+repair.toString());
		// }
		// r.insertinto("512321654", "二教", "灯坏了");
//		List<Repair> l = r.select("13672247121");
//		System.out.println(l.toString());
		RepairImpl r = new RepairImpl();
		r.updateComment(25, "维修的十分仔细，对细节的处理十分好");
	}

	@Override
	public List<String> showReply(String phone) {
		String sql = "select * from repair";
		List<String> p = new ArrayList<String>();
		Result rs = executeQuery(sql, p);
		if (rs != null && rs.getRowCount() != 0) {

			for (int i = 0; i < rs.getRowCount(); i++) {
				System.out.println("runhere");
				if (phone.equals(rs.getRows()[i].get("worphone"))) {
					System.out.println("runhere2");
					p.add(rs.getRows()[i].get("reply").toString());
					System.out.println(rs.getRows()[i].get("reply").toString());
				}
			}
		}
		return p;
	}

	@Override
	public void insertinto(String phone, String location, String status) {
		String sql = "INSERT INTO repair(stuphone,location,status,miao,studate) values(?,?,?,?,?)";
		List<String> list = new ArrayList<String>();
		list.add(phone);
		list.add(location);
		list.add("待修");
		list.add(status);
		Date date = new Date();
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);
		list.add(dateString);
		executeUpdate(sql, list);
	}

	@Override
	public List<Repair> select(String phone) {
		String sql = "select * from repair";
		List<Repair> p = new ArrayList<Repair>();
		Result rs = executeQuery(sql, p);
		if (rs != null && rs.getRowCount() != 0) {

			for (int i = 0; i < rs.getRowCount(); i++) {
				if (phone.equals(rs.getRows()[i].get("stuphone"))) {
					p = addrepair(p, rs.getRows()[i]);
				}
			}
		}
		return p;
	}

	@Override
	public void updateComment(int id, String comment) {
		String sql="update repair set reply=? , status=? where id="+id;
		List<String> list = new ArrayList<String>();
		list.add(comment);
		list.add("已完成");
		executeUpdate(sql, list);
	}
}
