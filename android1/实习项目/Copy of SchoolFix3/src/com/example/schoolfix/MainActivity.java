package com.example.schoolfix;

import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

import com.etc.mao.entity.Person;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends BaseActivity implements OnClickListener {

	long [] times=new long[2];

	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ImageButton im1 = (ImageButton) findViewById(R.id.imageButton1);
		ImageButton im2 = (ImageButton) findViewById(R.id.imageButton2);
		ImageButton im3 = (ImageButton) findViewById(R.id.imageButton3);
		ImageButton im4 = (ImageButton) findViewById(R.id.imageButton4);
		im1.setOnClickListener(this);
		im2.setOnClickListener(this);
		im3.setOnClickListener(this);
		im4.setOnClickListener(this);
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageButton1:
			weixiu();
			break;
		case R.id.imageButton2:

			break;
		case R.id.imageButton3:
			qingdan();
			break;
		case R.id.imageButton4:
			login();
			break;
		default:
			break;
		}
	}

	private void qingdan() {
		// TODO Auto-generated method stub
		Person n=getPerson();
		System.out.println(n+"hjsadhjsahdjsa");
		if(n==null){
			Intent intent=new Intent(MainActivity.this,LoginActivity.class);
			startActivity(intent);
		}
		else{
			Intent intents=new Intent(MainActivity.this,ListActivity.class);
			this.startActivity(intents);
		}
	}

	private void weixiu() {
		// TODO Auto-generated method stub
		Person n=getPerson();
		System.out.println(n+"hjsadhjsahdjsa");
		if(n==null){
			Intent intent=new Intent(MainActivity.this,LoginActivity.class);
			startActivity(intent);
			finish();
		}
		else{
			Intent intents=new Intent(MainActivity.this,DeclareActivity.class);
			this.startActivity(intents);
		}
	}

	private void login() {
		
		
		getPerson();
		Intent intent=new Intent(MainActivity.this,LoginActivity.class);
		startActivity(intent);
	}
	


//	@Override
//	public boolean onKeyDown(int keyCode, KeyEvent event) {
//		// TODO Auto-generated method stub
//		if (keyCode == KeyEvent.KEYCODE_BACK) {
//			Log.i("wzx", "KEYCODE_BACK �ҵ㷵�ؼ�");
//			// �١��ҳ��ص�����
//			// �ڡ����ʱ�� time1 time2
//			// �ۡ�ʱ�� ��� <2000 �˳�
//			// �ܡ���ʾ�ٵ�һ��
//			times[0] = times[1];
//			times[1] = System.currentTimeMillis();
//			Log.i("wzx", Arrays.toString(times));
//			if (times[1] - times[0] < 2000) {
//				finish();
//			} else {
//				Toast.makeText(getBaseContext(), "�ٵ�һ���˳�", 0).show();
//			}
//			return true;// �����¼�
//		}
//		return super.onKeyDown(keyCode, event);
//	}
	@SuppressLint("ShowToast")
	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		// TODO Auto-generated method stub
		if (keyCode == KeyEvent.KEYCODE_BACK) {
			Log.i("wzx", "KEYCODE_BACK �ҵ㷵�ؼ�");
			// �١��ҳ��ص�����
			// �ڡ����ʱ�� time1 time2
			// �ۡ�ʱ�� ��� <2000 �˳�
			// �ܡ���ʾ�ٵ�һ��
			times[0] = times[1];
			times[1] = System.currentTimeMillis();
			Log.i("wzx", Arrays.toString(times));
			if (times[1] - times[0] < 2000) {
				finish();
			} else {
				Toast.makeText(getBaseContext(), "�ٵ�һ���˳�", 0).show();
			}
			return true;// �����¼�
		}
		return super.onKeyDown(keyCode, event);
	}

}
