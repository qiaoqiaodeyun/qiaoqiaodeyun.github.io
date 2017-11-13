package com.example.schoolfix;

import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.etc.mao.entity.Person;
import com.etc.mao.entity.Repair;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class DeclareActivity extends BaseActivity implements HttpCallBack {
	EditText et2, et3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_declare);
		et2 = (EditText) findViewById(R.id.editText2);
		et3 = (EditText) findViewById(R.id.editText3);
		Person p = getPerson();
		String name = p.getName();
		String phone = p.getPhone();
		String location = et2.getText().toString();
		String status = et3.getText().toString();
		System.out.println(location + "  dgfdgdfgfd " + status);
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Person p = getPerson();
				String name = p.getName();
				String phone = p.getPhone();
				String location = et2.getText().toString();
				String status = et3.getText().toString();
				HttpTask task = new HttpTask(DeclareActivity.this);
				// 捆绑上回调方法
				System.out.println(location + " dgfdgdfgfd " + status);
				task.setCallback(DeclareActivity.this);
				Repair r = new Repair();
				r.setStuname(name);
				r.setStuphone(phone);
				r.setLocation(location);
				r.setStatus(status);
				String rpair = JSON.toJSONString(r);
				String url = "http://10.0.2.2:8080/JLBX/AddRepair?phone=" + phone + "&location="
						+ location + "&status=" + status;
//				String url = "http://172.26.18.19:8080/JLBX/AddRepair?phone=" + phone + "&location="
//						+ location + "&status=" + status;

				task.execute(url);
			}
		});
	}

	@Override
	public void callback(String respone) {
		// TODO Auto-generated method stub
		Toast.makeText(DeclareActivity.this, "已成功提交", Toast.LENGTH_LONG).show();
		Intent intent=new Intent(DeclareActivity.this,MainActivity.class);
		startActivity(intent);
	}

}
