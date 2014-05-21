package com.x.Ex;

import java.text.DecimalFormat;
import java.text.NumberFormat;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

/**
 * <p>
 * Description:显示计算体重结果
 * </p>
 * 
 * @author Chenkm
 * @version 1.0
 * @date 2014年5月20日
 */
public class Weight2 extends Activity implements OnClickListener {
	
	private Bundle bundle;
	private Intent intent;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.weight2);

		// 取得Intent 中的 Bundle对象
		intent=this.getIntent();
		bundle = intent.getExtras();

		// 取得Bundle 对象中的数据
		String sex = bundle.getString("sex");
		double height = bundle.getDouble("height");

		// 判断性别
		String sexText = "";
		if (sex.equals("M")) {
			sexText = "男性";
		} else {
			sexText = "女性";
		}

		// 取得标准体重
		String weight = this.getWeight(sex, height);

		// 设置显示的文字
		TextView tv = (TextView) findViewById(R.id.tv_weight2_context);
		tv.setText("你是一位" + sexText + "\n 你身高是：" + height + "厘米\n 你的标准体重是：" + weight + "公斤");

		Button back = (Button) findViewById(R.id.btn_weight2_back);
		back.setOnClickListener(this);
	}

	/**
	 * 四舍五入
	 * 
	 * @param num
	 * @return
	 */
	private String format(double num) {
		NumberFormat formatter = new DecimalFormat("0.00");
		return formatter.format(num);
	}

	/**
	 * 计算体重
	 * 
	 * @param sex
	 * @param height
	 * @return
	 */
	private String getWeight(String sex, double height) {
		String weight = "";
		if (sex.equals("M")) {
			weight = format((height - 80) * 0.7);
		} else {
			weight = format((height - 70) * 0.6);
		}
		return weight;
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_weight2_back) {
//			Intent intent = new Intent();
//			intent.setClass(Weight2.this, Weight1.class);
			// startActivity(intent);
			// 返回result回上一个activity
			Weight2.this.setResult(RESULT_OK, intent);
			Weight2.this.finish();
		}
	}

}
