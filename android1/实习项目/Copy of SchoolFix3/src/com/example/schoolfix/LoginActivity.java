package com.example.schoolfix;

import android.os.Bundle;

import com.alibaba.fastjson.JSON;
import com.etc.mao.entity.Person;
import com.example.net.HttpCallBack;
import com.example.net.HttpTask;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends BaseActivity implements OnClickListener, HttpCallBack {
	EditText et1, et2;
	HttpTask task;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.login_main);
		et1 = (EditText) findViewById(R.id.editText1);
		et2 = (EditText) findViewById(R.id.editText2);
		Button btn1 = (Button) findViewById(R.id.button1);
		Button btn2 = (Button) findViewById(R.id.button2);
		btn1.setOnClickListener(this);
		btn2.setOnClickListener(this);

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.button1:
			login();
			break;
		case R.id.button2:
			regeist();
			break;
		default:
			break;
		}
	}

	private void regeist() {
		Intent intent = new Intent(LoginActivity.this, ResiterActivity.class);
		startActivity(intent);
	}

	private void login() {
		String username = et1.getText().toString();
		String pass = et2.getText().toString();
		// json
		task = new HttpTask(LoginActivity.this);
		// 捆绑上回调方法
		task.setCallback(LoginActivity.this);
		String url = "http://10.0.2.2:8080/JLBX/StuLogin?username=" + username + "&pass=" + pass;
//		String url = "http://172.26.18.19:8080/JLBX/StuLogin?username=" + username + "&pass=" + pass;
		// String url =
		// "http://10.0.2.2:8080/JLBX/StuLogin?username="+"13672247121"+"&pass="+"1995";
		task.execute(url);

	}

	@Override
	public void callback(String respone) {
		System.out.println(respone.toString());
		if (respone != null) {
			if ("err".equals(respone)) {
				Toast.makeText(LoginActivity.this, respone, Toast.LENGTH_LONG).show();
				
			} else {
			 
//				Person p=(Person) JSONObject.parse(respone);
				Person p=JSON.parseObject(respone, Person.class);
				setPerson(p);
				System.out.println("kiawai"+p.toString());
				Intent intent = new Intent(LoginActivity.this, MainActivity.class);
				startActivity(intent);	
				finish();
			}

		}

		
		
	}

}
