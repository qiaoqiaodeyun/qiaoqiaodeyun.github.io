package com.example.schoolfix;

import android.os.Bundle;

import java.util.List;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.etc.mao.entity.Person;
import com.etc.mao.entity.Repair;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class ListActivity extends BaseActivity implements HttpCallBack, OnItemClickListener {
	ListView listview;
	String re[] = null;
	String response2=null;
	EditText pp=null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_list);
		HttpTask task = new HttpTask(ListActivity.this);
		// 捆绑上回调方法
		listview = (ListView) findViewById(R.id.listView1);
		listview.setOnItemClickListener(this);
		task.setCallback(ListActivity.this);
		Person p = getPerson();
		System.out.println(p.getPhone());
		// String url =
		// "http://192.168.175.1:8080/JLBX/ShowMy?phone="+p.getPhone();
		String url = "http://10.0.2.2:8080/JLBX/ShowMy?phone=" + p.getPhone();
		// String url = "http://172.26.18.19:8080/JLBX/ShowMy?phone=" +
		// p.getPhone();
		task.execute(url);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.list, menu);
		return true;
	}

	@Override
	public void callback(String respone) {
		// List<Person> pp=(List<Person>) JSON.parseObject(respone,
		// Person.class);
		response2=respone;
		System.out.println(respone);
		List<Repair> stu = JSON.parseObject(respone, new TypeReference<List<Repair>>() {
		});
		// List<Person> stu =JSON.parseObject(respone,List.class);
		re = new String[stu.size()];
		for (int i = 0; i < stu.size(); i++) {
			int j = stu.get(i).getLocation().length();
			String ss = stu.get(i).getLocation();
			while (j <= 50) {
				ss += " ";
				j++;
			}
			re[i] = stu.get(i).getStudate() + "     |     " + ss + "     |     " + stu.get(i).getStatus();
			System.out.println(stu.get(i));
		}
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, re);

		listview.setAdapter(adapter);

	}

	@Override
	public void onItemClick(AdapterView<?> parent, View view,  final int position, long id) {
		// TODO Auto-generated method stub
		//tos.show();
//		new AlertDialog.Builder(this).setIcon(R.drawable.icon).setTitle("请填写评价").setIcon(android.R.drawable.ic_dialog_info)
//				.setView(new EditText(this)).setPositiveButton("确定", null).setNegativeButton("取消", null).show();
		AlertDialog.Builder dia=new AlertDialog.Builder(ListActivity.this);
		dia.setTitle("请输入评价");
		dia.setView(pp=new EditText(this));
		dia.setIcon(R.drawable.icon);
		dia.setNegativeButton("维修已完成", new DialogInterface.OnClickListener() {
			
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub
				System.out.println(pp.getText().toString()+"dsfjidshfjd");
				HttpTask task = new HttpTask(ListActivity.this);
				List<Repair> stu = JSON.parseObject(response2, new TypeReference<List<Repair>>() {
				});
				Repair p=stu.get(position);
				System.out.println(p.toString());
				String url = "http://10.0.2.2:8080/JLBX/UpdateComment?id=" +p.getId()+ "&reply="
						+pp.getText();
				task.execute(url);
				Intent intent=new Intent(ListActivity.this,ListActivity.class);
				startActivity(intent);
			}
		}); 
		dia.setPositiveButton("取消", null);
		dia.create().show();
	}

}
