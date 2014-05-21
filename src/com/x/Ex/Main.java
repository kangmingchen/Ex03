package com.x.Ex;

import com.x.Ex.calculator.Calculator;
import com.x.Ex.menu.MyMenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * <p>
 * Description: 使用setContextView来置换页面还有一个特别的有点，即所有程序里的变量皆存在相同的状态，无论是类成员变量、类参数等，
 * 接可以在一个Activity的状态中取得，并没有参数传递的问题
 * </p>
 * 
 * @author Chenkm
 * @version 1.0
 * @date 2014年5月20日
 */
public class Main extends Activity implements OnClickListener {

	private TextView mTextView01 = null;
	private Intent intent = null;

	private ProgressDialog myDialog = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.main);
		mTextView01 = (TextView) findViewById(R.id.myTextView01);
		String str = "欢迎来到Android的TextView世界...";
		mTextView01.setText(str);

		// 切换到Layout2
		Button b1 = (Button) findViewById(R.id.btn_main_layout);
		b1.setOnClickListener(this);

		// 调用Activity
		Button activityBtn = (Button) findViewById(R.id.btn_main_activity);
		activityBtn.setOnClickListener(this);

		// 计算体重
		Button weightBtn = (Button) findViewById(R.id.btn_main_toweight1);
		weightBtn.setOnClickListener(this);

		// 弹出对话框
		Button dialogBtn = (Button) findViewById(R.id.btn_main_dialog);
		dialogBtn.setOnClickListener(this);

		// 点击改变字体颜色
		Button changeBtn = (Button) findViewById(R.id.btn_main_changetextcolor);
		changeBtn.setOnClickListener(this);

		// 调用计算器
		Button calBtn = (Button) findViewById(R.id.btn_main_calculator);
		calBtn.setOnClickListener(this);

		// 调用菜单
		Button menuBtn = (Button) findViewById(R.id.btn_main_menu);
		menuBtn.setOnClickListener(this);

		// 程序加载中，请稍候
		Button progressBtn = (Button) findViewById(R.id.btn_main_progress);
		progressBtn.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_main_layout) {
			jumpToLayout2();
		} else if (v.getId() == R.id.btn_second_layout) {
			jumpToLayout1();
		} else if (v.getId() == R.id.btn_main_activity) {
			Log.i("main", "start main ....");
			// new 一个Intent对象，并指定要启动的class
			intent = new Intent();
			intent.setClass(Main.this, Second.class);
			// 调用一个新的Activity
			startActivity(intent);
			// 关闭原本的Activity
			/**
			 * 单击back不会返回上一页
			 */
			Main.this.finish();
		} else if (v.getId() == R.id.btn_main_toweight1) { // 计算体重
			intent = new Intent();
			intent.setClass(Main.this, Weight1.class);
			startActivity(intent);
		} else if (v.getId() == R.id.btn_main_dialog) { // 弹出对话框
			Log.i("main", "dialog ...");
			new AlertDialog.Builder(Main.this).setTitle(R.string.app_name).setMessage(R.string.common_dialog).setPositiveButton(R.string.common_dialog_ok, new DialogInterface.OnClickListener() {

				@Override
				public void onClick(DialogInterface dialog, int which) {
					// TODO Auto-generated method stub
					/* 在这里涉及当对话框按钮单击之后要运行的事件 */
					// 例如退出
					finish();
				}
			}).show();
		} else if (v.getId() == R.id.btn_main_changetextcolor) { // 通过点击按钮改变文本颜色
			int mycolor = getResources().getColor(R.color.green);
			mTextView01.setTextColor(mycolor);
		} else if (v.getId() == R.id.btn_main_calculator) { // 调用简易计算器
			intent = new Intent();
			intent.setClass(Main.this, Calculator.class);
			startActivity(intent);
		} else if (v.getId() == R.id.btn_main_menu) { // 调用菜单
			intent = new Intent();
			intent.setClass(Main.this, MyMenu.class);
			startActivity(intent);
		} else if (v.getId() == R.id.btn_main_progress) {// 程序加载中，请稍候
			final CharSequence strDialogTitle = getString(R.string.main_dialog_title);
			final CharSequence strDialogBody = getString(R.string.main_dialog_title);

			// 显示Progress对话框
			myDialog=ProgressDialog.show(Main.this, strDialogTitle, strDialogBody,true);
			new Thread(){
				public void run(){
					try {
						sleep(3000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}finally{
						myDialog.dismiss();
					}
				}
			}.start();	//开始执行线程
		}

	}

	public void jumpToLayout2() {
		setContentView(R.layout.second);

		Button b2 = (Button) findViewById(R.id.btn_second_layout);
		b2.setOnClickListener(this);
	}

	public void jumpToLayout1() {
		setContentView(R.layout.main);

		Button b1 = (Button) findViewById(R.id.btn_main_layout);
		b1.setOnClickListener(this);
	}
}
