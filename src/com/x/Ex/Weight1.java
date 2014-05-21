package com.x.Ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

/**
 * <p>
 * Description:计算体重
 * </p>
 * 
 * @author Chenkm
 * @version 1.0
 * @date 2014年5月20日
 */
public class Weight1 extends Activity implements OnClickListener {

	private EditText et;
	private RadioButton rb1;
	private RadioButton rb2;

	private Button submit;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.weight1);
		submit = (Button) findViewById(R.id.btn_weight1_submit);
		submit.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_weight1_submit) {
			// 取得输入的身高
			et = (EditText) findViewById(R.id.et_weight1_height);
			double height = Double.parseDouble(et.getText().toString());
			// 取得选择的性别
			String sex = "";
			rb1 = (RadioButton) findViewById(R.id.rb_weight1_sex_man);
			rb2 = (RadioButton) findViewById(R.id.rb_weight1_sex_woman);
			if (rb1.isChecked()) {
				sex = "M";
			} else {
				sex = "F";
			}

			// new 一个Intent对象，并指定class
			Intent intent = new Intent();
			intent.setClass(Weight1.this, Weight2.class);

			// new 一个Bundle对象，并将要传递的数据传入
			Bundle bundle = new Bundle();
			bundle.putDouble("height", height);
			bundle.putString("sex", sex);

			// 将Bundle对象 assign给Intent
			intent.putExtras(bundle);
			// 调用Activity Weight2
//			startActivity(intent);
			
			//返回数据到前一个Activity
			//其中RequestCode 为自定义字段，为下一个Activity要返回值的依据
			startActivityForResult(intent, 0);
		}
	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		switch (resultCode) {
		case RESULT_OK:
			/*取来自Activity2的数据，并显示与画面上*/
			Bundle bundle=data.getExtras();
			String sex=bundle.getString("sex");
			double height=bundle.getDouble("height");
			
			et.setText(""+height);
			if(sex.equals("M")){
				rb1.setChecked(true);
			}else{
				rb2.setChecked(true);
			}
			break;

		default:
			break;
		}
	}
	
	

}
