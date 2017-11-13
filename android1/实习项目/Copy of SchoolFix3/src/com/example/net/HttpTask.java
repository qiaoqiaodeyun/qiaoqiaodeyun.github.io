package com.example.net;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
/*�ڿ���AndroidӦ��ʱ�������ص��߳�ģ�͵�ԭ�� Android UI�����������̰߳�ȫ��
������Щ����������UI�߳���ִ�С��ڵ��߳�ģ����ʼ��Ҫ��ס��������
1. ��Ҫ����UI�߳�
2. ȷ��ֻ��UI�߳��з���Android UI���߰�
      ��һ�������һ������ʱ��Android��ͬʱ����һ����Ӧ�����߳�(Main Thread)��
      ���߳���Ҫ��������UI��ص��¼����磺�û��İ����¼���
��������ص��¼��ַ�����Ӧ��������д����������߳�ͨ���ֱ�����UI�̡߳�
android�ṩ�˼����������߳��з���UI�̵߳ķ�������Щ��򷽷�ͬ����ʹ��Ĵ���ܸ��Ӻ�����⡣Ȼ��������Ҫʵ��һЩ�ܸ��ӵĲ�������ҪƵ���ظ���UIʱ����ø���⡣

     Ϊ�˽��������⣬Android 1.5�ṩ��һ�������ࣺAsyncTask��
     ��ʹ������Ҫ���û����潻���ĳ�ʱ�����е������ø��򵥡�
     �����˵AsyncTask��������һЩ�������ڼ򵥵��첽��������Ҫ�����̺߳�Handler
     ����ʵ�֡� 
 *
 */

/*Params ��������ִ�е��������������HTTP�����URL��
Progress ��̨����ִ�еİٷֱȡ�
Result ��ִ̨���������շ��صĽ��������String��*/

public class HttpTask extends AsyncTask<String, Void, Void> {
	protected String response;
	protected HttpCallBack callback;
	
	/*
	 * private Context context; private boolean interact = false;
	 */
	private HttpHelper httpHelper;

	private ProgressDialog progressDialog = null;

	public HttpTask(Context context) {
		super();
		httpHelper = new HttpHelper();
		// ������ʾ
		progressDialog = ProgressDialog.show(context, "���Ժ󡣡���", "��ȡ��Դ�С�����",
				true, true);

	}

	public void setCallback(HttpCallBack callback) {
		this.callback = callback;
	}

	/**
	 * ��̨��������
	 */
	@Override
	protected Void doInBackground(String... params) {
		//String... params���������������ʱ����
		if (params.length > 1) {
			response = httpHelper.postPage(params[0], params[1]);
		} else {
			response = httpHelper.postPage(params[0], null);
		}
		return null;
	}

	

	/**
	 * ���߳̽���ʱ
	 */
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		//�ر���ʾ
		progressDialog.dismiss();
		//����ֵ
		if (callback != null) {
			callback.callback(response);
		}
	}
}
