package com.example.schoolfix;

import android.os.Bundle;

import com.example.net.HttpCallBack;
import com.example.net.HttpTask;

import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ResiterActivity extends Activity implements HttpCallBack{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_resiter);
		Button btn1 = (Button) findViewById(R.id.button1);
		btn1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				HttpTask task = new HttpTask(ResiterActivity.this);
				// 捆绑上回调方法
				task.setCallback(ResiterActivity.this);
				EditText et1 = (EditText) findViewById(R.id.editText1);
				EditText et2 = (EditText) findViewById(R.id.editText2);
				EditText et3 = (EditText) findViewById(R.id.editText3);
				String name=et1.getText().toString();
				String phone=et2.getText().toString();
				String pass=et3.getText().toString();
				String url = "http://10.0.2.2:8080/JLBX/AddStudent?name="+name+"&phone="+phone+"&pass="+pass;
//				String url = "http://172.26.18.19:8080/JLBX/AddStudent?name="+name+"&phone="+phone+"&pass="+pass;
				//String url = "http://10.0.2.2:8080/JLBX/StuLogin?username="+"13672247121"+"&pass="+"1995";
				task.execute(url);
				
			}
		});
	}

	
	@Override
	public void callback(String respone) {
		// TODO Auto-generated method stub
		Toast.makeText(ResiterActivity.this, respone, Toast.LENGTH_LONG).show();
	}

}
