package com.shernan.apphysicscalc;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.support.v4.app.NavUtils;
import android.widget.TextView;
import android.widget.EditText;

public class Calc extends Activity {
	//A number to signify which equation we have
	private int eqNum;
	
	//Variable fields
	private EditText var1, var2, var3, var4;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_calc);
		// Show the Up button in the action bar.
		//getActionBar().setDisplayHomeAsUpEnabled(true);
		
		var1 = ((EditText)findViewById(R.id.varfield1));
		var2 = ((EditText)findViewById(R.id.varfield2));
		var3 = ((EditText)findViewById(R.id.varfield3));
		var4 = ((EditText)findViewById(R.id.varfield4));
		
		//Need to receive data from previous activity
		Intent i = getIntent();
		
		//Setting text to appropriate fields
		((TextView)findViewById(R.id.equation)).setText(i.getStringExtra(EqSelect.EQ));
		
		//Setting hints to variable names
		var1.setHint(i.getStringExtra(EqSelect.VAR1));
		var2.setHint(i.getStringExtra(EqSelect.VAR2));
		var3.setHint(i.getStringExtra(EqSelect.VAR3));
		var4.setHint(i.getStringExtra(EqSelect.VAR4));
		
		//Need to get Equation Number
		eqNum = i.getIntExtra(EqSelect.EQNUM, 0);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_calc, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void startCalc(View v){
		//Reset any non-inputted strings to 0.0
		stringToZero();
		
		//Gathering all variables
		double v1 = Double.parseDouble(var1.getText().toString());
		double v2 = Double.parseDouble(var2.getText().toString());
		double v3 = Double.parseDouble(var3.getText().toString());
		double v4 = Double.parseDouble(var4.getText().toString());
		
		//Use CalcSelector class
		Double result = Double.valueOf(CalcSelector.calc(v1, v2, v3, v4, eqNum));
		((TextView)findViewById(R.id.ans)).setText(result.toString());
	}
	
	public void stringToZero(){
		if(var1.getText().toString().equals(""))
			var1.setText("0");
		
		if(var2.getText().toString().equals(""))
			var2.setText("0");
		
		if(var3.getText().toString().equals(""))
			var3.setText("0");
		
		if(var4.getText().toString().equals(""))
			var4.setText("0");
	}

}
