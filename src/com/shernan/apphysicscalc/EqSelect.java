package com.shernan.apphysicscalc;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EqSelect extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_eq_select);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_eq_select, menu);
		return true;
	}

}
