package com.x.Ex;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * <p>
 * Description:
 * </p>
 * 
 * @author Chenkm
 * @version 1.0
 * @date 2014年5月20日
 */
public class Second extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.second);

		Button b2 = (Button) findViewById(R.id.btn_second_activity);
		b2.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.btn_second_activity) {
			Intent intent = new Intent();
			intent.setClass(Second.this, Main.class);

			startActivity(intent);
			Second.this.finish();
		}
	}

}
