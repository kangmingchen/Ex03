package com.x.Ex.calculator;

import com.x.Ex.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * <p>
 * Description:简易计算器
 * </p>
 * 
 * @author Chenkm
 * @version 1.0
 * @date 2014年5月21日
 */
public class Calculator extends Activity implements OnClickListener {

	private Button add;
	private Button reduce;
	private Button multiply;
	private Button divide;

	private EditText et1;
	private EditText et2;
	private TextView sign;
	private TextView result;

	private String strRet;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.caculator);

		add = (Button) findViewById(R.id.btn_caculator_add);
		reduce = (Button) findViewById(R.id.btn_caculator_reduce);
		multiply = (Button) findViewById(R.id.btn_calculator_multiply);
		divide = (Button) findViewById(R.id.btn_calculator_divide);


		add.setOnClickListener(this);
		reduce.setOnClickListener(this);
		multiply.setOnClickListener(this);
		divide.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		sign = (TextView) findViewById(R.id.tv_calcultator_sign);
		result = (TextView) findViewById(R.id.tv_calculator_result);
		et1 = (EditText) findViewById(R.id.et_calculator_text1);
		et2 = (EditText) findViewById(R.id.et_calculator_text2);
		int id = v.getId();
		switch (id) {
		case R.id.btn_caculator_add:
			sign.setText("+");
			strRet = Integer.toString(Integer.parseInt(et1.getText().toString()) + Integer.parseInt(et2.getText().toString()));
			result.setText(strRet);
			break;
		case R.id.btn_caculator_reduce:
			sign.setText("-");
			strRet = Integer.toString(Integer.parseInt(et1.getText().toString()) - Integer.parseInt(et2.getText().toString()));
			result.setText(strRet);
			break;
		case R.id.btn_calculator_divide:
			sign.setText("/");
			strRet = Integer.toString(Integer.parseInt(et1.getText().toString()) / Integer.parseInt(et2.getText().toString()));
			result.setText(strRet);
			break;
		case R.id.btn_calculator_multiply:
			sign.setText("X");
			strRet = Integer.toString(Integer.parseInt(et1.getText().toString()) * Integer.parseInt(et2.getText().toString()));
			result.setText(strRet);
			break;
		default:
			break;
		}
	}

}
