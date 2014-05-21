package com.x.Ex.menu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.x.Ex.R;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author Chenkm
 * @version 1.0
 * @date 2014年5月21日
 */
public class MyMenu extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
	}

	/**
	 * 创建菜单 itemId=0 关于 itemId=1 离开
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add(0, 0, 0, R.string.menu_app_about);
		menu.add(0, 1, 1, R.string.common_str_exit);
		return super.onCreateOptionsMenu(menu);
	}

	/**
	 * 选择菜单事件
	 */
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		super.onOptionsItemSelected(item);
		switch (item.getItemId()) {
		case 0:
			openOptionsDialog();
			break;
		case 1:
			exitOptionsDialog();
			break;
		}
		return true;
	}

	/**
	 * 弹出对话框
	 */
	private void openOptionsDialog() {
		new AlertDialog.Builder(this).setTitle(R.string.menu_app_about).setMessage(R.string.app_name).setPositiveButton(R.string.common_dialog_ok, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
			}
		}).show();
	}

	/**
	 * 离开确认
	 */
	private void exitOptionsDialog() {
		new AlertDialog.Builder(this).setTitle(R.string.common_str_exit).setMessage(R.string.common_str_exit).setNegativeButton(R.string.common_str_exit, new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TODO Auto-generated method stub

			}
		}).setPositiveButton(R.string.common_dialog_ok, new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				finish();
			}
		}).show();
	}

}
