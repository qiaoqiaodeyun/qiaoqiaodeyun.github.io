package com.example.net;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
/*在开发Android应用时必须遵守单线程模型的原则： Android UI操作并不是线程安全的
并且这些操作必须在UI线程中执行。在单线程模型中始终要记住两条法则：
1. 不要阻塞UI线程
2. 确保只在UI线程中访问Android UI工具包
      当一个程序第一次启动时，Android会同时启动一个对应的主线程(Main Thread)，
      主线程主要负责处理与UI相关的事件，如：用户的按键事件，
，并把相关的事件分发到对应的组件进行处理。所以主线程通常又被叫做UI线程。
android提供了几种在其他线程中访问UI线程的方法。这些类或方法同样会使你的代码很复杂很难理解。然而当你需要实现一些很复杂的操作并需要频繁地更新UI时这会变得更糟糕。

     为了解决这个问题，Android 1.5提供了一个工具类：AsyncTask，
     它使创建需要与用户界面交互的长时间运行的任务变得更简单。
     相对来说AsyncTask更轻量级一些，适用于简单的异步处理，不需要借助线程和Handler
     即可实现。 
 *
 */

/*Params 启动任务执行的输入参数，比如HTTP请求的URL。
Progress 后台任务执行的百分比。
Result 后台执行任务最终返回的结果，比如String。*/

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
		// 启动提示
		progressDialog = ProgressDialog.show(context, "请稍后。。。", "获取资源中。。。",
				true, true);

	}

	public void setCallback(HttpCallBack callback) {
		this.callback = callback;
	}

	/**
	 * 后台运行主体
	 */
	@Override
	protected Void doInBackground(String... params) {
		//String... params不清楚参数几个的时候用
		if (params.length > 1) {
			response = httpHelper.postPage(params[0], params[1]);
		} else {
			response = httpHelper.postPage(params[0], null);
		}
		return null;
	}

	

	/**
	 * 当线程结束时
	 */
	@Override
	protected void onPostExecute(Void result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		//关闭提示
		progressDialog.dismiss();
		//返回值
		if (callback != null) {
			callback.callback(response);
		}
	}
}
